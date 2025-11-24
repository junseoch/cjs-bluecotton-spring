package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.DeliveryAndPaymentRequest;
import com.app.bluecotton.domain.dto.PaymentPrepareRequest;
import com.app.bluecotton.domain.vo.shop.DeliveryVO;
import com.app.bluecotton.mapper.DeliveryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class OrderPaymentService {

    private final DeliveryMapper deliveryMapper;
    private final PaymentService paymentService; // 네가 원래 쓰는 결제 서비스 이름으로 맞춰줘

    public PaymentPrepareRequest saveDeliveryAndPreparePayment(DeliveryAndPaymentRequest req) {

        // 1. 배송지 INSERT
        DeliveryVO delivery = new DeliveryVO();
        delivery.setOrderId(req.getOrderId());
        delivery.setMemberId(req.getMemberId());
        delivery.setDeliveryReceiverName(req.getDeliveryReceiverName());
        delivery.setDeliveryReceiverPhone(req.getDeliveryReceiverPhone());
        delivery.setDeliveryAddress(req.getDeliveryAddress()); // ✅ addr1/addr2 없음
        delivery.setDeliveryRequest(req.getDeliveryRequest());
        delivery.setDeliveryStatus(req.getDeliveryStatus());   // 필요하면 기본값 READY 같은 걸로 바꿔도 됨

        deliveryMapper.insert(delivery);

        // 2. 결제 준비용 merchantUid 생성
        String merchantUid = "BC_" + req.getOrderId() + "_" + System.currentTimeMillis();

        // 3. PaymentPrepareRequest 생성 (여기서 orderTotalPrice → amount 매핑)
        PaymentPrepareRequest paymentReq = PaymentPrepareRequest.builder()
                .orderId(req.getOrderId())
                .memberId(req.getMemberId())
                .amount(req.getOrderTotalPrice() != null
                        ? req.getOrderTotalPrice().longValue()
                        : 0L)
                .paymentType(req.getPaymentStatus()) // 🔹 paymentStatus 이름이지만 결국 type 역할
                .merchantUid(merchantUid)
                .build();

        // 4. ❗❗ 여기서 중요한 부분: 파라미터 1개만 넘기기 ❗❗
        //    (에러 메시지 "1개의 인수가 필요하지만 5개 발견" 해결)
        paymentService.preparePayment(paymentReq);
        // 또는 네 실제 메서드 시그니처에 맞게:
        // paymentService.prepare(paymentReq);
        // paymentService.preparePortOne(paymentReq);
        // → 이름만 네 프로젝트에 맞게 고치면 됨

        // 프론트에서 merchantUid, amount 쓰게 돌려주고 싶으면 그대로 return
        return paymentReq;
    }
}
