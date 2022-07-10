package com.vishal.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.vishal.pages.OrangeLoginPage;

public final class OrangeHrmTests extends BaseTest {

	private OrangeHrmTests() {

	}

	@Test
	public void loginLogoutTest(Map<String,String> data) {
		String title = new OrangeLoginPage()
				.enterUsername(data.get("username"))
				.enterPassword(data.get("password"))
				.clickLogin()
				.clickWelcomeLink()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}

	@Test
	public void newTest(Map<String,String> data)
	{
		String title = new OrangeLoginPage()
				.enterUsername(data.get("username"))
				.enterPassword(data.get("password"))
				.clickLogin()
				.clickWelcomeLink()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
}
