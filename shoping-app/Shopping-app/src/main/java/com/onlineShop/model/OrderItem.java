package com.onlineShop.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "id")
	private Product product;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "o_id")
	private Order order;
	private String review;

	private int rating = 0;
	@Enumerated(EnumType.STRING)
	private OrderItemStatus orderStatus = OrderItemStatus.ORDERED;
	private LocalDateTime shippingDate;
	private LocalDateTime deliveredDate;
	private LocalDateTime reviewDate;
}