package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminOrderDTO;

public interface AdminService {
    public AdminOrderDTO selectAdminOrderById(Long orderId);
}
