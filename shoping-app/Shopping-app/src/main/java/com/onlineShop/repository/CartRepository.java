package com.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineShop.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
