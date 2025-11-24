package com.app.bluecotton.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDashboardOverviewDTO {
    private int totalUsers;
    private int activeSoms;
    private int totalPosts;
    private int totalOrders;


    private Double userChangeRate;
    private Double somChangeRate;
    private Double postChangeRate;
    private Double orderChangeRate;

    private List<AdminRecentActivityDTO> recentActivities;

//    public static Object builder();
}
