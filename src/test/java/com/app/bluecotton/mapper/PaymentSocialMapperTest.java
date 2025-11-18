//package com.app.bluecotton.mapper;
//
//import com.app.bluecotton.domain.vo.shop.PaymentSocialVO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Slf4j
//public class PaymentSocialMapperTest {
//
//    @Autowired
//    private PaymentSocialMapper paymentSocialMapper;
//
//    @Test
//    public void insert() {
//        PaymentSocialVO paymentSocialVO = new PaymentSocialVO();
//        paymentSocialVO.setPaymentSocialName("toss");
//        paymentSocialVO.setPaymentSocialNumber("123213123213");
//        paymentSocialVO.setPaymentId(5L);
//        paymentSocialMapper.insert(paymentSocialVO);
//    }
//
//    @Test
//    public void select() {
//        paymentSocialMapper.selectByPaymentId(1L);
//    }
//
//    @Test
//    public void selectAll() {
//        paymentSocialMapper.selectById(1L);
//    }
//
//    @Test
//    public void update() {
//        PaymentSocialVO paymentSocialVO = new PaymentSocialVO();
//        paymentSocialVO.setId(5L);
//        paymentSocialVO.setPaymentSocialName("kakao");
//        paymentSocialVO.setPaymentSocialNumber("111111111");
//        paymentSocialMapper.update(paymentSocialVO);
//    }
//
//    @Test
//    public void delete() {
//        Long paymentSocialId = 4L;
//        paymentSocialMapper.delete(paymentSocialId);
//    }
//
//}
