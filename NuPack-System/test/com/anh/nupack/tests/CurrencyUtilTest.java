package com.anh.nupack.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.anh.nupack.utilities.ConstantUtil;
import com.anh.nupack.utilities.CurrencyUtil;

public class CurrencyUtilTest {

	private CurrencyUtil currUtil = new CurrencyUtil();

	@Test
	public void testToCurrency() {
		BigDecimal amount1 = new BigDecimal(10).setScale(
				ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
				ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING);
		assertEquals(currUtil.toCurrency(amount1), "$10.00");

		BigDecimal amount2 = new BigDecimal(10.12355).setScale(
				ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
				ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING);
		assertEquals(currUtil.toCurrency(amount2), "$10.12");

		BigDecimal amount3 = new BigDecimal(10898987780.12455).setScale(
				ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
				ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING);
		assertEquals(currUtil.toCurrency(amount3), "$10,898,987,780.12");

		BigDecimal amount4 = new BigDecimal(10898987780.12555).setScale(
				ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
				ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING);
		assertEquals(currUtil.toCurrency(amount4), "$10,898,987,780.13");
	}

	
}
