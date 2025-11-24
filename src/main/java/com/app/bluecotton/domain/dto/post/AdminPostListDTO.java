package com.app.bluecotton.domain.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPostListDTO {
    private Long id;
    private String postTitle;
    private Date postCreateAt;
    private Long postReadCount;
    private Long postLikeCount;
    private String memberNickname;
}
