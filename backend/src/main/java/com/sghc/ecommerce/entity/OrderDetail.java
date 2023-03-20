package com.sghc.ecommerce.entity;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
	
	private String userName;
	
	private String address;
	
	private String phoneNumber;
	
	private double orderAmount;
	
	private String orderStatus;
	
	@ManyToMany
	private List<Product> productList;

}