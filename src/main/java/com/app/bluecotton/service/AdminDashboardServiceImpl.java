package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminDashboardOverviewDTO;
import com.app.bluecotton.domain.dto.AdminRecentActivityDTO;
import com.app.bluecotton.repository.AdminDashboardDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@RequiredArgsConstructor
public class AdminDashboardServiceImpl implements AdmindashboardService{

    private final AdminDashboardDAO adminDashboardDAO;

    @Override
    @Transactional(readOnly = true)
    public AdminDashboardOverviewDTO getOverview() {

        int totalUsers = adminDashboardDAO.countAllUsers();
        int activeSoms = adminDashboardDAO.countActiveSoms();
        int totalPosts = adminDashboardDAO.countAllPosts();
        int totalOrders = adminDashboardDAO.countAllOrders();
        List<AdminRecentActivityDTO> activities = adminDashboardDAO.selectRecentActivities();

        return AdminDashboardOverviewDTO.builder()
                .totalUsers(totalUsers)
                .activeSoms(activeSoms)
                .totalPosts(totalPosts)
                .totalOrders(totalOrders)
                .recentActivities(activities)
                .build();
    }
}
