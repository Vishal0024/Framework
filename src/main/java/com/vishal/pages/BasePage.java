package com.vishal.pages;

import org.openqa.selenium.By;

import com.vishal.driver.DriverManager;
import com.vishal.enums.WaitStrategy;
import com.vishal.factories.ExplicitWaitFactory;
import com.vishal.reports.ExtentLogger;

public class BasePage {

	protected void click(By by,WaitStrategy waitStrategy,String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		try {
			ExtentLogger.pass(elementName + " is clicked",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void sendKeys(By by,String text,WaitStrategy waitStrategy,String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(text);
		try {
			ExtentLogger.pass(text + " is entered successfully in " + elementName,true );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	} 
}
