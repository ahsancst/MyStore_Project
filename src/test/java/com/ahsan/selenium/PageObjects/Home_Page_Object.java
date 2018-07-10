package com.ahsan.selenium.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Home_Page_Object extends BasePageObject {

	public Home_Page_Object(WebDriver driver1) {
		super(driver1);
	}

	
	public void verificationPage() throws Exception {
		try {
			Assert.assertEquals("My account - My Store", driver.getTitle());
			System.out.println("Verification Success...");
		} catch (Error e) {
			System.out.println("Verification failure...");
		}
	}
	
	public void clickSignOut() throws Exception {
		try {
			uiClick(driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")));
		} catch (Error e) {
			System.out.println("Unable to click the sign out link " + e);
		}
		Thread.sleep(2000);
	}

}


