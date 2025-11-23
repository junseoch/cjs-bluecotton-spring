package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.post.AdminPostDetailDTO;
import com.app.bluecotton.domain.dto.post.AdminPostListDTO;

import java.util.List;

public interface AdminPostService {

    List<AdminPostListDTO> selectAdminPostList();

    AdminPostDetailDTO selectPostDetail(Long id);

    void delete(Long id);
}
