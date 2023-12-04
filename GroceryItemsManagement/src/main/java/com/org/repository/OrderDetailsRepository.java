package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
