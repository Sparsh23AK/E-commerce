package com.sghc.ecommerce.service;

import java.util.List;


import com.sghc.ecommerce.entity.OrderDetail;

public interface OrderDetailService {
	
	public OrderDetail placeOrder(OrderDetail orderDetail) throws Exception;
	
	public List<OrderDetail> getAllOrderDetailsByUserName(String userName) throws Exception;
	
	public List<OrderDetail> getAllOrderDetails() throws Exception;
	
	public int updateOrderStatusById(int orderId, String status)throws Exception;
	
}
