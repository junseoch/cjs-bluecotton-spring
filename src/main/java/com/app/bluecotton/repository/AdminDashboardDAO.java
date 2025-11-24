package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.AdminRecentActivityDTO;
import com.app.bluecotton.mapper.AdminDashboardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminDashboardDAO {

    private final AdminDashboardMapper adminDashboardMapper;

    public int countAllUsers() {
        return adminDashboardMapper.countAllUsers();
    }

    public int countActiveSoms() {
        return adminDashboardMapper.countActiveSoms();
    }

    public int countAllPosts() {
        return adminDashboardMapper.countAllPosts();
    }

    public int countAllOrders() {
        return adminDashboardMapper.countAllOrders();
    }

    public List<AdminRecentActivityDTO> selectRecentActivities() {
        return adminDashboardMapper.selectRecentActivities();
    }
}
