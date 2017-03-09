package com.anh.spring.nupack.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtil {
	
	private Properties properties;

	public PropertiesUtil() {
	}

	public PropertiesUtil (String filename) {

		try (InputStream input = getClass().getClassLoader()
				.getResourceAsStream(filename)) {
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
			} else {
				this.properties = new Properties();
				this.properties .load(input);
			}
		} catch (NullPointerException | IOException ex) {
			ex.printStackTrace();
		}
	}

	public HashMap<String, String> getProperties(String startString) {
		if(this.properties != null){
			HashMap<String, String> objectProperties = new HashMap<String, String>();

			for (Enumeration<?> e = this.properties.propertyNames(); e
						.hasMoreElements();) {

				String name = (String) e.nextElement();
				String value = this.properties.getProperty(name);
				// Select all properties of start with the startString
				if (name.startsWith(startString) && !FormatUtil.isEmpty(value)) {
					objectProperties.put(name, value);
				}
			}
			return objectProperties;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		PropertiesUtil pU = new PropertiesUtil("properties/services.properties");
		HashMap<String, String> map = pU.getProperties("markup.percentage.material.pharmaceutical");
		System.out.println(map.get("markup.percentage.labor").toString());
	}
}
