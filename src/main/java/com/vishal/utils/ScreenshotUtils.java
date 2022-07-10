package com.vishal.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vishal.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {
		
	}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
