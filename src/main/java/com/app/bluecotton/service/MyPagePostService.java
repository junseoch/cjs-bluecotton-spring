package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.*;

import java.util.List;

public interface MyPagePostService {

    //    마이페이지 내가 쓴 글
    public List<MyPagePostWriteDTO> readPostWrite(Long id);
    //    마이페이지 내가 좋아요한 글
    public List<MyPagePostLikeDTO> readPostLike(Long id);
    //    마이페이지 내가 쓴 댓글과 대댓글
    public List<MyPagePostCommentDTO> readPostComment(Long id);
    //    마이페이지 내가 임시저장한 글
    public List<MyPagePostSaveDTO> readPostSave(Long id);
    //    마이페이지 내가 최근에 본 글
    public List<MyPagePostRecentDTO> readPostRecent(Long id);
    //    내가 작성한 글 삭제
    public void deletePostWrite(Long id);
    //    내가 좋아요한 글 삭제
    public void deletePostLike(Long id);
    //    내가 단 댓글 삭제
    public void deletePostComment(Long id);
    //    내가 단 대댓글 삭제
    public void deletePostReply(Long id);
    //    내가 임시저장한 글 삭제
    public void deletePostSave(Long id);
    //    내가 최근에 본 글 삭제
    public void deletePostRecent(Long memberId, Long postId);
}
