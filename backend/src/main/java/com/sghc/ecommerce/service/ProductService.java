package com.sghc.ecommerce.service;

import java.util.List;

import com.sghc.ecommerce.entity.Product;

public interface ProductService {

	public List<Product> getProductDetailsByCategory(String productCategory) throws Exception;

	public Product saveProduct(Product product) throws Exception;
}