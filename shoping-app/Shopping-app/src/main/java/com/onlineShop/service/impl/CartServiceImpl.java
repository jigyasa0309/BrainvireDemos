package com.onlineShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShop.model.Cart;
import com.onlineShop.repository.CartRepository;
import com.onlineShop.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart getCart(Long id) {
		return cartRepository.findById(id).orElse(null);
	}

	@Override
	public List<Cart> getAllCart() {
		List<Cart> cart = cartRepository.findAll();
		return cart;
	}

	@Override
	public void deleteCart(Long id) {
		cartRepository.deleteById(id);

	}
}
