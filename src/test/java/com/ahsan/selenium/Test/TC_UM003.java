package com.ahsan.selenium.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_UM003 extends BaseTestScript {

	@BeforeTest
	public void loginMethod() throws Exception {
		homePg = SignIn();
	}

	@Test
	public void TC_001() throws Exception {
		homePg.verificationPage();
		homePg.clickSignOut();
	}
}
