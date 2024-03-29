package com.sghc.ecommerce.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sghc.ecommerce.entity.ImageUploadResponse;
import com.sghc.ecommerce.entity.ProductImage;
import com.sghc.ecommerce.repository.ProductImageRepository;
import com.sghc.ecommerce.service.ProductImageService;
import com.sghc.ecommerce.util.ImageUtil;

import jakarta.transaction.Transactional;

@Service
public class ProductImageServiceImpl implements ProductImageService{

	private final ProductImageRepository productImageRepository;

	public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
		super();
		this.productImageRepository = productImageRepository;
	}

	@Override
	@Transactional
	public ImageUploadResponse uploadImage(MultipartFile file, int productId) {

		try {
			productImageRepository.save(ProductImage.builder()
			        .name(file.getOriginalFilename())
			        .type(file.getContentType())
			        .productId(productId)
			        .imageData(file.getBytes()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

        return new ImageUploadResponse("Image uploaded successfully: " +
                file.getOriginalFilename());
	}

}