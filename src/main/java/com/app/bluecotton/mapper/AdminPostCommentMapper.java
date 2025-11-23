package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.ReportedCommentDTO;
import com.app.bluecotton.domain.vo.post.PostCommentReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminPostCommentMapper {


    public void insertCommentReport(PostCommentReportVO vo);


    public List<ReportedCommentDTO> selectReportedComments();


    public void deleteCommentLikesByCommentId(@Param("commentId") Long commentId);
    public void deleteCommentReportsByCommentId(@Param("commentId") Long commentId);
    public void deleteRepliesByCommentId(@Param("commentId") Long commentId);
    public void deleteCommentByCommentId(@Param("commentId") Long commentId);


    public void deleteReplyById(@Param("replyId") Long replyId);

    public void deleteRepliesByPostId(@Param("postId") Long postId);
    public void deleteCommentLikesByPostId(@Param("postId") Long postId);
    public void deleteCommentReportsByPostId(@Param("postId") Long postId);
    public void deleteCommentsByPostId(@Param("postId") Long postId);
}