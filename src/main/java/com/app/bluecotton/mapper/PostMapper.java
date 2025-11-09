package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.post.*;
import com.app.bluecotton.domain.vo.post.PostCommentVO;
import com.app.bluecotton.domain.vo.post.PostDraftVO;
import com.app.bluecotton.domain.vo.post.PostReplyVO;
import com.app.bluecotton.domain.vo.post.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper

public interface PostMapper {
//    게시물 목록 조회
    List<PostMainDTO> select(
            @Param("somCategory") String somCategory,
            @Param("orderType") String orderType,
            @Param("memberId") Long memberId
    );

//    게시물 추가
    void insert(PostVO postVO);

//    게시물 등록 검사
    int existsTodayPostInSom(@Param("memberId") Long memberId, @Param("somId") Long somId);

//    이미지 url 등록
    void updatePostIdByUrl(@Param("url") String url, @Param("postId") Long postId);

//    기본 이미지 등록
    void insertDefaultImage(
        @Param("postImagePath") String postImagePath,
        @Param("postImageName") String postImageName,
        @Param("postId") Long postId);

//    썸네일 이미지 등록
    void insertThumbnail(@Param("url") String url, @Param("postId") Long postId);

//    게시글 삭제
    void deletePostById(Long postId);
//    게시글 좋아요 삭제
    void deleteLikesByPostId(Long postId);
//    이미지 삭제
    void deletePostImages(Long postId);
//    신고 삭제
    void deleteReportsByPostId(Long postId);
//    최근본 삭제
    void deleteRecentsByPostId(Long postId);

    //    임시저장 등록
    void insertDraft(PostDraftVO postDraftVO);

    //    임시저장 조회 (이어쓰기용)
    PostDraftVO selectDraftById(Long id);

    //    임시저장 삭제 (마이페이지 or 작성완료 후 삭제용)
    void deleteDraftById(Long id);

//    회원이 참여 중인 솜 카테고리 조회 (드롭다운용)
    List<SomCategoryDTO> findJoinedCategories(Long memberId);

    // 게시글 수정 조회
    PostModifyDTO findByIdForUpdate(@Param("id") Long id);

    // 게시글 수정
    void update(PostVO postVO);

    // 게시글 상세 조회
    PostDetailDTO selectPostDetailByIdWithLike(@Param("postId") Long postId, @Param("memberId") Long memberId);

    // 댓글 / 대댓글 조회
    List<PostCommentDTO> selectCommentsByPostIdWithLike(@Param("postId") Long postId, @Param("memberId") Long memberId);
    List<PostReplyDTO> selectRepliesByCommentIdWithLike(@Param("commentId") Long commentId, @Param("memberId") Long memberId);

    // 좋아요 토글 / 여부 체크
    int existsCommentLike(@Param("commentId") Long commentId, @Param("memberId") Long memberId);
    int existsReplyLike(@Param("replyId") Long replyId, @Param("memberId") Long memberId);

    void insertCommentLike(@Param("commentId") Long commentId, @Param("memberId") Long memberId);
    void deleteCommentLike(@Param("commentId") Long commentId, @Param("memberId") Long memberId);

    void insertReplyLike(@Param("replyId") Long replyId, @Param("memberId") Long memberId);
    void deleteReplyLike(@Param("replyId") Long replyId, @Param("memberId") Long memberId);


    // 조회수 + 1(상세 조회 시)
    void updateReadCount(Long postId);

    // 최근 본 게시물 추가(상세 조회 시)
    void insertOrUpdateRecentView(Long memberId ,Long postId);

    // 댓글 등록
    void insertComment(PostCommentVO postCommentVO);

    // 답글 등록
    void insertReply(PostReplyVO postReplyVO);

    // 댓글 삭제
    void deleteComment(Long commentId);

    // 답글 삭제
    void deleteReply(Long replyId);

    // 좋아요 여부
    int existsLike(@Param("postId") Long postId, @Param("memberId") Long memberId);

    // 좋아요 등록
    void insertLike(@Param("postId") Long postId, @Param("memberId") Long memberId);

    // 좋아요 삭제
    void deleteLike(@Param("postId") Long postId, @Param("memberId") Long memberId);
}
