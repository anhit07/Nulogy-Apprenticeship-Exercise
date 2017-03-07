package com.anh.spring.nupack;

public class PackingService {

	private Product product;
	private int packingLaborNumber;

	public PackingService(Product product, int packingLaborNumber) {
		this.product = new Product(product.getProductName(),
				product.getProductMaterials(), product.getBasePrice());
		this.packingLaborNumber = packingLaborNumber;
	}
	
	public void finalPriceCaculate(){
		
		Double priceAfterFlatMarkup = this.product.getBasePrice()
	}
}
