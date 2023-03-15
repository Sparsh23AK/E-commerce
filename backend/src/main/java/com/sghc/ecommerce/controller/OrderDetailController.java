package com.sghc.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sghc.ecommerce.entity.OrderDetail;
import com.sghc.ecommerce.service.OrderDetailService;

@RestController
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@PostMapping({"/placeOrder"})
	public OrderDetail placeOrder(@RequestBody OrderDetail orderDetail) {
		return orderDetailService.placeOrder(orderDetail);
	}
}
