package com.anh.spring.nupack.controller;

import java.util.HashMap;

import com.anh.spring.nupack.utilities.ConstantUtil;
import com.anh.spring.nupack.utilities.FormatUtil;
import com.anh.spring.nupack.utilities.PropertiesUtil;

public class Markups extends PropertiesUtil {

	/*
	 * private double flatMarkupPercentage;
	 * 
	 * private double materialMarkupPercentage;//base on product input
	 * 
	 * private double laborMarkupPercentage;
	 */
	private HashMap<String, String> markupPercentage;
	private HashMap<String, String> markupMaterialType;

	public Markups() {
		super(ConstantUtil.markupPropertiesFileName);
		this.markupPercentage = super.getProperties(ConstantUtil.markupPercentageStartString);
		this.markupMaterialType = super.getProperties(ConstantUtil.markupMaterialTypeStartString);
	}

	
	public HashMap<String, String> getMarkupMaterialType() {
		return markupMaterialType;
	}


	public Double getMarkupPercetage(String markupPercentageKey) {
		return FormatUtil.toDouble(markupPercentage.get(markupPercentageKey));
	}


	public String getMarkupMaterialType(String marterialType) {
		return markupMaterialType.get(marterialType);
	}


	public static void main(String[] args) {
		Markups markups = new Markups();
		System.out.println(markups.getMarkupMaterialType("markup.type.electronics"));
	}
}
