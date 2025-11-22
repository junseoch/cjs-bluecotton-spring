package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.AdminDeliveryDetailDTO;
import com.app.bluecotton.domain.dto.AdminDeliveryListDTO;
import com.app.bluecotton.domain.dto.AdminOrderItemDTO;
import com.app.bluecotton.repository.AdminDeliveryDAO;

import java.util.List;
import java.util.Optional;

public interface AdminDeliveryService {


    public List<AdminOrderItemDTO> selectOrderItemsByOrderId(Long id);

    public List<AdminDeliveryListDTO> getDeliveryList();

    public Optional<AdminDeliveryDetailDTO> getDeliveryDetail(Long id);

    public void changeDeliveryStatus(Long id, String status);
}
