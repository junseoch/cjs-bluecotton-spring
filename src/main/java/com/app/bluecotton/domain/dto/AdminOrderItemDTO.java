package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrderItemDTO {
    private Long id;
    private Long productId;
    private String productName;
    private Integer productPrice;
    private Integer orderQuantity;
}
