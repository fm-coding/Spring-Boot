package com.faisal.transaction.repo;

import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
