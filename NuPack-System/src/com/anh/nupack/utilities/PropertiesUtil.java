package com.anh.nupack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author AnhNguyen. This class is used to get all properties from a properties
 *         file (services.properties)
 */
/**
 * @author user
 * 
 */
public class PropertiesUtil {

	private Properties properties;

	/**
	 * @param filename
	 *            Class constructor specifying the filename of the properties
	 *            file will be loaded. It will load all pairs of
	 *            property(key,value) string to the field Properties.
	 * 
	 *            If user does not specify the System property - user.path, the
	 *            file name in the embedded resource folder will be loaded
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

			// If the file cannot be loaded
			if (input != null) {
				this.properties = new Properties();
				this.properties.load(input);
			} else {
				System.out
						.println("There is a problem when loading the properties file or the file not found");
			}
		} catch (NullPointerException | IOException ex) {
			// ex.printStackTrace();
			System.out
					.println("There is a problem when loading the properties file or the file not found");

		}
	}

	/**
	 * Extract all properties with the key starts with "startString"
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
					objectProperties.put(name.trim(), value.trim());
				}
			}
			return objectProperties;
		} else {
			return null;
		}
	}

	/**
	 * Get the property value by property key
	 * 
	 * @param propertyName
	 * @return
	 */
	public String getProperty(String propertyName) {
		if (this.properties != null) {
			return this.properties.getProperty(propertyName.trim());
		} else {
			return null;
		}
	}

	public Properties getProperties() {
		return properties;
	}

}
