package com.app.bluecotton.repository;

import com.app.bluecotton.domain.vo.shop.DeliveryVO;
import com.app.bluecotton.mapper.DeliveryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeliveryDAO {

    private final DeliveryMapper deliveryMapper;

    public void insert(DeliveryVO deliveryVO) {
        deliveryMapper.insert(deliveryVO);
    }

    public int existsByOrderId(Long orderId) {
        return deliveryMapper.existsByOrderId(orderId);
    }

    public List<DeliveryVO> findByMemberId(Long memberId) {
        return deliveryMapper.selectByMemberId(memberId);
    }
}
