package com.anh.nupack.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.anh.nupack.utilities.FormatUtil;

public class FormatUtilTest {

	@Test
	public void testToBigDecimal() {
		assertNull(FormatUtil.toBigDecimal(null));
		assertNull(FormatUtil.toBigDecimal(""));
		assertNull(FormatUtil.toBigDecimal("test"));
		assertEquals(FormatUtil.toBigDecimal("10").toString(), "10.00");
		assertEquals(FormatUtil.toBigDecimal("1.2").toString(), "1.20");
		assertEquals(FormatUtil.toBigDecimal("1.256").toString(), "1.26");
		assertEquals(FormatUtil.toBigDecimal("1.245").toString(), "1.24");
		assertEquals(FormatUtil.toBigDecimal("00000000009991.245").toString(),
				"9991.24");
	}

	@Test
	public void testToInt() {
		assertEquals(FormatUtil.toInt(null), 0);
		assertEquals(FormatUtil.toInt("test"), 0);
		assertEquals(FormatUtil.toInt("6.9"), 0);
		assertEquals(FormatUtil.toInt("454"), 454);
	}

	@Test
	public void testIsInt() {
		assertTrue(FormatUtil.isInt("0"));
		assertFalse(FormatUtil.isInt("0.9"));
		assertFalse(FormatUtil.isInt("asa"));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(FormatUtil.isEmpty(""));
		assertTrue(FormatUtil.isEmpty("    "));
		assertFalse(FormatUtil.isEmpty("asa"));
	}

	@Test
	public void testiIsNotNullAndZero() {
		assertFalse(FormatUtil.isNotNullAndZero(null));
		assertFalse(FormatUtil.isNotNullAndZero(new BigDecimal(0)));
		assertTrue(FormatUtil.isNotNullAndZero(new BigDecimal(10)));
	}

	@Test
	public void testCheckCurrenyAndReturnNumberStr() {
		assertNull(FormatUtil.checkCurrenyAndToBigDecimal(""));
		assertNull(FormatUtil.checkCurrenyAndToBigDecimal("test"));
		assertNull(FormatUtil.checkCurrenyAndToBigDecimal("$100,9,09.12"));
		assertNull(FormatUtil.checkCurrenyAndToBigDecimal("10,9fee09.12"));
		assertNull(FormatUtil.checkCurrenyAndToBigDecimal("10,909.12$"));
		assertNull(FormatUtil.checkCurrenyAndToBigDecimal("10,909.123456"));

		assertEquals(FormatUtil.checkCurrenyAndToBigDecimal("10"),
				FormatUtil.toBigDecimal("10"));
		assertEquals(FormatUtil.checkCurrenyAndToBigDecimal("$10"),
				FormatUtil.toBigDecimal("10"));
		assertEquals(FormatUtil.checkCurrenyAndToBigDecimal("$10.1264"),
				FormatUtil.toBigDecimal("10.13"));
		assertEquals(FormatUtil.checkCurrenyAndToBigDecimal("$100,909.12"),
				FormatUtil.toBigDecimal("100909.12"));
		assertEquals(FormatUtil.checkCurrenyAndToBigDecimal("00909.12"),
				FormatUtil.toBigDecimal("909.12"));
		assertEquals(FormatUtil.checkCurrenyAndToBigDecimal("00,909.12"),
				FormatUtil.toBigDecimal("909.12"));

	}
}
