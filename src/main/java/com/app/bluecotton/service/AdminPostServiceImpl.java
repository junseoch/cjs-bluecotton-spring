package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.post.AdminPostDetailDTO;
import com.app.bluecotton.domain.dto.post.AdminPostListDTO;
import com.app.bluecotton.repository.AdminPostDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class AdminPostServiceImpl implements AdminPostService {

    private final AdminPostDAO adminPostDAO;
    private final PostService postService;

    @Override
    public List<AdminPostListDTO> selectAdminPostList() {
        return adminPostDAO.selectAdminPostList();
    }

    @Override
    public AdminPostDetailDTO selectPostDetail(Long id) {
        return adminPostDAO.selectPostDetail(id);
    }

    @Override
    public void delete(Long id) {
        postService.withdraw(id);
    }
}
