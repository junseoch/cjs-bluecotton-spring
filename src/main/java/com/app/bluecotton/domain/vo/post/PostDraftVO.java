package com.app.bluecotton.domain.vo.post;

import lombok.Data;

import java.util.Date;

@Data
public class PostDraftVO {
    private Long id;
    private String postDraftTitle;
    private String postDraftContent;
    private Date postDraftCreateAt;
    private Long memberId;
    private Long somId;
}
