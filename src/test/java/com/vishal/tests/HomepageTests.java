package com.vishal.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vishal.driver.DriverManager;

public final class HomepageTests extends BaseTest {

	private HomepageTests() {
	}

	/*
	 * Validate whether the page title is containing google search Validate whether
	 * the page title is not null and length if title is > 50 and < 100 Validate the
	 * link in the page --> Testing mini bytes - youtube Validate the number of
	 * links
	 */
	@Test
	public void test2() throws InterruptedException {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Bytes", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();

	    assertThat(title)
			.isNotNull()
			.containsIgnoringCase("google search")
			.hasSizeBetween(30, 100)
			.endsWith("Google Search");

		List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//a/h3"));

//		assertThat(elements)
//			.hasSize(9)
//			.extracting(e->e.getText())
//			.contains("Testing Mini Bytes - YouTube");

	}
}
