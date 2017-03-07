package com.anh.spring.nupack.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

	final static String propFileName = "services.properties";

	public String loadProperties(String propertyKey) throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(propFileName);
		try {
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '"
						+ propFileName + "' not found in the classpath");
			}

			// get the property value and print it out
			return prop.getProperty(propertyKey);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
			return null;
		} finally {
			inputStream.close();
		}
	}

}
