package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.AdminDeliveryDetailDTO;
import com.app.bluecotton.domain.dto.AdminDeliveryListDTO;
import com.app.bluecotton.domain.dto.AdminOrderItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminDeliveryMapper {

    public List<AdminOrderItemDTO> selectOrderItemsByOrderId(Long id);

    public List<AdminDeliveryListDTO> selectAdminDeliveryList();

    public Optional<AdminDeliveryDetailDTO> selectAdminDeliveryDetail(Long id);

    public void updateDeliveryStatus(Long id, String deliveryStatus);
}
