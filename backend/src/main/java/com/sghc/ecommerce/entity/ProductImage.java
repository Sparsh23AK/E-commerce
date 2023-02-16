package com.sghc.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_images")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
	@Id
	@Column(name="image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

	@Column(name="image_name", nullable = false)
    private String name;

	@Column(name="image_type", nullable = false)
    private String type;

	@Column(name="product_id", nullable = false)
    private int productId;

    @Lob
    @Column(name = "image_data")
    private byte[] imageData;


}