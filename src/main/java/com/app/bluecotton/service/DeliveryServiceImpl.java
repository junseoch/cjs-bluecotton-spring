package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.shop.DeliveryVO;
import com.app.bluecotton.repository.DeliveryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryDAO  deliveryDAO;


    @Override
    public void save(DeliveryVO deliveryVO) {
        deliveryDAO.insert(deliveryVO);
    }

    @Override
    public List<DeliveryVO> findByMember(Long memberId) {
        return deliveryDAO.findByMemberId(memberId);
    }
}
