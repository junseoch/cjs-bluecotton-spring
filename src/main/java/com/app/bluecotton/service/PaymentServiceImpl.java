package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.*;
import com.app.bluecotton.domain.vo.shop.DeliveryStatus;
import com.app.bluecotton.domain.vo.shop.DeliveryVO;
import com.app.bluecotton.domain.vo.shop.OrderVO;
import com.app.bluecotton.domain.vo.shop.PaymentSocialVO;
import com.app.bluecotton.domain.vo.shop.PaymentStatus;
import com.app.bluecotton.domain.vo.shop.PaymentVO;
import com.app.bluecotton.repository.DeliveryDAO;
import com.app.bluecotton.repository.OrderDAO;
import com.app.bluecotton.repository.PaymentDAO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDAO paymentDAO;
    private final PaymentSocialService paymentSocialService;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final OrderDAO orderDAO;
    private final OrderService orderService;
    private final DeliveryDAO deliveryDAO;

    private static final String PORTONE_API_BASE_URL = "https://api.iamport.kr";
    private static final String GET_TOKEN_URL = PORTONE_API_BASE_URL + "/users/getToken";
    private static final String GET_PAYMENT_INFO_URL = PORTONE_API_BASE_URL + "/payments/{imp_uid}";
    private static final String PREPARE_PAYMENT_URL = PORTONE_API_BASE_URL + "/payments/prepare";

    @Value("${portone.imp-key}")
    private String impKey;

    @Value("${portone.imp-secret}")
    private String impSecret;

    private String getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("imp_key", impKey);
        body.put("imp_secret", impSecret);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> res = restTemplate.exchange(
                    GET_TOKEN_URL, HttpMethod.POST, entity, String.class);

            if (res.getStatusCode() == HttpStatus.OK && res.getBody() != null) {
                JsonNode root = objectMapper.readTree(res.getBody());
                if (root.get("code").asInt() == 0) {
                    return root.get("response").get("access_token").asText();
                }
            }
            throw new RuntimeException("PortOne Access Token 발급 실패");
        } catch (Exception e) {
            throw new RuntimeException("토큰 발급 실패", e);
        }
    }

    private String generateMerchantUid(Long orderId) {
        return "ORD_" + orderId + "_" +
                UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private PortOneDTO getPaymentInfoFromPortOne(String accessToken, String impUid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        Map<String, String> uri = Collections.singletonMap("imp_uid", impUid);

        try {
            ResponseEntity<PortOneDTO> res = restTemplate.exchange(
                    GET_PAYMENT_INFO_URL, HttpMethod.GET, entity, PortOneDTO.class, uri);

            PortOneDTO dto = res.getBody();

            if (dto == null || dto.getCode() != 0) {
                throw new RuntimeException("결제 정보 조회 실패");
            }

            return dto;
        } catch (Exception e) {
            throw new RuntimeException("PortOne 결제 조회 오류", e);
        }
    }

    private void verifyPayment(String merchantUid, PortOneDTO info) {
        Long dbAmount = paymentDAO.findExpectedAmountByMerchantUid(merchantUid);

        if (dbAmount == null || dbAmount <= 0) {
            throw new RuntimeException("예상 결제 금액 없음");
        }

        Long actualAmount = info.getResponse().getAmount();
        String status = info.getResponse().getStatus();

        if (!"paid".equals(status)) {
            throw new RuntimeException("결제 상태 오류");
        }

        if (!Objects.equals(dbAmount, actualAmount)) {
            throw new RuntimeException("결제 금액 불일치");
        }
    }

    @Override
    public PortOneDTO processPayment(Map<String, Object> paymentData) {
        String impUid = (String) paymentData.get("imp_uid");
        String merchantUid = (String) paymentData.get("merchant_uid");

        if (impUid == null || merchantUid == null) {
            throw new IllegalArgumentException("결제 검증 데이터 누락");
        }

        String accessToken = getAccessToken();
        PortOneDTO info = getPaymentInfoFromPortOne(accessToken, impUid);

        verifyPayment(merchantUid, info);

        Long amount = info.getResponse().getAmount();

        int updated = paymentDAO.markSuccessByMerchantUid(
                merchantUid, impUid, amount, PaymentStatus.COMPLETED);

        if (updated == 0) {
            throw new RuntimeException("결제 DB 업데이트 실패");
        }

        PaymentVO payment = paymentDAO.findByMerchantUid(merchantUid)
                .orElseThrow(() -> new RuntimeException("Payment 조회 실패"));

        Long orderId = payment.getOrderId();
        Long memberId = payment.getMemberId();

        if (orderId != null && memberId != null) {
            orderDAO.updateOrderStatus(orderId, memberId, 'Y');
        }

        PaymentSocialVO social = new PaymentSocialVO();
        social.setPaymentId(payment.getId());
        social.setPaymentSocialName(info.getResponse().getPgProvider());
        social.setPaymentSocialNumber(impUid);
        paymentSocialService.create(social);

        return info;
    }

    @Override
    public PaymentPrepareResponse preparePayment(PaymentPrepareRequest request) {
        Long amount = request.getAmount();
        Long memberId = request.getMemberId();
        Long orderId = request.getOrderId();

        String merchantUid = generateMerchantUid(orderId);

        PaymentVO vo = new PaymentVO();
        vo.setPaymentPrice(amount.intValue());
        vo.setPaymentType(request.getPaymentType());
        vo.setPaymentStatus(PaymentStatus.PENDING);
        vo.setOrderId(orderId);
        vo.setMemberId(memberId);
        vo.setMerchantUid(merchantUid);

        paymentDAO.save(vo);

        String accessToken = getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("merchant_uid", merchantUid);
        body.put("amount", amount);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        restTemplate.exchange(PREPARE_PAYMENT_URL, HttpMethod.POST, entity, String.class);

        return PaymentPrepareResponse.builder()
                .merchantUid(merchantUid)
                .amount(amount)
                .build();
    }

    @Override
    public void verifyPayment(PaymentVerifyRequest request) {
        String impUid = request.getImpUid();
        String merchantUid = request.getMerchantUid();
        Long memberId = request.getMemberId();

        Map<String, Object> data = new HashMap<>();
        data.put("imp_uid", impUid);
        data.put("merchant_uid", merchantUid);

        processPayment(data);

        if (memberId != null) {
            orderService.clearCartAfterOrder(memberId);
        }
    }

    @Override
    public void payWithCandy(Long memberId, Long orderId) {
        OrderVO order = orderDAO.selectOrderById(orderId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("주문 없음"));

        int amount = Math.toIntExact(order.getOrderTotalPrice());

        int current = paymentDAO.selectMemberCandy(memberId);
        if (current < amount) throw new IllegalStateException("캔디 부족");

        paymentDAO.updateMemberCandy(memberId, amount);

        PaymentVO payment = new PaymentVO();
        payment.setMemberId(memberId);
        payment.setOrderId(orderId);
        payment.setPaymentPrice(amount);
        payment.setPaymentType("CANDY");
        payment.setPaymentStatus(PaymentStatus.COMPLETED);

        paymentDAO.save(payment);
    }

    @Override
    public List<MyShopOrderDTO> findCompletedOrdersByMemberId(Long memberId) {
        return paymentDAO.findCompletedOrdersByMemberId(memberId);
    }
}
