package com.sghc.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sghc.ecommerce.entity.Cart;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	public List<Cart> findByUserName(String userName);
	
//	@Modifying
//	@Query("DELETE from Cart c where c.user_name = :user_name")
	public void deleteAllByUserName(@Param("user_name") String userName);
}
