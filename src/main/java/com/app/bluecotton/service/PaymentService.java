package com.app.bluecotton.service;

import com.app.bluecotton.domain.dto.*;

import java.util.List;
import java.util.Map;

public interface PaymentService {



    public PortOneDTO processPayment(Map<String, Object> paymentData);

    public PaymentPrepareResponse preparePayment(PaymentPrepareRequest request);


    public void verifyPayment(PaymentVerifyRequest request);

//    public void payAllPendingCandyOrders(Long memberId);

    public void payWithCandy(Long memberId, Long orderId);

    public List<MyShopOrderDTO> findCompletedOrdersByMemberId(Long memberId);
}
