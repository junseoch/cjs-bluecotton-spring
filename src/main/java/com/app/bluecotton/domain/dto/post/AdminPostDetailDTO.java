package com.app.bluecotton.domain.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPostDetailDTO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Date postCreateAt;
    private Long postReadCount;
    private String memberNickname;

    private List<PostImageDTO> images;
}
