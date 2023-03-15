package com.sghc.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghc.ecommerce.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer>{
	
}
