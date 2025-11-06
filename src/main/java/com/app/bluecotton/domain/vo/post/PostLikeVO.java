package com.app.bluecotton.domain.vo.post;

import lombok.Data;

import java.util.Date;

@Data
public class PostLikeVO {
    private Long postLikeId;
    private Date postLikeCreateAt;
    private Long postId;
    private Long memberId;
}
