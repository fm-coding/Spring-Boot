package com.faisal.transaction.dto;

import com.faisal.transaction.entity.OrderInfo;
import com.faisal.transaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private OrderInfo orderInfo;
    private PaymentInfo paymentInfo;
}
