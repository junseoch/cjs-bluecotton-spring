package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.AdminOrderDTO;
import com.app.bluecotton.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminDAO {

    private final AdminMapper adminMapper;

    public AdminOrderDTO  selectAdminOrderById(Long orderId) {
        return adminMapper.selectAdminOrderById(orderId);
    }
}
