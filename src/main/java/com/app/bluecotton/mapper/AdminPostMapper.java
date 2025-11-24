package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.post.AdminPostDetailDTO;
import com.app.bluecotton.domain.dto.post.AdminPostListDTO;
import com.app.bluecotton.domain.dto.post.PostImageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminPostMapper {

    public List<AdminPostListDTO> selectAdminPostList();

    public AdminPostDetailDTO selectPostDetail(Long id);

    public List<PostImageDTO> selectPostImages(Long id);

    public void deletePostLikesByPostId(Long id);

    public void deletePostImagesByPostId(Long id);

    public void deleteRecentPostsByPostId(Long id);

    public void delete(Long id);
}
