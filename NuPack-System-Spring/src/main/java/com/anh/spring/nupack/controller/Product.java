package com.anh.spring.nupack.controller;

public class Product {

	private String productName;
	private String productMaterial;
	private Double basePrice;
	private Double finalPrice;

	public Product(String productName, String productMaterial, Double basePrice) {
		this.productName = productName;
		this.productMaterial = productMaterial;
		this.basePrice = basePrice;
		this.finalPrice = 0.0;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductMaterial() {
		return productMaterial;
	}

	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productMaterial="
				+ productMaterial + ", basePrice=" + basePrice
				+ ", finalPrice=" + finalPrice + "]";
	}
}
