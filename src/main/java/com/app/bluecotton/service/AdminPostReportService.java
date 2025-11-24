package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminReportedPostDTO;

import java.util.List;

public interface AdminPostReportService {

    public List<AdminReportedPostDTO> getReportedPosts();
}
