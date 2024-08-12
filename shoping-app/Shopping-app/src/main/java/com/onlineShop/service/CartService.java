package com.onlineShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineShop.model.Cart;

@Service
public interface CartService {

	Cart createCart(Cart cart);

	Cart getCart(Long id);

	List<Cart> getAllCart();

	void deleteCart(Long id);
}
