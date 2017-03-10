package com.anh.nupack.controllers;

import java.math.BigDecimal;

import com.anh.nupack.utilities.ConstantUtil;
import com.anh.nupack.utilities.FormatUtil;

/**
 * @author AnhNguyen: This class is used to store and calculate final
 *         price(including the base price and packing services) of one product
 * 
 */
public class PackingService {

	// The product is on the packing service
	private Product product;

	// List of all markups related to the service
	private Markups markups;

	// The number of labor on the packing job for this product
	private int packingLaborNumber;

	// The material markup percentage base on the this product material
	private BigDecimal markupMaterialPercent;

	/**
	 * @param product
	 */
	public PackingService(String productName, String productMaterial,
			String basePriceStr, int packingLaborNumber) {

		BigDecimal basePrice = FormatUtil.toBigDecimal(basePriceStr);

		if (!FormatUtil.isEmpty(productName)
				&& FormatUtil.isNotNullAndZero(basePrice)) {

			if (FormatUtil.isEmpty(productMaterial))
				productMaterial = "";

			Product product = new Product(productName, productMaterial,
					basePrice);

			this.product = product;
			this.markups = new Markups();
			this.packingLaborNumber = packingLaborNumber;
		}
	}

	/**
	 * Get material percentage base on the product material
	 */
	private void getMarkupMaterialPercentageByProduct() {

		if (this.product != null
				&& FormatUtil.isNotNullAndZero(this.product.getBasePrice())) {

			String productMaterial = this.product.getProductMaterial();

			// Pharmaceutical
			if (this.markups.isUnderMaterialType(productMaterial,
					ConstantUtil.MARKUP_TYPE_PHAR)) {
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.MARKUP_PERCENTAGE_MATERIAL_PHAR);

				// Food
			} else if (this.markups.isUnderMaterialType(productMaterial,
					ConstantUtil.MARKUP_TYPE_FOOD)) {
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.MARKUP_PERCENTAGE_MATERIAL_FOOD);

				// Electronic
			} else if (this.markups.isUnderMaterialType(productMaterial,
					ConstantUtil.MARKUP_TYPE_ELE)) {
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.MARKUP_PERCENTAGE_MATERIAL_ELE);

				// Others
			} else {
				this.markupMaterialPercent = this.markups
						.getMarkupPercetage(ConstantUtil.MARKUP_PERCENTAGE_MATERIAL_OTHERS);
			}
		}
	}

	public void calculateProductFinalPrice() {

		if (this.product != null
				&& FormatUtil.isNotNullAndZero(this.product.getBasePrice())) {

			BigDecimal basePrice = this.product.getBasePrice();

			BigDecimal flatMarkup = this.markups
					.getMarkupPercetage(ConstantUtil.MARKUP_PERCENTAGE_FLAT);

			BigDecimal laborMarkup = this.markups
					.getMarkupPercetage(ConstantUtil.MARKUP_PERCENTAGE_LABOR);

			BigDecimal totalLaborMarkup = laborMarkup.multiply(new BigDecimal(
					this.packingLaborNumber));

			getMarkupMaterialPercentageByProduct();

			BigDecimal priceAfterFlatMarkup = basePrice.add((basePrice
					.multiply(flatMarkup).divide(ConstantUtil.HUNDRED)));

			BigDecimal materialLaborMarkup = this.markupMaterialPercent
					.add(totalLaborMarkup);
			BigDecimal finalPrice = priceAfterFlatMarkup
					.add((priceAfterFlatMarkup.multiply(materialLaborMarkup)
							.divide(ConstantUtil.HUNDRED)));

			this.product.setFinalPrice(finalPrice);
		}
	};

	@Override
	public String toString() {
		System.out.println(this.product);
		return "PackingService [product=" + product + ", markups=" + markups
				+ ", packingLaborNumber=" + packingLaborNumber
				+ ", markupMaterialPercent=" + markupMaterialPercent + "]";
	}

	public static void main(String[] args) {
		PackingService ps = new PackingService("asa", "food",
				"1299.99", 3);
		ps.calculateProductFinalPrice();
		System.out.println(ps);
	}

}
