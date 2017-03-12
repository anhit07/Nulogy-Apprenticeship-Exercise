package com.anh.nupack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author AnhNguyen. This class is used to get all properties from a properties
 *         file
 */
public class PropertiesUtil {

	private Properties properties;

	/**
	 * @param filename
	 *            Class constructor specifying the filename of the properties
	 *            file loaded. It will load all propeties string to the field
	 *            Properties.
	 * 
	 *            If user doesnt specify the System property - basePath, the
	 *            file name in the jar folder will be loaded
	 * 
	 *            If user specify the System property - basePath, the file name
	 *            in the folder of base path will be loaded
	 */
	public PropertiesUtil(String fileName) {

		try {
			InputStream input;
			if (System.getProperty(ConstantUtil.USER_PROPERTIES_FILE_PATH) != null) {

				String userDirPath = System
						.getProperty(ConstantUtil.USER_PROPERTIES_FILE_PATH);

				if (!userDirPath.endsWith(ConstantUtil.FILE_SEPARATOR))
					userDirPath = userDirPath + ConstantUtil.FILE_SEPARATOR;

				fileName = userDirPath + fileName;
				input = new FileInputStream(fileName);
			} else {
				input = this.getClass().getClassLoader()
						.getResourceAsStream(fileName);
			}
			this.properties = new Properties();
			this.properties.load(input);
		} catch (NullPointerException | IOException ex) {
			// ex.printStackTrace();
			System.out
					.println("There is a problem when loading the properties file or the file not found");
		}
	}

	/**
	 * Extract all properties related to a same object
	 * 
	 * @param startString
	 * @return a HashMap<String, String> which is the list of pair(key, value)
	 *         in the properties file starts with the string "startString"
	 */
	public HashMap<String, String> getProperties(String startString) {
		if (this.properties != null) {
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

	/**
	 * Get the property value by property name/key
	 * 
	 * @param propertyName
	 * @return
	 */
	public String getProperty(String propertyName) {
		if (this.properties != null) {
			return this.properties.getProperty(propertyName);
		} else {
			return null;
		}
	}
}
