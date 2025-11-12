package com.app.bluecotton.domain.dto.post;

import lombok.Data;

@Data
public class SomCategoryDTO {
    private Long id;
    private String somCategory;
    private String somTitle;

    private Integer somDayDiff;
}