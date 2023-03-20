package com.sghc.ecommerce.service;

import java.util.List;

import com.sghc.ecommerce.entity.ProductResponse;

public interface CommonService {

	public List<ProductResponse> getProductDetails(String category) throws Exception;
	
}
