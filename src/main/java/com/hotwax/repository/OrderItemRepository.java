package com.hotwax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
