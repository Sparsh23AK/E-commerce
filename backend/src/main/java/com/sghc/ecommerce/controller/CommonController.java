package com.sghc.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sghc.ecommerce.entity.ProductResponse;
import com.sghc.ecommerce.service.impl.CommonServiceImpl;

@RestController
@RequestMapping("/api/common")
public class CommonController {

	@Autowired
	public CommonServiceImpl commomServiceImpl;

	@GetMapping("/product-detail/{product_category}")
	public List<ProductResponse> getProductDetailsByCategory(@PathVariable("product_category") String category)
			throws Exception {
		System.out.println(category);
		return commomServiceImpl.getProductDetails(category);
	}

	@GetMapping("/product-detail-forHomePage/{product_category}")
	public List<ProductResponse> getProductDetailsByCategoryHomePage(@PathVariable("product_category") String category)
			throws Exception {
		System.out.println(category);
		return commomServiceImpl.getProductDetailsHomePage(category);
	}

}
