package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.shop.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAndPaymentRequest {
    private Long orderId;
    private Long memberId;
    private Integer orderTotalPrice;

    private String paymentStatus;

    private String deliveryReceiverName;
    private String deliveryReceiverPhone;
    private String deliveryAddress;
    private String deliveryRequest;
    private DeliveryStatus deliveryStatus;
}
