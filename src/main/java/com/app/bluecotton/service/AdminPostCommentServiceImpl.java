package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.ReportedCommentDTO;
import com.app.bluecotton.repository.AdminPostCommentDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AdminPostCommentServiceImpl implements AdminPostCommentService {

    private final AdminPostCommentDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<ReportedCommentDTO> getReportedComments() {
        return dao.findReportedComments();
    }

    @Override
    public void deleteCommentAsAdmin(Long commentId) {
        dao.deleteCommentCascade(commentId);
    }

    @Override
    public void deleteReplyAsAdmin(Long replyId) {

        dao.deleteReplyCascade(replyId);
    }
}

