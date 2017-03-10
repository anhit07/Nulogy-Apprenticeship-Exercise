package com.anh.spring.nupack;

public class Product {

	private String productName;
	private String productMaterials;
	private Double basePrice;

	private Double finalPrice;

	public Product(String productName, String productMaterials, Double basePrice) {
		this.productName = productName;
		this.productMaterials = productMaterials;
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

	public String getProductMaterials() {
		return productMaterials;
	}

	public void setProductMaterials(String productMaterials) {
		this.productMaterials = productMaterials;
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
		return "Product [productName=" + productName + ", productMaterials="
				+ productMaterials + ", basePrice=" + basePrice
				+ ", finalPrice=" + finalPrice + "]";
	}
}
