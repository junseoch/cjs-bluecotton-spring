package com.app.bluecotton.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductReviewStatsResponseDTO {

    private double avgScore;
    private long totalCount;
    private long count5;
    private long count4;
    private long count3;
    private long count2;
    private long count1;

}
