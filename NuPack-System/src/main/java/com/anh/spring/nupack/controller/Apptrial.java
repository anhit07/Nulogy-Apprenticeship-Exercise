package com.anh.spring.nupack.controller;

import com.anh.spring.nupack.utilities.FormatUtil;

public class Apptrial {

	public static void main(String[] args) {

		/*String productName = args[0];
		String productMaterials = args[1];
		Double basePrice = FormatUtil.toDouble(args[3]);*/
		
		String productName = "Pro";
		String productMaterials = "pharMarkup";
		Double basePrice = FormatUtil.toDouble("129999.3 ");

		Product product = new Product(productName, productMaterials, basePrice);
		PackingService packingService = new PackingService(product,3);
		packingService.calculateProductFinalPrice();
		System.out.println(packingService.toString());
		System.out.println(packingService.getProduct().toString());
	}
}
