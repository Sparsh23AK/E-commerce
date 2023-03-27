package com.sghc.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sghc.ecommerce.entity.ProductResponse;
import com.sghc.ecommerce.repository.CommonRepository;
import com.sghc.ecommerce.service.CommonService;
import com.sghc.ecommerce.util.ImageUtil;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	public CommonRepository commonRepository;

	@Override
	public List<ProductResponse> getProductDetails(String category) throws Exception {
		List<ProductResponse> productResponse = null;
		try {
			productResponse = commonRepository.getProductDetails(category);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return productResponse;
	}

	@Override
	public List<ProductResponse> getProductDetailsHomePage(String category) throws Exception {
		List<ProductResponse> productResponse = null;
		try {
			productResponse = commonRepository.getProductDetailsHomePage(category);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something Went Wrong");
		}
		return productResponse;
	}

}
