package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.dto.MyPageSomCheckImageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSomCheckDetailDTO {
    private Long id;
    private boolean somCheckIsChecked;
    public String getSomCheckIsCheckedYn(){
        return somCheckIsChecked ? "Y" : "N";
    }

    private String somCheckContent;
    private Long memberId;
    private Long somId;

    private String memberNickname;
    private String memberEmail;
    private String somTitle;
    private String somCategory;

    // LISTAGG 결과를 받을 필드
    private String imageConcat;

    // 서비스에서 파싱해서 채우는 리스트
    private List<MyPageSomCheckImageDTO> images;
}
