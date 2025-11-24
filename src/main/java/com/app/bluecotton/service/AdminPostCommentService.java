package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.ReportedCommentDTO;

import java.util.List;

public interface AdminPostCommentService {
    public List<ReportedCommentDTO> getReportedComments();

    public void deleteCommentAsAdmin(Long commentId);

    public void deleteReplyAsAdmin(Long replyId);
}
