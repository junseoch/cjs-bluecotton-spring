package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminReportedPostDTO {
    private Long postId;
    private String postTitle;
    private String writerNickname;
    private Long reportCount;
    private Date lastReportAt;

}
