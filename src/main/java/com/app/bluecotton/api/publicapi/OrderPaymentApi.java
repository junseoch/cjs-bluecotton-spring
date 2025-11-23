package com.app.bluecotton.api.publicapi;

import com.app.bluecotton.domain.dto.ApiResponseDTO;
import com.app.bluecotton.domain.dto.DeliveryAndPaymentRequest;
import com.app.bluecotton.domain.dto.PaymentPrepareRequest;
import com.app.bluecotton.domain.vo.shop.DeliveryVO;
import com.app.bluecotton.mapper.DeliveryMapper;
import com.app.bluecotton.service.OrderPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/*")
public class OrderPaymentApi {

    private final OrderPaymentService orderPaymentService;
    private final DeliveryMapper  deliveryMapper;

    @PostMapping("orders/{orderId}/delivery-pay/prepare")
    public ResponseEntity<ApiResponseDTO<PaymentPrepareRequest>> saveDeliveryAndPrepare(
            @PathVariable Long orderId,
            @RequestBody DeliveryAndPaymentRequest req
    ) {
        // PathVariable로 받은 orderId를 DTO에 세팅
        req.setOrderId(orderId);

        PaymentPrepareRequest paymentReq = orderPaymentService.saveDeliveryAndPreparePayment(req);

        // data 필드에 paymentReq 그대로 내려줌 (amount, merchantUid 다 포함)
        return ResponseEntity.ok(
                ApiResponseDTO.of("배송지 저장 및 결제 준비 완료", paymentReq)
        );
    }

    @PostMapping("order/delivery")
    public ResponseEntity<?> saveDelivery(@RequestBody DeliveryAndPaymentRequest req) {

        DeliveryVO vo = new DeliveryVO();
        vo.setOrderId(req.getOrderId());
        vo.setMemberId(req.getMemberId());
        vo.setDeliveryReceiverName(req.getDeliveryReceiverName());
        vo.setDeliveryReceiverPhone(req.getDeliveryReceiverPhone());
        vo.setDeliveryAddress(req.getDeliveryAddress());
        vo.setDeliveryRequest(req.getDeliveryRequest());
        vo.setDeliveryStatus(req.getDeliveryStatus()); // 기본값 READY

        deliveryMapper.insert(vo);

        return ResponseEntity.ok(ApiResponseDTO.of("배송지 저장 완료", vo));
    }

}
