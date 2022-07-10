package com.vishal.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.vishal.driver.DriverManager;

public final class LoginpageTests extends BaseTest{
	
	private LoginpageTests() {
	}
	
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium",Keys.ENTER);
	}
}
