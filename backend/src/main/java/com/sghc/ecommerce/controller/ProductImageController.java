package com.sghc.ecommerce.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sghc.ecommerce.entity.ImageUploadResponse;
import com.sghc.ecommerce.entity.ProductImage;
import com.sghc.ecommerce.service.impl.ProductImageServiceImpl;

@RestController
@RequestMapping("/api/products/images")
public class ProductImageController {

	private final ProductImageServiceImpl productImageServiceImpl;

	public ProductImageController(ProductImageServiceImpl productImageServiceImpl) {
		super();
		this.productImageServiceImpl = productImageServiceImpl;
	}

	@PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("product_id") int productId) throws IOException {

        ImageUploadResponse response = productImageServiceImpl.uploadImage(file, productId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<?>  getImageInfoByName(@PathVariable("name") String name){
    	ProductImage image = productImageServiceImpl.getInfoByImageByName(name);

        return ResponseEntity.status(HttpStatus.OK)
                .body(image);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?>  getImageByName(@PathVariable("name") String name){
        byte[] image = productImageServiceImpl.getImage(name);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}