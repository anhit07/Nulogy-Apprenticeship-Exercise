package com.anh.nupack.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import com.anh.nupack.utilities.ConstantUtil;
import com.anh.nupack.utilities.PropertiesUtil;

public class PropertiesUtilTest {

	private PropertiesUtil pro1 = new PropertiesUtil(null);
	private PropertiesUtil pro2 = new PropertiesUtil("wrong file name");
	private PropertiesUtil pro3 = new PropertiesUtil(
			ConstantUtil.MARKUP_PROPERTIES_FILENAME);

	@Before
	public void init() {

	}

	@Test
	public void testPropertiesUtil() {
		assertNull("Constructor PropertiesUtil", pro1.getProperties());
		assertNull("Constructor PropertiesUtil", pro2.getProperties());
		assertNotNull("Constructor PropertiesUtil", pro3.getProperties());
	}

	@Test
	public void testGetProperties() {
		HashMap<String, String> map1 = pro1.getProperties("markup.type");
		assertNull(map1);
		HashMap<String, String> map2 = pro2.getProperties("markup.type");
		assertNull(map2);

		HashMap<String, String> map3 = pro3.getProperties("markup.type");
		assertEquals(map3.size(), 5);
		assertEquals(map3.get("markup.type.material.food"), "food,vegetables,fruit");

	}

	@Test
	public void testGetProperty() {

		assertNull(pro1.getProperty("markup.type.flat"));
		assertNull(pro2.getProperty("markup.type.flat"));

		assertEquals(pro3.getProperty("markup.type.flat"), "flat");
		assertEquals(pro3.getProperty("price.currency.country"), "ca");
		assertNull(pro3.getProperty("markup.type"));

	}

	@Test
	public void testLoadPropertiesFromSystemPath() {
		System.setProperty(ConstantUtil.USER_PROPERTIES_FILE_PATH,
				"C:/Users/user/Java/resource");
		PropertiesUtil pro4 = new PropertiesUtil(
				ConstantUtil.MARKUP_PROPERTIES_FILENAME);

		assertEquals(pro4.getProperties().size(), 13);

		System.setProperty(ConstantUtil.USER_PROPERTIES_FILE_PATH,
				"C:/Users/user/Java/resource");

		HashMap<String, String> map4 = pro4.getProperties("price.currency");
		assertEquals(map4.size(), 2);
		assertEquals(map4.get("price.currency.country"), "us");

		assertEquals(pro4.getProperty("price.currency.country"), "us");
		assertNull(pro4.getProperty("markup.type"));

	}
}
