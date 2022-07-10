package com.vishal.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.vishal.enums.ConfigProperties;
import com.vishal.utils.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if (PropertyUtils.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value = count < retries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
