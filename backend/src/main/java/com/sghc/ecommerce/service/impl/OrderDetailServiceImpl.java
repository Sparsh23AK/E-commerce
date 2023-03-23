package com.sghc.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sghc.ecommerce.entity.OrderDetail;
import com.sghc.ecommerce.entity.OrderProductQuantity;
import com.sghc.ecommerce.entity.Product;
import com.sghc.ecommerce.repository.CartRepository;
import com.sghc.ecommerce.repository.OrderDetailRepository;
import com.sghc.ecommerce.repository.ProductRepository;
import com.sghc.ecommerce.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	private static final String ORDER_PLACED = "Placed";
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	@Override
	public OrderDetail placeOrder(OrderDetail orderDetail) throws Exception{
		orderDetail.setOrderStatus(ORDER_PLACED);
		cartRepository.deleteAllByUserName(orderDetail.getUserName());
		OrderDetail orderDetails = null;
		try {
			orderDetails = orderDetailRepository.save(orderDetail);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return orderDetails;
	}


	@Override
	public List<OrderDetail> getAllOrderDetailsByUserName(String userName) throws Exception{
		List<OrderDetail> orderDetailsList = null;
		try{
			orderDetailsList = orderDetailRepository.findAllByUserName(userName);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return orderDetailsList;
	}


	@Override
	public List<OrderDetail> getAllOrderDetails() throws Exception {
		List<OrderDetail> orderDetailsList = null;
		try{
			orderDetailsList = orderDetailRepository.findAll();
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return orderDetailsList;
	}


	@Override
	public int updateOrderStatusById(int orderId, String status) throws Exception {
		
		return orderDetailRepository.changeOrderStatusByOrderId(orderId, status);
	}
}
