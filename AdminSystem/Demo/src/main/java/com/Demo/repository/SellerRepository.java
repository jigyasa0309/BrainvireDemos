package com.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Demo.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
