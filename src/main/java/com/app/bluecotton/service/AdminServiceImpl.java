package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminOrderDTO;
import com.app.bluecotton.repository.AdminDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminDAO adminDAO;

    @Override
    public AdminOrderDTO selectAdminOrderById(Long orderId) {
        return adminDAO.selectAdminOrderById(orderId);
    }
}
