package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.dto.OrderCartDTO;
import com.app.bluecotton.domain.dto.OrderDTO;
import com.app.bluecotton.domain.vo.shop.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insertOrder() {
        OrderDTO dto = new OrderDTO();
        dto.setMemberId(2L);
        dto.setProductId(1L);
        dto.setOrderQuantity(3);
        dto.setOrderStatus('Y');
        orderMapper.insertSingle(dto);
        log.info("✅ 단일 주문 등록 성공: {}", dto);
    }

    @Test
    public void insertCartOderTest() {
        OrderCartDTO orderCartDTO = new OrderCartDTO();
        orderCartDTO.setMemberId(1L);
        orderCartDTO.setProductId(1L);
        orderCartDTO.setCartId(5L);
        orderCartDTO.setOrderStatus('Y'); // boolean → SQL에서 Y/N 변환
        orderCartDTO.setOrderQuantity(1);

        orderMapper.insertCartOrder(orderCartDTO);

    }

    @Test
    public void selectAllByMemberIdTest() {
        Long memberId = 1L; // ✅ 테스트용 멤버 ID
        orderMapper.selectAllByMemberId(memberId);

        log.info(orderMapper.selectAllByMemberId(memberId).toString());
    }

    @Test
    public void selectByMemberIdAndOrderIdTest() {
        Long memberId = 1L;
        Long id = 2L;

        Optional<OrderVO> foundOrder = orderMapper.selectByMemberIdAndOrderId(id, memberId);
        foundOrder.ifPresentOrElse(
                order -> log.info(order.toString()),
                () -> log.warn("해당 주문이 존재하지 않습니다. (memberId={}, orderId={})", id, memberId)
        );
    }


//    @Test
//    public void updateTest() {
//        OrderVO orderVO = new OrderVO();
//        orderVO.setOrderStatus('N');
//        orderVO.setMemberId(1L);
//        orderVO.setId(2L);
//        orderMapper.updateOrderStatus(orderVO);
//    }

    @Test
    public  void deleteTest() {
        Long memberId = 1L;
        Long id = 2L;

        orderMapper.delete(id, memberId);
    }
}
