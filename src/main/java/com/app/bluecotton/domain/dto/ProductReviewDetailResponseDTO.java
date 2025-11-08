package com.app.bluecotton.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductReviewDetailResponseDTO {

    private Long id;
    private Integer productReviewRating;
    private String productReviewContent;
    private String productReviewDate;
    private String userNickName;
    private String productReviewImageUrls;
    private String memberProfileUrl;

}
