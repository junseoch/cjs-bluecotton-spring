package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.post.PostMainDTO;
import com.app.bluecotton.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostDAO {
    private final PostMapper postMapper;

//    게시글 목록 조회
    public List<PostMainDTO> findPosts(String somCategory, String orderType, Long memberId) {
        return postMapper.select(somCategory, orderType, memberId);
    }


}
