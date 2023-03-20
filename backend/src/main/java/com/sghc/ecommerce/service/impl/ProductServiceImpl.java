package com.sghc.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sghc.ecommerce.entity.Product;
import com.sghc.ecommerce.repository.ProductRepository;
import com.sghc.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}



	@Override
	public List<Product> getProductDetailsByCategory(String productCategory) throws Exception {
		List<Product> productList = null;
		try{
			productList = productRepository.findAllByProductCategory(productCategory);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return productList;
	}



	@Override
	public Product saveProduct(Product product) throws Exception {
		Product productDetails = null;
		try{
			productDetails = productRepository.save(product);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return productDetails;
	}

}