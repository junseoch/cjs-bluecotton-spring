package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.post.PostMainDTO;

import java.util.List;

public interface PostService {
    public List<PostMainDTO> getPosts(String somCategory, String orderType, Long memberId);
}
