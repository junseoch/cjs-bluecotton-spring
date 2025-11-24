package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.*;
import com.app.bluecotton.repository.MyPagePostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPagePostServiceImpl implements MyPagePostService {
    private final MyPagePostDAO myPagePostDAO;

    //    마이페이지 내가 쓴 글
    @Override
    public List<MyPagePostWriteDTO> readPostWrite(Long id) {
        return myPagePostDAO.readPostWrite(id);
    }

    //    마이페이지 내가 좋아요한 글
    @Override
    public List<MyPagePostLikeDTO> readPostLike(Long id) {
        return myPagePostDAO.readPostLike(id);
    }

    //    마이페이지 내가 쓴 댓글과 대댓글
    @Override
    public List<MyPagePostCommentDTO> readPostComment(Long id) {
        return myPagePostDAO.readPostComment(id);
    }

    //    마이페이지 내가 임시저장한 글
    @Override
    public List<MyPagePostSaveDTO> readPostSave(Long id) {
        return myPagePostDAO.readPostSave(id);
    }

    //    마이페이지 내가 최근에 본 글
    @Override
    public List<MyPagePostRecentDTO> readPostRecent(Long id) {
        return myPagePostDAO.readPostRecent(id);
    }

    //    내가 작성한 글 삭제
    @Override
    public void deletePostWrite(Long id){ myPagePostDAO.deletePostWrite(id); };

    //    내가 좋아요한 글 삭제
    @Override
    public void deletePostLike(Long id){ myPagePostDAO.deletePostLike(id); };

    //    내가 단 댓글 삭제
    @Override
    public void deletePostComment(Long id){ myPagePostDAO.deletePostComment(id); };

    //    내가 단 대댓글 삭제
    @Override
    public void deletePostReply(Long id){ myPagePostDAO.deletePostReply(id); };

    //    내가 임시저장한 글 삭제
    @Override
    public void deletePostSave(Long id){ myPagePostDAO.deletePostSave(id); };

    //    내가 최근에 본 글 삭제
    @Override
    public void deletePostRecent(Long memberId, Long postId){ myPagePostDAO.deletePostRecent(memberId, postId); };
}
