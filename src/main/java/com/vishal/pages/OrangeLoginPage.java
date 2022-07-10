package com.vishal.pages;

import org.openqa.selenium.By;

import com.vishal.enums.WaitStrategy;

public final class OrangeLoginPage extends BasePage{

	private final By textboxUsername = By.id("txtUsername");
	private final By textboxPassword = By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By buttonLogin = By.id("btnLogin");
	
	public OrangeLoginPage enterUsername(String username) {
		sendKeys(textboxUsername, username,WaitStrategy.PRESENCE,"Username");
		return this;
	}
	
	public OrangeLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password,WaitStrategy.PRESENCE,"Password");
		return this;
	}
	
	public OrangeHomePage clickLogin() {
		click(buttonLogin,WaitStrategy.CLICKABLE,"Login");
		return new OrangeHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
}
