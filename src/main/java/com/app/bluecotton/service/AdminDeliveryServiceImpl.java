package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminDeliveryDetailDTO;
import com.app.bluecotton.domain.dto.AdminDeliveryListDTO;
import com.app.bluecotton.domain.dto.AdminOrderItemDTO;
import com.app.bluecotton.repository.AdminDeliveryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class AdminDeliveryServiceImpl implements  AdminDeliveryService {

    private final AdminDeliveryDAO adminDeliveryDAO;

    @Override
    public List<AdminOrderItemDTO> selectOrderItemsByOrderId(Long id) {
        return adminDeliveryDAO.selectOrderItemsByOrderId(id);
    }

    @Override
    public List<AdminDeliveryListDTO> getDeliveryList() {
        return adminDeliveryDAO.selectAdminDeliveryList();
    }

    @Override
    public Optional<AdminDeliveryDetailDTO> getDeliveryDetail(Long id) {
        return adminDeliveryDAO.selectAdminDeliveryDetail(id);
    }

    @Override
    public void changeDeliveryStatus(Long id, String status) {
        adminDeliveryDAO.updateDeliveryStatus(id, status);
    }
}
