package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.shop.CartVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CartServiceImplTest {

    @Autowired
    private CartService cartService;

    @Test
    public void testAddCart() {
        CartVO cartVO = new CartVO();
        cartVO.setMemberId(1L);
        cartVO.setProductId(2L);
//        cartVO.setQuantity(10);
        cartService.addCart(cartVO);
    }

    @Test
    public void testDeleteCart() {
        cartService.deleteCart(1L,1L);
    }

    @Test
    public void plusTest() {
        CartVO cartVO = new CartVO();
        cartVO.setProductId(1L);
//        cartVO.setQuantity(5);
        cartService.updatePlusCart(cartVO);
//        log.info("{}", cartService.updatePlusCart(cartVO));
    }
}
