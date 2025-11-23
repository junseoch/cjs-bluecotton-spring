package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRequest {

    private Long orderId;
    private Long memberId;
    private String deliveryReceiverName;
    private String deliveryReceiverPhone;
    private String deliveryAddress;
    private String deliveryRequest;
    private String deliveryStatus;
}
