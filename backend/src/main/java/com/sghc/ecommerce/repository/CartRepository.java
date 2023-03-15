package com.sghc.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghc.ecommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	public List<Cart> findByUserName(String userName);
}
