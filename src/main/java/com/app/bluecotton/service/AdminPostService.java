package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.post.AdminPostDetailDTO;
import com.app.bluecotton.domain.dto.post.AdminPostListDTO;

import java.util.List;

public interface AdminPostService {

    public List<AdminPostListDTO> selectAdminPostList();

    public AdminPostDetailDTO selectPostDetail(Long id);

    public void delete(Long id);
}
