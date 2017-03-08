package com.anh.spring.nupack.controller;

public class PackingService {

	private Product product;
	private Markups markups;
	
	private int packingLaborNumber;

	public PackingService() {

	}

	/**
	 * @param product
	 */
	public PackingService(Product product, int packingLaborNumber) {
		if (product != null && product.getBasePrice() != null
				&& product.getBasePrice() > 0) {
			this.product = product;
			if(product.getProductMaterial() == null)
				product.setProductMaterial(""); 
			this.markups = new Markups(product.getProductMaterial());
			this.packingLaborNumber = packingLaborNumber;
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void calculateProductFinalPrice() {

		if(this.product.getBasePrice() != null && this.product.getBasePrice() > 0){
			Double basePrice = this.product.getBasePrice();
			Double flatMarkup = this.markups.getFlatMarkupPercentage();
			Double materialMarkup = this.markups.getMaterialMarkupPercentage();
			Double laborMarkup = this.markups.getLaborMarkupPercentage();
			Double totalLaborMarkup = laborMarkup * this.packingLaborNumber;
	
			Double priceAfterFlatMarkup = basePrice
					+ (basePrice * flatMarkup / 100);
	
			Double finalPrice = priceAfterFlatMarkup
					+ (priceAfterFlatMarkup * (materialMarkup + totalLaborMarkup) / 100);
	
			this.product.setFinalPrice(finalPrice);
		}
	};

}
