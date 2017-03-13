package com.anh.nupack.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.anh.nupack.controllers.PackingService;
import com.anh.nupack.dao.Product;
import com.anh.nupack.utilities.CurrencyUtil;

public class PackingServiceTest {

	PackingService packing;
	CurrencyUtil currUtil;

	@Before
	public void init() {
		packing = new PackingService();
		currUtil = new CurrencyUtil();
	}

	@Test
	public void testDoPackingService() {

		assertNull(packing.doPackingService(null, null, null, null));
		assertNull(packing.doPackingService("product1", null, null, null));
		assertNull(packing.doPackingService("product1", "food", null, null));
		assertNull(packing.doPackingService("product1", "food", "", null));
		assertNull(packing.doPackingService("product1", "food", "test", "test"));
		assertNull(packing.doPackingService("product1", "food", "0", "0"));
		assertNull(packing.doPackingService("product1", "food", "12asa99.99",
				"0"));
		assertNull(packing
				.doPackingService("product1", "food", "129,9.99", "0"));
		assertNull(packing.doPackingService("product1", "food", "129,9.99$",
				"0"));
		assertNull(packing.doPackingService("product1", "food", "$$1299.99",
				"0"));

		Product pro1 = packing.doPackingService("product1", "food",
				"$1,299.99", "3");
		assertEquals(currUtil.toCurrency(pro1.getFinalPrice()), "$1,591.58");

		Product pro2 = packing.doPackingService("product1", "drugs",
				"$5,432.00", "1");
		assertEquals(currUtil.toCurrency(pro2.getFinalPrice()), "$6,199.81");

		Product pro3 = packing.doPackingService("product1", "books",
				"$12,456.95", "4");
		assertEquals(currUtil.toCurrency(pro3.getFinalPrice()), "$13,707.63");

		Product pro4 = packing.doPackingService("product1", "food", "1299.99",
				"3");
		assertEquals(currUtil.toCurrency(pro4.getFinalPrice()), "$1,591.58");

		Product pro5 = packing.doPackingService("product1", "food", "1299.99",
				"0");
		assertEquals(currUtil.toCurrency(pro5.getFinalPrice()), "$1,542.44");

	}

}
