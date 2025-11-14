    package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.som.SomCheckImageVO;
import com.app.bluecotton.domain.vo.som.SomCheckVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPageSomCheckDTO {
    // TBL_SOM_CHECK
    private Long somCheckId;
    private Boolean somCheckIsChecked;
    public String getSomCheckIsCheckedYn() {
        return Boolean.TRUE.equals(somCheckIsChecked) ? "Y" : "N";
    }
    private String somCheckContent;
    private Long memberId;
    private Long somId;

    // TBL_SOM_CHECK_IMAGE 리스트
    private List<MyPageSomCheckImageDTO> images;   // ★ 이미지 DTO 리스트로 묶기

}
