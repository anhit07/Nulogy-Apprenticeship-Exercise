package com.anh.spring.nupack.controller;

import java.util.HashMap;

import com.anh.spring.nupack.utilities.ConstantUtil;
import com.anh.spring.nupack.utilities.PropertiesUtil;

public class PackingService {

	private Product product;
	private Markups markups;
	private int packingLaborNumber;
	private Double markupMaterialPercent;
	public PackingService() {

	}

	@Override
	public String toString() {
		return "PackingService [product=" + product + ", markups=" + markups
				+ ", packingLaborNumber=" + packingLaborNumber
				+ ", markupMaterialPercent=" + markupMaterialPercent + "]";
	}

	/**
	 * @param product
	 */
	public PackingService(Product product, int packingLaborNumber) {
		if (product != null && product.getBasePrice() != null
				&& product.getBasePrice() > 0) {
			this.product = product;
			if (product.getProductMaterial() == null)
				product.setProductMaterial("");
			this.markups = new Markups();
			this.packingLaborNumber = packingLaborNumber;
		}
	}

	public void getMarkupMaterialByProduct() {
		if (product != null && product.getBasePrice() != null
				&& product.getBasePrice() > 0) {
			String productMaterial = this.product.getProductMaterial();

			if (productMaterial.equals(this.markups
					.getMarkupMaterialType(ConstantUtil.markupTypePhar))) {

				// Pharmaceutical
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.markupPercentageMaterialPhar);

			} else if (productMaterial.equals(this.markups
					.getMarkupMaterialType(ConstantUtil.markupTypeFood))) {

				// Food
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.markupPercentageMaterialFood);

			} else if (productMaterial
					.equals(this.markups
							.getMarkupMaterialType(ConstantUtil.markupTypeEle))) {
				
				//Electronic
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.markupPercentageMaterialEle);
			} else {
				
				//Others
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.markupPercentageMaterialOthers);
			}
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void calculateProductFinalPrice() {

		if (product != null && this.product.getBasePrice() != null
				&& this.product.getBasePrice() > 0) {

			Double basePrice = this.product.getBasePrice();
			Double flatMarkup = this.markups
					.getMarkupPercetage(ConstantUtil.markupPercentageFlat);

			Double laborMarkup = this.markups
					.getMarkupPercetage(ConstantUtil.markupPercentageLabor);
			Double totalLaborMarkup = laborMarkup * this.packingLaborNumber;

			getMarkupMaterialByProduct();
			System.out.println(markupMaterialPercent);
			Double priceAfterFlatMarkup = basePrice
					+ (basePrice * flatMarkup / 100);

			Double finalPrice = priceAfterFlatMarkup
					+ (priceAfterFlatMarkup
							* (this.markupMaterialPercent + totalLaborMarkup) / 100);

			System.out.println(flatMarkup+ " "  + laborMarkup + totalLaborMarkup + " " + priceAfterFlatMarkup);
			System.out.println(finalPrice);
			this.product.setFinalPrice(finalPrice);
		}
	};
	public static void main(String[] args) {
		PropertiesUtil pU = new PropertiesUtil("properties/services.properties");
		HashMap<String, String> map = pU.getProperties("markup.percentage.material.pharmaceutical");
		System.out.println(map.get("markup.percentage.labor").toString());
	}

}
