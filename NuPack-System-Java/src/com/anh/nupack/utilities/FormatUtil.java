package com.anh.nupack.utilities;

import java.math.BigDecimal;

public final class FormatUtil {

	public FormatUtil() {
		// TODO Auto-generated constructor stub
	}

	public static BigDecimal toBigDecimal(String numberString) {
		try {
			BigDecimal converterNumber = new BigDecimal(numberString);
			return converterNumber;
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}
	
	public static Double toDouble(String numberString) {
		try {
			Double converterNumber = new Double(numberString);
			return converterNumber;
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}
	
	public static int toInt(String numberString) {
		try {
			int converterNumber = Integer.parseInt(numberString);
			return converterNumber;
		} catch (NullPointerException | NumberFormatException e) {
			return 0;
		}
	}

	public static boolean isEmpty(String string) {
		if (string == null || string.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isNotNullAndZero(BigDecimal number){
		if(number == null || (number.compareTo(new BigDecimal(0)) != 1)){
			return false;
		}
		return true;
	}
}
