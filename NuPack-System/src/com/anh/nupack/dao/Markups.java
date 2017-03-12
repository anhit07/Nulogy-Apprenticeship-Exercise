package com.anh.nupack.dao;

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

	// HashMap of subtypes of material(subtypes of food, pharmaceutical,
	// electronics)
	private HashMap<String, String> markupMaterialSubType;

	/**
	 * Class constructor: Call super class constructor(PropertiesUtil) to load
	 * all properties and extract all markup-related properties to
	 * markupPercentage and markupMaterialType
	 */
	public Markups() {
		super(ConstantUtil.MARKUP_PROPERTIES_FILENAME);
		this.markupPercentage = super
				.getProperties(ConstantUtil.MARKUP_PERCENTAGE_START_STRING);
		initMaterialSubType();
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
	 * Check input product material belong to one of 3 defined groups of markup
	 * type(food, electronics and pharmaceutical)
	 * 
	 * @param productMaterial
	 *            , marterialType
	 * @return String of a material markup type
	 */
	public boolean isUnderMaterialType(String productMaterial,
			String marterialType) {
		String type = markupMaterialSubType.get(productMaterial);
		if (type != null) {
			return type.equals(marterialType);
		} else {
			return false;
		}
	}

	/**
	 * Initialize the hashMap of subtypes of material(subtypes of food,
	 * pharmaceutical, electronics)
	 */
	private void initMaterialSubType() {

		HashMap<String, String> markupMaterialType = super
				.getProperties(ConstantUtil.MARKUP_MATERIAL_TYPE_START_STRING);

		this.markupMaterialSubType = new HashMap<String, String>();
		Iterator<Entry<String, String>> it = markupMaterialType.entrySet()
				.iterator();

		while (it.hasNext()) {
			Entry<String, String> pair = it.next();
			String[] subMaterialTypes = pair.getValue().split(
					ConstantUtil.DELIMITER_COMMA);

			for (int i = 0; i < subMaterialTypes.length; i++) {
				String subMaterialType = subMaterialTypes[i].trim();
				this.markupMaterialSubType.put(subMaterialType, pair.getKey());
			}

		}
	}
}
