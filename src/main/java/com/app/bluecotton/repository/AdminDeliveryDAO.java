package com.app.bluecotton.repository;

import com.app.bluecotton.domain.dto.AdminDeliveryDetailDTO;
import com.app.bluecotton.domain.dto.AdminDeliveryListDTO;
import com.app.bluecotton.domain.dto.AdminOrderItemDTO;
import com.app.bluecotton.mapper.AdminDeliveryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDeliveryDAO {

    private final AdminDeliveryMapper  adminDeliveryMapper;

    public List<AdminOrderItemDTO> selectOrderItemsByOrderId(Long id) {
        return adminDeliveryMapper.selectOrderItemsByOrderId(id);
    }

    public List<AdminDeliveryListDTO> selectAdminDeliveryList() {
        return adminDeliveryMapper.selectAdminDeliveryList();
    }


    public Optional<AdminDeliveryDetailDTO> selectAdminDeliveryDetail(Long id) {
        return adminDeliveryMapper.selectAdminDeliveryDetail(id);
    }


    public void updateDeliveryStatus(Long id, String deliveryStatus) {
        adminDeliveryMapper.updateDeliveryStatus(id, deliveryStatus);
    }
}
