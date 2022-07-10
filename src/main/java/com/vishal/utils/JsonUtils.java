package com.vishal.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishal.constants.FrameworkConstants;
import com.vishal.enums.ConfigProperties;

public class JsonUtils {
	private JsonUtils() {

	}

	private static Map<String,String> CONFIGMAP;

	static {
		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonconfigpath()), 
						new TypeReference<HashMap<String, String>>() {});
			}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
			throw new Exception("Property Name " + key + " is not found. Please check config.properties");
		}
		return String.valueOf(CONFIGMAP.get(key.name().toLowerCase()));
	}

}
