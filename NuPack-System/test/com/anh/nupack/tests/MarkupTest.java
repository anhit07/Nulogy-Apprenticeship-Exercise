package com.anh.nupack.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

import com.anh.nupack.dao.Markups;
import com.anh.nupack.utilities.ConstantUtil;

public class MarkupTest {

	private Markups markup = new Markups();

	@Test
	public void testMarkups() {
		assertEquals(markup.getMarkupPercentage().size(), 7);
		assertEquals(markup.getMarkupMaterialSubType().size(), 13);
	}

	@Test
	public void testGetMarkupPercetage() {

		assertEquals(markup.getMarkupPercetage("markup.percentage.flat"),
				new BigDecimal(5).setScale(
						ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
						ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING));

		assertEquals(markup.getMarkupPercetage("markup.percentage.labor"),
				new BigDecimal(1.2).setScale(
						ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
						ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING));
		assertNull(markup.getMarkupPercetage("markup.percentage.wrong"));
	}

	@Test
	public void testGetMarkupPercetageByProductMaterial() {
		assertEquals(markup.getMarkupPercetageByProductMaterial("food"),
				new BigDecimal(13).setScale(
						ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
						ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING));

		assertEquals(markup.getMarkupPercetageByProductMaterial("vegetables"),
				new BigDecimal(13).setScale(
						ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
						ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING));

		assertEquals(markup.getMarkupPercetageByProductMaterial("drugs"),
				new BigDecimal(7.5).setScale(
						ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
						ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING));

		assertEquals(markup.getMarkupPercetageByProductMaterial("electronics"),
				new BigDecimal(2).setScale(
						ConstantUtil.DEFAULT_BIGDECIMAL_SCALE,
						ConstantUtil.DEFAULT_BIGDECIMAL_ROUNDING));


		assertNull(markup.getMarkupPercetageByProductMaterial("book"));
		assertNull(markup.getMarkupPercetageByProductMaterial("other"));
	}
}
