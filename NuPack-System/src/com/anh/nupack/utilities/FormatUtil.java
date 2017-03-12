package com.anh.nupack.utilities;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class has methods used to some common format such as fomat a String to a
 * specific type of Number and some validation methods for String and number
 * 
 * @author AnhNguyen
 * 
 */
public final class FormatUtil {

	public FormatUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Format a String to BigDecimal
	 * 
	 * @param numberString
	 * @return a object of BigDecimal or null
	 */
	public static BigDecimal toBigDecimal(String numberString) {
		try {
			BigDecimal converterNumber = new BigDecimal(numberString);
			return converterNumber;
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Format a String to BigDecimal
	 * 
	 * @param numberString
	 * @return a object of BigDecimal or null
	 */
	public static BigDecimal toBigDecimal(int numberInt) {
		try {
			BigDecimal converterNumber = new BigDecimal(numberInt);
			return converterNumber;
		} catch (NullPointerException | NumberFormatException e) {
			return new BigDecimal(0);
		}
	}

	/**
	 * Check the string is currency format and return string of BigDecimal if
	 * the string is valid. The valid string such as 323,234.12345 or
	 * $323,234.12345, or €323,234.12345 or ¥323,234.12345 or £323,234.12345
	 * 
	 * @param str
	 * @return
	 */
	public static String checkCurrenyAndReturnNumberStr(String str) {
		Pattern p = Pattern.compile("^" + ConstantUtil.CURRENCY_SIGNS
				+ "{0,1}(?:0|[0-9]\\d{0,2}(?:\\,{0,1}\\d{3})*).{0,1}\\d{0,5}$");
		Matcher m = p.matcher(str);
		if (m.matches()) {
			return str.replaceAll(ConstantUtil.CURRENCY_SIGNS, "").replaceAll(
					ConstantUtil.DELIMITER_COMMA, "");
		}
		return null;
	}

	/**
	 * Format a String to Double
	 * 
	 * @param numberString
	 * @return a object of Double or null
	 */
	public static Double toDouble(String numberString) {
		try {
			Double converterNumber = new Double(numberString);
			return converterNumber;
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Format a String to int
	 * 
	 * @param numberString
	 * @return int number
	 */
	public static int toInt(String numberString) {
		try {
			int converterNumber = Integer.parseInt(numberString);
			return converterNumber;
		} catch (NullPointerException | NumberFormatException e) {
			return 0;
		}
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException er) {
			return false;
		}
	}

	/**
	 * Validate a String is null or blank
	 * 
	 * @param string
	 * @return true if string is null or blank otherwise return false
	 */
	public static boolean isEmpty(String string) {
		if (string == null || string.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validate a BigDecimal object is not null and equal zero
	 * 
	 * @param number
	 * @return true if the object is not null and equal zero otherwise return
	 *         false
	 */
	public static boolean isNotNullAndZero(BigDecimal number) {
		if (number == null || (number.compareTo(new BigDecimal(0)) != 1)) {
			return false;
		}
		return true;
	}
}
