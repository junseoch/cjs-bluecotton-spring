package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportedCommentDTO {
    private Long reportId;
    private Long commentId;
    private Long postId;
    private String postTitle;

    private String commentContent;
    private Date commentCreatedAt;
    private Long commentWriterId;
    private String commentWriterNickname;

    private Long reporterId;
    private String reporterNickname;
    private String reportContent;
    private Date reportCreatedAt;

    private Long reportCount;
}
