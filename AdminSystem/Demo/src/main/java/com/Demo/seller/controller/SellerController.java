package com.Demo.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.entity.Seller;
import com.Demo.seller.service.SellerServiceImpl;

@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerServiceImpl sellerServiceImpl;
@PostMapping
public Seller addSeller(@RequestBody Seller seller) {
	Seller s=sellerServiceImpl.addSeller(seller);
	return s;
}
}
