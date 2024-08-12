package com.onlineShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineShop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
