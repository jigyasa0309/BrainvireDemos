package com.Demo.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.Demo.entity.Seller;
import com.Demo.repository.SellerRepository;

public class SellerServiceImpl implements SellerService {
@Autowired 
private SellerRepository sellerRepository;
	
	@Override
	public Seller addSeller(Seller s) {
		Seller seller= sellerRepository.save(s);
		return seller;
	}

	@Override
	public List<Seller> getAllSellers() {
//		List<Seller>=
		return null;
	}

}
