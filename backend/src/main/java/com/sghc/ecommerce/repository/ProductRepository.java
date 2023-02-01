package com.sghc.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sghc.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	public List<Product> findAllByProductCategory(String Category);

}