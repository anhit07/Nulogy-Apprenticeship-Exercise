package com.anh.nupack.utilities;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author AnhNguyen This class is used to store all final static variables used
 *         in the project
 * 
 */
public class ConstantUtil {

	// The propertied file name is stored in the project source code
	public final static String MARKUP_PROPERTIES_FILENAME = "services.properties";
	public final static String USER_PROPERTIES_FILE_PATH = "user.path";
	public final static String FILE_SEPARATOR = File.separator;

	public final static String MARKUP_PERCENTAGE_START_STRING = "markup.percentage";
	public final static String MARKUP_MATERIAL_TYPE_START_STRING = "markup.type.material";
	public final static String MARKUP_MATERIAL_TYPE_SUB_STRING = ".type.";
	public final static String MARKUP_MATERIAL_PERCENTAGE_SUB_STRING = ".percentage.";

	public final static String MARKUP_PERCENTAGE_FLAT = "markup.percentage.flat";
	public final static String MARKUP_PERCENTAGE_LABOR = "markup.percentage.labor";

	public final static String MARKUP_PERCENTAGE_MATERIAL_PHAR = "markup.percentage.material.pharmaceutical";
	public final static String MARKUP_PERCENTAGE_MATERIAL_FOOD = "markup.percentage.material.food";
	public final static String MARKUP_PERCENTAGE_MATERIAL_ELE = "markup.percentage.material.electronics";
	public final static String MARKUP_PERCENTAGE_MATERIAL_OTHERS = "markup.percentage.material.others";

	public final static String MARKUP_TYPE_PHAR = "markup.type.material.pharmaceutical";
	public final static String MARKUP_TYPE_FOOD = "markup.type.material.food";
	public final static String MARKUP_TYPE_ELE = "markup.type.material.electronics";
	public final static String MARKUP_TYPE_OTHERS = "0";

	public final static String DELIMITER_COMMA = ",";
	public final static BigDecimal HUNDRED = new BigDecimal(100);

	public final static String CURRENCY_LOCALE_COUNTRY = "price.currency.country";
	public final static String CURRENCY_LOCALE_COUNTRY_LANGUAGE = "price.currency.country.language";
	public final static String CURRENCY_LOCALE_DEFAULT = "CAD";

	public static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;
	public static final int DEFAULT_BIGDECIMAL_ROUNDING = BigDecimal.ROUND_HALF_EVEN;
	public static final int DEFAULT_BIGDECIMAL_SCALE = 2;

	public static final String SPACE = " ";

	public static final String MONEY_NUMBER_FORMAT = "%,.2f";

	public static final String CURRENCY_SIGNS = "[$���]";
}
