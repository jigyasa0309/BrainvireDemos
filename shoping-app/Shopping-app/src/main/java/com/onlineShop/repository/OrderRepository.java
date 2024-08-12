package com.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineShop.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
