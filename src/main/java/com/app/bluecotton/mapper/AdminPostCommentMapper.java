package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.ReportedCommentDTO;
import com.app.bluecotton.domain.dto.ReportedReplyDTO;
import com.app.bluecotton.domain.vo.post.PostCommentReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminPostCommentMapper {

    void insertCommentReport(PostCommentReportVO vo);

    List<ReportedCommentDTO> selectReportedComments();

    List<ReportedReplyDTO> selectReportedReplies();


    void deleteCommentLikesByCommentId( Long commentId);
    void deleteCommentReportsByCommentId( Long commentId);
    void deleteRepliesByCommentId( Long commentId);
    void deleteCommentByCommentId(Long commentId);


    void deleteReplyLikesByReplyId( Long replyId);
    void deleteReplyReportsByReplyId( Long replyId);
    void deleteReplyById( Long replyId);

    void deleteRepliesByPostId( Long postId);
    void deleteCommentLikesByPostId( Long postId);
    void deleteCommentReportsByPostId( Long postId);
    void deleteCommentsByPostId( Long postId);
}
