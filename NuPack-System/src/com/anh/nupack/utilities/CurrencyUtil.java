package com.anh.nupack.utilities;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * This class is used to convert the BigDecimal number to currency corresponding
 * to the currency code user input in service properties file. Eg:
 * price.currency = CAD(for Canada dollars)
 * 
 * @author AnhNguyen
 * 
 */
public class CurrencyUtil {

	private Currency localeCurrency;
	private Locale country;

	/**
	 * Load price.currency from properties file
	 */
	public CurrencyUtil() {
		PropertiesUtil prop = new PropertiesUtil(
				ConstantUtil.MARKUP_PROPERTIES_FILENAME);

		// Load the defined country and language on the properties file
		String localeCountry = prop
				.getProperty(ConstantUtil.CURRENCY_LOCALE_COUNTRY);
		String localeCountryLanguage = prop
				.getProperty(ConstantUtil.CURRENCY_LOCALE_COUNTRY_LANGUAGE);

		if (!FormatUtil.isEmpty(localeCountry)) {
			country = new Locale(localeCountryLanguage, localeCountry);

			// Get currency form defined country
			try {
				this.localeCurrency = Currency.getInstance(country);
			} catch (IllegalArgumentException ex) {
				// If any exception, get the default currency(CAD)
				this.localeCurrency = Currency
						.getInstance(ConstantUtil.CURRENCY_LOCALE_DEFAULT);
				country = null;
			}

			// If country is not defined, get the default currency(CAD)
		} else {
			this.localeCurrency = Currency
					.getInstance(ConstantUtil.CURRENCY_LOCALE_DEFAULT);
		}
	}

	/**
	 * Convert the money in BigDecimal to the String formated with currency sign
	 * and defined number format
	 * 
	 * @param amount
	 * @return
	 */
	public String toCurrency(BigDecimal amount) {
		if (amount != null) {
			String moneyString = amount.toString();
			if (this.localeCurrency != null) {
				amount = amount.setScale(
						this.localeCurrency.getDefaultFractionDigits(),
						ConstantUtil.DEFAULT_ROUNDING);
				if (country != null) {
					moneyString = localeCurrency.getSymbol(country)
							+ String.format(ConstantUtil.MONEY_NUMBER_FORMAT,
									amount);
				} else {
					moneyString = localeCurrency.getSymbol(Locale.CANADA)
							+ String.format(ConstantUtil.MONEY_NUMBER_FORMAT,
									amount);
				}
			}
			return moneyString;
		}
		return null;
	}
}
