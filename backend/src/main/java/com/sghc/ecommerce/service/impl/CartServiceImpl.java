package com.sghc.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sghc.ecommerce.entity.Cart;
import com.sghc.ecommerce.repository.CartRepository;
import com.sghc.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart addToCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public List<Cart> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return cartRepository.findByUserName(userName);
	}
}
