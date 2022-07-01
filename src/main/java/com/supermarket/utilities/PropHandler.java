package com.supermarket.utilities;

import java.io.FileInputStream;
import java.util.Properties;

import com.supermarket.constants.ConstantsClass;

public class PropHandler {
	Properties prop;
	FileInputStream ip;

	public PropHandler() {
		prop = new Properties();

		try {
			ip = new FileInputStream(ConstantsClass.CONFIG_FILE_PATH);
			prop.load(ip);

		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}

	public String getPropertiesFileData(String key) {
		return prop.getProperty(key);
	}

}
