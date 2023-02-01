package com.sghc.ecommerce.entity;

/*
 * This a Entity class for the Products.
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products_master")
public class Product {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(name="product_category", nullable = false)
	private String productCategory;

	@Column(name="description", nullable = false)
	private String description;

	@Column(name="price", nullable = false)
	private double price;

	@Column(name="discount_percentage", nullable = true)
	private int discountPercentage;

	@Column(name="size", nullable = false)
	private String size;

	@Column(name="sub_description", nullable = true)
	private String subDescription;

	@Column(name="type", nullable = true)
	private String type;

	@Column(name="rating", nullable = true)
	private float rating;

	//Getters and Setters
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSubDescription() {
		return subDescription;
	}
	public void setSubDescription(String subDescription) {
		this.subDescription = subDescription;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}


}