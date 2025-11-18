package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminOrderDTO {
    private Long id;
    private Long orderId;
    private Long memberId;
    private String memberNickname;
    private String memberEmail;
    private String productName;
    private Integer orderQuantity;
    private Long orderTotalPrice;
    private String orderStatus;
    private LocalDateTime orderCreateAt;
}
