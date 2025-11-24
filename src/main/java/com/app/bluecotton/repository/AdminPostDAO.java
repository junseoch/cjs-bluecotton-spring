package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.post.AdminPostDetailDTO;
import com.app.bluecotton.domain.dto.post.AdminPostListDTO;
import com.app.bluecotton.domain.dto.post.PostImageDTO;
import com.app.bluecotton.mapper.AdminPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminPostDAO {

    private final AdminPostMapper adminPostMapper;

    public List<AdminPostListDTO> selectAdminPostList() {
        return adminPostMapper.selectAdminPostList();
    }

    public AdminPostDetailDTO selectPostDetail(Long id) {
        return adminPostMapper.selectPostDetail(id);
    }

    public List<PostImageDTO> selectPostImages(Long id) {
        return adminPostMapper.selectPostImages(id);
    }

    public void delete(Long id) {
        adminPostMapper.deletePostLikesByPostId(id);
        adminPostMapper.deletePostImagesByPostId(id);
        adminPostMapper.deleteRecentPostsByPostId(id);
        adminPostMapper.delete(id);
    }
}
