package com.adminSystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Getter
@Setter
public class OTSEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String accounts;
	private String customerName;
	private BigDecimal otsAmount;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate sanctionDate;

	@NotNull
	@Future(message = "Expiry date must be in the future")
	@Max(value = 90, message = "Expiry date cannot be more than 90 days from now")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate expiryDate;

	private String updatedBy;
	private LocalDateTime creationTime;

	// Constructor to set default values
	public OTSEntity() {
		this.sanctionDate = LocalDate.now();
	}

	
}
