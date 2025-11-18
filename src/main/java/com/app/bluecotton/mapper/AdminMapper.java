package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.AdminOrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    public AdminOrderDTO selectAdminOrderById(Long orderId);
}
