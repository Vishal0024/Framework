package com.vishal.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vishal.constants.FrameworkConstants;
import com.vishal.enums.ConfigProperties;
import com.vishal.utils.PropertyUtils;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
				DriverManager.setDriver(new ChromeDriver());
			}
			else
			{
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
				DriverManager.setDriver(new FirefoxDriver());
			}
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
