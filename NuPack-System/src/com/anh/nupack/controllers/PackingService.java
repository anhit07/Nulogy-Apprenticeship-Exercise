package com.anh.nupack.controllers;

import java.math.BigDecimal;

import com.anh.nupack.dao.Markups;
import com.anh.nupack.dao.Product;
import com.anh.nupack.utilities.ConstantUtil;
import com.anh.nupack.utilities.CurrencyUtil;
import com.anh.nupack.utilities.FormatUtil;

/**
 * @author AnhNguyen: This class is used to store and calculate final
 *         price(including the base price and packing services) of one product
 * 
 */
/**
 * @author user
 * 
 */
public class PackingService {

	// The product is on the packing service
	private Product product;

	// The number of labor on the packing job for this product
	private int packingLaborNumber;

	// The material markup percentage base on the this product material
	private BigDecimal markupMaterialPercent;

	// List of all markups related to the service
	private Markups markups;

	// Process for converting number to currency format
	private CurrencyUtil currencyUtil;

	public PackingService() {
	}

	/**
	 * Initialize information of packed product object, number of people working
	 * on packing service for this product and markup percentage related to
	 * packing service
	 * 
	 * @param productName
	 * @param productMaterial
	 * @param basePriceStr
	 * @param packingLaborNumber
	 */
	public PackingService(String productName, String productMaterial,
			BigDecimal basePrice, String packingLaborNumber) {

		if (!FormatUtil.isEmpty(productName)
				&& FormatUtil.isNotNullAndZero(basePrice)) {

			if (FormatUtil.isEmpty(productMaterial))
				productMaterial = "";

			Product product = new Product(productName, productMaterial,
					basePrice);

			this.product = product;
			this.markups = new Markups();
			this.packingLaborNumber = FormatUtil.toInt(packingLaborNumber);
			this.currencyUtil = new CurrencyUtil();
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

	/**
	 * Calculate the final price of product after applying all markup
	 * percentages on it and set in the field finalPrice of Product object
	 */
	public Product calculateProductFinalPrice() {

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

			// The price after applying the flat markup
			BigDecimal priceAfterFlatMarkup = basePrice.add((basePrice
					.multiply(flatMarkup).divide(ConstantUtil.HUNDRED)));

			BigDecimal materialLaborMarkup = this.markupMaterialPercent
					.add(totalLaborMarkup);

			// The final price after applying the material and labor markup on
			// the price of base price plus flat markup
			BigDecimal finalPrice = priceAfterFlatMarkup
					.add((priceAfterFlatMarkup.multiply(materialLaborMarkup)
							.divide(ConstantUtil.HUNDRED)));

			this.product.setFinalPrice(finalPrice);
			return this.product;
		}
		return null;
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() Print out all information about the
	 * product is on the packing service, the number of people on job and the
	 * calculated final price
	 */
	@Override
	public String toString() {
		String response = "The product has been proccessed calculation for packing service";
		response = response + "\n Product name: " + product.getProductName()
				+ "\n Product material: " + product.getProductMaterial()
				+ "\n Product base price: "
				+ currencyUtil.toCurrency(product.getBasePrice())
				+ "\n Number of packing labor: " + this.packingLaborNumber
				+ "\n Final product price: "
				+ currencyUtil.toCurrency(product.getFinalPrice());

		return response;
	}

	/**
	 * 
	 * This methods is used to validate the input from users and call packing
	 * service with corresponding input information and return the string all
	 * information processed and calculated the final price
	 * 
	 * @param productName
	 * @param productMaterial
	 * @param basePriceStr
	 * @param packingLaborNumber
	 * @return
	 */
	public Product doPackingService(String productName, String productMaterial,
			String basePriceStr, String packingLaborNumber) {
		StringBuilder response = new StringBuilder("");
		boolean isValidInput = true;
		BigDecimal basePrice = null;

		if (FormatUtil.isEmpty(productName)) {
			response.append("Product name is empty");
			isValidInput = false;
		}

		if (FormatUtil.isEmpty(productMaterial)) {
			if (!isValidInput) {
				response.append("\n");
			}
			response.append("Product material is empty");
			isValidInput = false;
		}

		if (FormatUtil.isEmpty(basePriceStr)) {
			if (!isValidInput) {
				response.append("\n");
			}
			response.append("Base price of product is empty");
			isValidInput = false;
		}

		if (FormatUtil.isEmpty(packingLaborNumber)) {
			if (!isValidInput) {
				response.append("\n");
			}
			response.append("Number of packing labor is empty");
			isValidInput = false;
		}

		if (!FormatUtil.isEmpty(basePriceStr)) {
			basePrice = FormatUtil.checkCurrenyAndToBigDecimal(basePriceStr);
			if (!FormatUtil.isNotNullAndZero(basePrice)) {
				if (!isValidInput) {
					response.append("\n");
				}
				response.append("The base price of product is invalid");
				isValidInput = false;
			}
		}

		if (!FormatUtil.isEmpty(packingLaborNumber)) {
			if (!FormatUtil.isInt(packingLaborNumber)) {
				if (!isValidInput) {
					response.append("\n");
				}
				response.append("The number of packing labor is invalid");
				isValidInput = false;
			}
		}
		if (isValidInput) {
			PackingService packingService = new PackingService(productName,
					productMaterial, basePrice, packingLaborNumber);
			Product result  = packingService.calculateProductFinalPrice();
			System.out.println(packingService.toString());
			return result;
		} else {
			// System.out.println(response.toString());
			System.out
					.println("Please check and enter again these following inforamtion:\n"
							+ response.toString());
			return null;
		}
		
	}

	public Product getProduct() {
		return this.product;
	}

}
