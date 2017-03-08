package com.anh.spring.nupack.utilities;

public final class FormatUtil {

	public FormatUtil() {
		// TODO Auto-generated constructor stub
	}

	public static Double toDouble(String numberString) {
		try {
			Double converterNumber = Double.parseDouble(numberString);
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
}
