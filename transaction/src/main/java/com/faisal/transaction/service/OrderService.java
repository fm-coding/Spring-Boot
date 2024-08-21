package com.faisal.transaction.service;

import com.faisal.transaction.dto.OrderAcknowledgement;
import com.faisal.transaction.dto.OrderRequest;
import com.faisal.transaction.entity.OrderInfo;
import com.faisal.transaction.entity.PaymentInfo;
import com.faisal.transaction.repo.OrderRepo;
import com.faisal.transaction.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    public OrderAcknowledgement placingOrder(OrderRequest orderRequest){
        OrderInfo orderInfo = orderRequest.getOrderInfo();
        orderInfo = orderRepo.save(orderInfo);

        PaymentInfo paymentInfo = orderRequest.getPaymentInfo();
        validatePaymentInfo(paymentInfo);
        orderInfo.setProductName(paymentInfo.getProductName());

        orderRepo.save(orderInfo);
        paymentRepo.save(paymentInfo);
        return new OrderAcknowledgement("Success", paymentInfo.getAmount(), paymentInfo);


    }


}
