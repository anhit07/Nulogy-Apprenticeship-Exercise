package com.anh.spring.nupack.controller;

import com.anh.spring.nupack.utilities.FormatUtil;
import com.anh.spring.nupack.utilities.PropertiesUtil;

public class Markups {

	
	private double flatMarkupPercentage;

	private double materialMarkupPercentage;

	private double laborMarkupPercentage;

	public Markups() {
	}

	private PropertiesUtil proUtil;

	public Markups(String productMaterial) {
		proUtil = new PropertiesUtil();
		setFlatMarkupPercentage();
		setLaborMarkupPercentage();
		setMaterialMarkupPercentage(productMaterial);
		System.out.println(this.toString());
	}

	// Flat Markup
	public double getFlatMarkupPercentage() {
		return flatMarkupPercentage;
	}

	public void setFlatMarkupPercentage() {
		String percentageString = proUtil
				.getPropertyValue("markup.percentage.flat");

		if (!FormatUtil.isEmpty(percentageString) && FormatUtil.toDouble(percentageString) != null) {
			this.flatMarkupPercentage = FormatUtil.toDouble(percentageString);
		}
	}

	// Material Markup
	public double getMaterialMarkupPercentage() {
		return materialMarkupPercentage;
	}

	public void setMaterialMarkupPercentage(String productMaterial) {
		String percentageString = "";

		switch (productMaterial) {

		case "phar":
			percentageString = proUtil
					.getPropertyValue("markup.percentage.material.pharmaceutical");
			break;

		case "food":
			percentageString = proUtil
					.getPropertyValue("markup.percentage.material.food");
			break;

		case "ele":
			percentageString = proUtil
					.getPropertyValue("markup.percentage.material.electronics");
			break;

		default:
			percentageString = proUtil
					.getPropertyValue("markup.percentage.material.others");
			break;
		}
		if (!FormatUtil.isEmpty(percentageString) && FormatUtil.toDouble(percentageString) != null) {
			this.materialMarkupPercentage = FormatUtil
					.toDouble(percentageString);
		}
	}

	// Labor Markup
	public double getLaborMarkupPercentage() {
		return laborMarkupPercentage;
	}

	public void setLaborMarkupPercentage() {
		String percentageString = proUtil
				.getPropertyValue("markup.percentage.labor");
		if (!FormatUtil.isEmpty(percentageString) && FormatUtil.toDouble(percentageString) != null) {
			this.laborMarkupPercentage = FormatUtil.toDouble(percentageString);
		}
	}

	@Override
	public String toString() {
		return "Markups [flatMarkupPercentage=" + flatMarkupPercentage
				+ ", materialMarkupPercentage=" + materialMarkupPercentage
				+ ", laborMarkupPercentage=" + laborMarkupPercentage + "]";
	}

}
