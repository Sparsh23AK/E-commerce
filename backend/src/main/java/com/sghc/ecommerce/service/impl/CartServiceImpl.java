package com.sghc.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sghc.ecommerce.entity.Cart;
import com.sghc.ecommerce.entity.OrderDetail;
import com.sghc.ecommerce.entity.Product;
import com.sghc.ecommerce.repository.CartRepository;
import com.sghc.ecommerce.repository.ProductRepository;
import com.sghc.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Cart addToCart(Cart cart) throws Exception {
		Product product = productRepository.findById(cart.getProductId()).get();
		cart.setProduct(product);
		Cart cartDetails = null;
		try {
			cartDetails = cartRepository.save(cart);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return cartDetails;
	}

	@Override
	public List<Cart> findByUserName(String userName) throws Exception {
		List<Cart> cartList = null;
		try{
			cartList = cartRepository.findByUserName(userName);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return cartList;
	}

	@Override
	public void deleteCartItem(Integer cartId) throws Exception {
		try{
			cartRepository.deleteById(cartId);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
	}
}
