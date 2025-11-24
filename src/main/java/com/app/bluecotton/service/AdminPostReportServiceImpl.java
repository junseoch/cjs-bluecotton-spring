package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminReportedPostDTO;
import com.app.bluecotton.repository.AdminPostReportDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class AdminPostReportServiceImpl implements AdminPostReportService {

    private final AdminPostReportDAO  adminPostReportDAO;


    @Override
    public List<AdminReportedPostDTO> getReportedPosts() {
        return  adminPostReportDAO.selectReportedPostList();
    }
}
