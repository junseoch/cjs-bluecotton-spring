package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.AdminReportedPostDTO;
import com.app.bluecotton.domain.vo.post.PostReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminPostReportMapper {

    public void insertPostReport(PostReportVO vo);

    public List<AdminReportedPostDTO> selectReportedPostList();

    public void deleteByPostId(Long postId);
}
