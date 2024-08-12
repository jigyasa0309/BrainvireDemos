package com.onlineShop.controller;

import java.util.List;
import java.util.Optional;

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
import com.onlineShop.model.Order;
import com.onlineShop.service.OrderService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private JwtFilter filter;

	// for creating orders
	@PostMapping("/create")
	@PreAuthorize("hasAuthority('USER_ROLES')")
	@Transactional
	public ResponseEntity<Order> createOrder(@RequestBody Order userOrder) {
		Order createdOrder = orderService.createOrder(userOrder);
		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}

	// for Viewing all orders
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN_ROLES')")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderService.getOrder();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

	// for getting ordr by order id
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('USER_ROLES')")
	public ResponseEntity<Optional<Order>> getAllOrdersById(@PathVariable Long id, Authentication authentication) {
		if (authentication != null && authentication.isAuthenticated()) {
			if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN_ROLES"))) {
				return ResponseEntity.ok(orderService.getOrderByid(id));
			} else {
				String u_name = filter.getuname();
				Optional<Order> user = orderService.getOrderByid(id);
				if (u_name != null) {
					if (u_name.equals(user.get().getOname())) {
						return ResponseEntity.ok(orderService.getOrderByid(id));
					}
				}
			}
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('USER_ROLES')")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}
