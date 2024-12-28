package com.hotwax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.model.OrderHeader;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer> {

}
