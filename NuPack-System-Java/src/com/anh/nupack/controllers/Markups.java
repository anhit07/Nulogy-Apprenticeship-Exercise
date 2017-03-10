package com.anh.nupack.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.anh.nupack.utilities.ConstantUtil;
import com.anh.nupack.utilities.FormatUtil;
import com.anh.nupack.utilities.PropertiesUtil;

/**
 * @author AnhNguyen This class is used to store all properties related to
 *         Markup
 * 
 */
public class Markups extends PropertiesUtil {

	// Percentage of a particular markup type(eg: flat markup percentage is 5%)
	private HashMap<String, String> markupPercentage;

	// Search string of all markup types of materials(eg: food, electronics)
	private HashMap<String, String> markupMaterialType;

	private static HashMap<String, String> markupMaterialType2;

	/**
	 * Class constructor: Call super class constructor(PropertiesUtil) to load
	 * all properties and extract all markup-related properties to
	 * markupPercentage and markupMaterialType
	 */
	public Markups() {
		super(ConstantUtil.MARKUP_PROPERTIES_FILENAME);
		this.markupPercentage = super
				.getProperties(ConstantUtil.MARKUP_PERCENTAGE_START_STRING);
		this.markupMaterialType = super
				.getProperties(ConstantUtil.MARKUP_MATERIAL_TYPE_START_STRING);
		initMaterialTypeMap();
	}

	/**
	 * markupMaterialType Getter
	 * 
	 * @return markupMaterialType
	 */
	public HashMap<String, String> getMarkupMaterialType() {
		return markupMaterialType;
	}

	/**
	 * Get value(percentage) of a specific markup type
	 * 
	 * @param markupPercentageKey
	 * @return percentage converted to Double
	 */
	public BigDecimal getMarkupPercetage(String markupPercentageKey) {
		return FormatUtil.toBigDecimal(markupPercentage
				.get(markupPercentageKey));
	}

	/**
	 * Get search string a specific material markup type
	 * 
	 * @param marterialType
	 * @return String of a material markup type
	 */
	public String getMarkupMaterialType(String marterialType) {
		return markupMaterialType.get(marterialType);
	}

	/**
	 * Check input product material belong to one of 3 defined groups of markup
	 * type(food, electronics and pharmaceutical)
	 * 
	 * @param productMaterial
	 *            , marterialType
	 * @return String of a material markup type
	 */
	public boolean isUnderMaterialType(String productMaterial,
			String marterialType) {
		String type = markupMaterialType2.get(productMaterial);
		if (type!=null) {
			return type.equals(marterialType);
		}
		else {
			return false;
		}
	}

	private void initMaterialTypeMap() {
		markupMaterialType2 = new HashMap<String,String>();
		Iterator<Entry<String,String>> it = markupMaterialType.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String,String> pair = it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			
			String[] subMaterialTypes = pair.getValue().split(",");

			for (int i = 0; i < subMaterialTypes.length; i++) {
				String subMaterialType = subMaterialTypes[i].trim();
				markupMaterialType2.put(subMaterialType, pair.getKey());
			}
			
		}
	}

	public static void main(String[] args) {
		Markups markups = new Markups();
		/*System.out.println(markups
				.getMarkupMaterialType("markup.type.pharmaceutical"));
		System.out.println(markups.isUnderMaterialType("drug",
				"markup.type.pharmaceutical"));*/
		//System.out.println(markupMaterialType2.toString());
		System.out.println(markups.isUnderMaterialType("i",
				"markup.type.pharmaceutical"));
	}
}
