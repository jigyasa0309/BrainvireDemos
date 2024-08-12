package com.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineShop.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
