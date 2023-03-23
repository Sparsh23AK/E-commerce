package com.sghc.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sghc.ecommerce.entity.OrderDetail;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer>{
	
	public List<OrderDetail> findAllByUserName(String userName);
	
	@Modifying
	@Query("update OrderDetail u set u.orderStatus = :orderStatus where u.orderId = :orderId")
	public int changeOrderStatusByOrderId(@Param("orderId") int orderId, @Param("orderStatus") String orderStatus);
}
