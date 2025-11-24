package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.vo.shop.DeliveryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeliveryMapper {


    public int existsByOrderId(@Param("orderId") Long orderId);


    public void insert(DeliveryVO  deliveryVO);

    public List<DeliveryVO> selectByMemberId(Long memberId);
}
