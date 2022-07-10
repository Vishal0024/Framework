package com.vishal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.vishal.constants.FrameworkConstants;
import com.vishal.enums.ConfigProperties;

public class PropertyUtils {

	private PropertyUtils() {
		
	}
	
	private static Properties prop =  new Properties();
	private static final Map<String,String> configMap = new HashMap<>();
			
	static {
		FileInputStream fileObj;
		try {
			fileObj = new FileInputStream(FrameworkConstants.getConfigFilepath());
			prop.load(fileObj);
			
			for(Map.Entry<Object, Object> entry: prop.entrySet()) {
				configMap.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(configMap.get(key.name().toLowerCase()))){
			throw new Exception("Property Name " + key + " is not found. Please check config.properties");
		}
		return String.valueOf(configMap.get(key.name().toLowerCase()));
	}
}
