package com.sghc.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sghc.ecommerce.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage,Integer>  {

	Optional<ProductImage> findByName(String name);

//	@Query("SELECT auto_increment FROM information_schema.tables WHERE table_name='products_master';")
//	public int currentSeqOfProduct();

}