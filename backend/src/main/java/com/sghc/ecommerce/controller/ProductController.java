package com.sghc.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sghc.ecommerce.entity.Product;
import com.sghc.ecommerce.entity.ProductImage;
import com.sghc.ecommerce.service.ProductService;
import com.sghc.ecommerce.service.impl.ProductImageServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private  ProductService productService;
	@Autowired
	private  ProductImageServiceImpl productImageServiceImpl;

	@PostMapping("/save")
	public ResponseEntity<Product> saveProductDetails(@RequestBody Product product) throws Exception{
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

}
