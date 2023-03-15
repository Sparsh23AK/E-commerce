package com.sghc.ecommerce.service;

import org.springframework.web.multipart.MultipartFile;

import com.sghc.ecommerce.entity.ImageUploadResponse;
import com.sghc.ecommerce.entity.ProductImage;

public interface ProductImageService {

	 public ImageUploadResponse uploadImage(MultipartFile file, int productId);

}