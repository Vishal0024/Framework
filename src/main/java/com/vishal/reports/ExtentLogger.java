package com.vishal.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.vishal.enums.ConfigProperties;
import com.vishal.utils.PropertyUtils;
import com.vishal.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger()
	{

	}

	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);	
	}

	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(PropertyUtils.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(PropertyUtils.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	public static void skipped(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(PropertyUtils.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}
}
