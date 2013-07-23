package utils;

import java.util.Properties;

import com.hml.weka.WekaKmeansDriver;

public class PropertyUtils {

	private Properties prop = new Properties();

	public PropertyUtils() {
		
		try {

			prop.load(WekaKmeansDriver.class.getClassLoader()
					.getResourceAsStream("config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}
}
