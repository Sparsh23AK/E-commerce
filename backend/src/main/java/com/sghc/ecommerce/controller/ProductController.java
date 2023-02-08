package com.sghc.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sghc.ecommerce.entity.Product;
import com.sghc.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	 public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	@GetMapping("/product-details/{product_category}")
	public List<Product> getProductDetailsByCategory(@PathVariable("product_category") String Category){
		return productService.getProductDetailsByCategory(Category);
	}

	@PostMapping("/save")
	public ResponseEntity<Product> saveProductDetails(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

}
