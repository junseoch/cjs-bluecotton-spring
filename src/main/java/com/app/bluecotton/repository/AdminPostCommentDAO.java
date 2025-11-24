package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.ReportedCommentDTO;
import com.app.bluecotton.mapper.AdminPostCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminPostCommentDAO {

    private final AdminPostCommentMapper mapper;


    public List<ReportedCommentDTO> findReportedComments() {
        return mapper.selectReportedComments();
    }


    public void deleteCommentCascade(Long commentId) {

        mapper.deleteRepliesByCommentId(commentId);

        mapper.deleteCommentLikesByCommentId(commentId);

        mapper.deleteCommentReportsByCommentId(commentId);

        mapper.deleteCommentByCommentId(commentId);
    }


    public void deleteCommentsByPostIdCascade(Long postId) {
        mapper.deleteRepliesByPostId(postId);
        mapper.deleteCommentLikesByPostId(postId);
        mapper.deleteCommentReportsByPostId(postId);
        mapper.deleteCommentsByPostId(postId);
    }


    public void deleteReplyCascade(Long replyId) {

        mapper.deleteReplyLikesByReplyId(replyId);

        mapper.deleteReplyReportsByReplyId(replyId);

        mapper.deleteReplyById(replyId);
    }
}

