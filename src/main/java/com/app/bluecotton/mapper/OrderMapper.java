package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.*;
import com.app.bluecotton.domain.vo.shop.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper {

    public void insertSingle(OrderDTO orderDTO);

    public void insertCartOrder(OrderCartDTO orderCartDTO);

    public void insertOrderHeader(OrderCheckoutDTO orderCheckoutDTO);

    public List<OrderDetailDTO> selectOrderDetailsByMemberIdAndOrderId(
            @Param("id") Long id,
            @Param("memberId") Long memberId
    );

    public void insertOrderItems(
            @Param("orderId") Long orderId,
            @Param("items") List<OrderItemDTO> items
    );

    public Long selectProductPriceById(@Param("productId") Long productId);

    public List<OrderVO> selectAllByMemberId(@Param("memberId") Long memberId);

    public Optional<OrderVO> selectByMemberIdAndOrderId(
            @Param("id") Long id,
            @Param("memberId") Long memberId
    );

    public void updateOrderStatus(OrderVO orderVO);

    public void delete(
            @Param("id") Long id,
            @Param("memberId") Long memberId
    );

    public Integer findTotalCandyAmountForPendingOrders(@Param("memberId") Long memberId);

    public List<Long> findPendingCandyOrderIdsByMemberId(@Param("memberId") Long memberId);

    public void updateOrderStatusForIds(
            @Param("orderIds") List<Long> orderIds,
            @Param("orderStatus") String orderStatus
    );

    public void detachOrderFromCart(@Param("memberId") Long memberId);

    public void insertOrderHeader(
            @Param("orderId") Long orderId,
            @Param("items") List<OrderItemDTO> items
    );

    public List<DailyRevenue> selectDailyRevenue();
}
