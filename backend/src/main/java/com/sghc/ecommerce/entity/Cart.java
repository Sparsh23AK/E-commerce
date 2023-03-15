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
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
	
	private String userName;
	
	private int productId;
	
	private int quantity;
	
	private double cartAmount;
}
