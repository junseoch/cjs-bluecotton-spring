package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.shop.DeliveryStatus;
import com.app.bluecotton.domain.vo.shop.ProductPurchaseType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDeliveryListDTO {
    private Long id;
    private Long orderId;
    private Long memberId;
    private String memberNickname;
    private Integer memberCandy;
    private String productPurchaseType;
    private String deliveryReceiverName;
    private String deliveryReceiverPhone;
    private String deliveryAddress;
    private String deliveryRequest;
    private Integer paymentPrice;
    private DeliveryStatus deliveryStatus;
    private Date paymentCreateAt;

    private List<AdminOrderItemDTO> adminOrderItemDTOList;
}
