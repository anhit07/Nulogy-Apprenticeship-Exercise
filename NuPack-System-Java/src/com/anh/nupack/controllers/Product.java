package com.anh.nupack.controllers;

import java.math.BigDecimal;

/**
 * @author AnhNguyen This class is used to store all information about Product
 * 
 */
public class Product {

	private String productName;

	private String productMaterial;

	// Required when input
	private BigDecimal basePrice;

	private BigDecimal finalPrice;

	/**
	 * Class constructor specifying product name, material of product and base
	 * price. The final price will be initialized "0"
	 * 
	 * @param productName
	 * @param productMaterial
	 * @param basePrice
	 */
	public Product(String productName, String productMaterial, BigDecimal basePrice) {
		this.productName = productName;
		this.productMaterial = productMaterial;
		this.basePrice = basePrice;
		this.finalPrice = new BigDecimal(0);
	}

	/**
	 * Class constructor
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ProductName getter
	 * 
	 * @return
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * ProductName setter
	 * 
	 * @return
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * ProductMaterial getter
	 * 
	 * @return
	 */
	public String getProductMaterial() {
		return productMaterial;
	}

	/**
	 * ProductMaterial setter
	 * 
	 * @return
	 */
	public void setProductMaterial(String productMaterial) {
		this.productMaterial = productMaterial;
	}

	/**
	 * BasePrice getter
	 * 
	 * @return
	 */
	public BigDecimal getBasePrice() {
		return basePrice;
	}

	/**
	 * BasePrice setter
	 * 
	 * @return
	 */
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * FinalPrice getter
	 * 
	 * @return
	 */
	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	/**
	 * FinalPrice setter
	 * 
	 * @return
	 */
	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() override toString: print out values of
	 * all fields of a Product
	 */
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productMaterial="
				+ productMaterial + ", basePrice=" + basePrice
				+ ", finalPrice=" + finalPrice + "]";
	}
}
