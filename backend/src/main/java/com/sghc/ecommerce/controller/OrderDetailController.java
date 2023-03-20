package com.sghc.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghc.ecommerce.entity.OrderDetail;
import com.sghc.ecommerce.service.OrderDetailService;

@RestController
@RequestMapping("/api/order")
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@PostMapping({"/placeOrder"})
	public OrderDetail placeOrder(@RequestBody OrderDetail orderDetail) {
		return orderDetailService.placeOrder(orderDetail);
	}
	
	@GetMapping({"/getOrderDetails/{user-name}"})
	public List<OrderDetail> getAllOrderDetailsByUserName(@PathVariable("user-name") String userName) throws Exception{
		return orderDetailService.getAllOrderDetailsByUserName(userName);
	}
}
