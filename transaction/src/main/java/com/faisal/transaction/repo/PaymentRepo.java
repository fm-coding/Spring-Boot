package com.faisal.transaction.repo;

import com.faisal.transaction.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentInfo, Long > {
}
