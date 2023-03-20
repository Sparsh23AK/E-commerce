package com.sghc.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghc.ecommerce.entity.Cart;
import com.sghc.ecommerce.entity.OrderDetail;
import com.sghc.ecommerce.service.CartService;
import com.sghc.ecommerce.service.OrderDetailService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping({"/addToCart"})
	public Cart addToCart(@RequestBody Cart cart) throws Exception {
		return cartService.addToCart(cart);
	}
	
	@GetMapping({"/getCart/{user-name}"})
	public List<Cart> getCartDetails(@PathVariable("user-name") String userName) throws Exception{
		return cartService.findByUserName(userName);
	}
	
	@DeleteMapping({"/deleteCartItem/{cartId}"})
	public void deleteCartItem(@PathVariable("cartId") Integer cartId) throws Exception {
		cartService.deleteCartItem(cartId);
	}
}
