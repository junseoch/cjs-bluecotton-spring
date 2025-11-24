package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.AdminReportedPostDTO;
import com.app.bluecotton.domain.vo.post.PostReportVO;
import com.app.bluecotton.mapper.AdminPostReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminPostReportDAO {

    private final AdminPostReportMapper adminPostReportMapper;

    public void insertPostReport(PostReportVO vo) {
        adminPostReportMapper.insertPostReport(vo);
    }

    public List<AdminReportedPostDTO> selectReportedPostList() {
        return adminPostReportMapper.selectReportedPostList();
    }

    public void deleteByPostId(Long postId) {
        adminPostReportMapper.deleteByPostId(postId);
    }
}
