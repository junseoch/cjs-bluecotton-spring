package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.AdminRecentActivityDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDashboardMapper {
    public int countAllUsers();

    public int countActiveSoms();

    public int countAllPosts();

    public int countAllOrders();

    public List<AdminRecentActivityDTO> selectRecentActivities();
}
