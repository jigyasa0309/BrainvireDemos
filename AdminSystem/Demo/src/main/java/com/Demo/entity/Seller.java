package com.Demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name="seller_entity")
public class Seller {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	private String product_name;
	private double value;
	

}
