package com.app.bluecotton.domain.dto;

import com.app.bluecotton.domain.vo.post.PostDraftVO;
import com.app.bluecotton.domain.vo.som.SomVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPagePostSaveDTO {
//    SELECT TBD.ID, TBD.POST_DRAFT_TITLE, TBD.POST_DRAFT_CREATE_AT, TBS.SOM_CATEGORY
    private Long id;
    private String postDraftTitle;
    private String somCategory;
    private Date postCreateAt;

    public MyPagePostSaveDTO(PostDraftVO postDraftVO, SomVO somVO) {
        this.id = postDraftVO.getId();
        this.postDraftTitle = postDraftVO.getPostDraftTitle();
        this.postCreateAt = postDraftVO.getPostDraftCreateAt();
        this.somCategory = somVO.getSomCategory();

    }
}
