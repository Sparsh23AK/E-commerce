package com.sghc.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sghc.ecommerce.entity.OrderDetail;
import com.sghc.ecommerce.repository.OrderDetailRepository;
import com.sghc.ecommerce.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDetail placeOrder(OrderDetail orderDetail) {
		return orderDetailRepository.save(orderDetail);
	}
}
