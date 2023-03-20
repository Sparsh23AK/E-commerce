package com.sghc.ecommerce.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.sghc.ecommerce.entity.Cart;


public interface CartService {
	public Cart addToCart(@RequestBody Cart cart);
	
	public List<Cart> findByUserName(String userName);
	
	public void deleteCartItem(Integer cartId);
}
