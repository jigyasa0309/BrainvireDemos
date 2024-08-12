package com.onlineShop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShop.Security.filter.JwtFilter;
import com.onlineShop.model.Cart;
import com.onlineShop.service.CartService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "E-Commerce Application")
@RestController
@RequestMapping("/api/carts")
public class CartController {
	@Autowired
	JwtFilter filter;
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@PostMapping
	@PreAuthorize("hasAuthority('USER_ROLES')")
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		Cart createdCart = cartService.createCart(cart);
		return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	// @PreAuthorize("hasAuthority('USER_ROLES')")
	public ResponseEntity<Cart> getCartById(@PathVariable Long id, Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
			if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN_ROLES"))) {
				return ResponseEntity.ok(cartService.getCart(id));
			} else {
				String u_name = filter.getuname();
				Cart user = cartService.getCart(id);
				if (u_name != null) {
					if (u_name.equals(user.getName())) {
						return ResponseEntity.ok(cartService.getCart(id));
					}
				}
			}
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN_ROLES')")
	public ResponseEntity<List<Cart>> getAllCarts() {
		logger.info("Fetching all carts");
		List<Cart> carts = cartService.getAllCart();
		logger.info("Fetched {} carts", carts.size());
		return new ResponseEntity<>(carts, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('USER_ROLES')")
	public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
		logger.info("Deleting cart with ID: {}", id);
		cartService.deleteCart(id);
		logger.info("Cart deleted successfully");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
