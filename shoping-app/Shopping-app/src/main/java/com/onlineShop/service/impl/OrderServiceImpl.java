package com.onlineShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShop.model.Order;
import com.onlineShop.repository.OrderRepository;
import com.onlineShop.service.OrderService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void deleteOrder(Long id) {
		log.info("++++++++++++++++in the dlte method+++");
		orderRepository.deleteById(id);
	}

	@Override
	public Order createOrder(Order userorder) {
		log.info("++++++++++++++++++creating order+++++++++++++==");
		return orderRepository.save(userorder);
	}

	@Override
	public List<Order> getOrder() {
		log.info("+++++++++++geting order of all orders++++++++====");
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> getOrderByid(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order;
	}
}
