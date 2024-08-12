package com.onlineShop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long o_id;
	private String Oname;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	private BigDecimal totalAmount = new BigDecimal(0.00);
	private String shippingAddress;
	private String billingAddress;
	private String paymentMethod;
	private String paymentInfo;
	@Enumerated(EnumType.STRING)
	private OrderStatus status = OrderStatus.NEW;
	private LocalDateTime orderedDate;
	private LocalDateTime endDate;
	

	public void addOrderItem(OrderItem item) {
		orderItems.add(item);
	}
}