package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportedReplyDTO {
    private Long id;
    private Long postReplyId;
    private Long postCommentId;
    private Long postId;
    private String postTitle;
    private String postReplyContent;
    private String reportedUserNickname;
    private String reporterNickname;
    private String postReplyReportContent;
    private Date reportDate;
    private String status;
}
