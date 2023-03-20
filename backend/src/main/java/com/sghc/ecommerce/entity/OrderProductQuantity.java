package com.sghc.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductQuantity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer setId;
	
	private Integer productId;
	
	private Integer quantity;
}
