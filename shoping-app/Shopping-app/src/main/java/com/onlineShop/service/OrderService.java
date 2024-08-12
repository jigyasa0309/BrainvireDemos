package com.onlineShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onlineShop.model.Order;

@Service
public interface OrderService {
	public void deleteOrder(Long id);

	public Order createOrder(Order userorder);

	public List<Order> getOrder();

	public Optional<Order> getOrderByid(Long id);
//public UserOrder createOrder(UserOrder userorder,List<OrderItem>orderitem);

}
