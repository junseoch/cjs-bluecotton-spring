package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSomCheckResponseDTO {
    private Long id;
    private Long memberId;
    private Long somId;
    private String memberNickname;
    private String somTitle;
    private String somCheckContent;
    private Boolean somCheckIsChecked;
    public String getSomCheckIsCheckedYn() {
        return Boolean.TRUE.equals(somCheckIsChecked) ? "Y" : "N";
    }

    private List<MyPageSomCheckImageDTO> images;

}
