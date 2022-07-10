package com.vishal.pages;

import org.openqa.selenium.By;

import com.vishal.enums.WaitStrategy;
import com.vishal.reports.ExtentLogger;

public class OrangeHomePage extends BasePage{

	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[@href='/index.php/auth/logout']");

	public OrangeHomePage clickWelcomeLink() {		
		click(linkWelcome,WaitStrategy.PRESENCE,"Welcome");
		return this;
	}
	
	public OrangeLoginPage clickLogout() {
		click(linkLogout,WaitStrategy.CLICKABLE,"Logout");
		ExtentLogger.pass("logout");
		return new OrangeLoginPage();
	}
}
