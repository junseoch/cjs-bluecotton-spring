package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.vo.shop.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

//@SpringBootTest
//@Slf4j
//public class CartMapperTest {

//    @Autowired
//    CartMapper cartMapper;

//    @Test
//    public void insertTest() {
//        CartVO cartVO = new CartVO();
//        cartVO.setMemberId(1L);
//        cartVO.setProductId(1L);
//        cartVO.setQuantity(5);
//        cartMapper.insert(cartVO);
//    }
//
//    @Test
//    public void updateTest() {
//        CartVO cartVO = new CartVO();
//        cartVO.setMemberId(1L);
//        cartVO.setProductId(1L);
//        cartVO.setQuantity(8);
////        cartMapper.updatePlus(cartVO);
//    }
//
//    @Test
//    public void deleteTest() {
//        cartMapper.delete(1L, 2L);
//    }
//
//    @Test
//    public void updateTest2() {
//        CartVO cartVO = new CartVO();
//        cartVO.setMemberId(1L);
//        cartVO.setProductId(1L);
//        cartVO.setQuantity(8);
//        cartMapper.updateMinus(cartVO);
//    }
//
//    @Test
//    void selectQuantityTest() {
//        CartVO cartVO = new CartVO();
//        cartVO.setMemberId(1L);
//        cartVO.setProductId(1L);
//        cartVO.setQuantity(0);
//        cartMapper.selectQuantity(cartVO);
//    }
//}
