package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.shop.DeliveryVO;

import java.util.List;

public interface DeliveryService {

    public void save(DeliveryVO deliveryVO);

    public List<DeliveryVO> findByMember(Long memberId);
}
