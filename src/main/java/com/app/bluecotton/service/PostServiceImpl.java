package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.post.PostMainDTO;
import com.app.bluecotton.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

//    게시판 목록 조회 서비스
    @Override
    public List<PostMainDTO> getPosts(String somCategory, String orderType, Long memberId) {
        return postDAO.findPosts(somCategory, orderType, memberId);
    }
}
