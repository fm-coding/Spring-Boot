package com.faisal.transaction.dto;

import com.faisal.transaction.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderAcknowledgement {
    private String status;
    private double paybleAmount;
    private PaymentInfo paymentInfo;
}
