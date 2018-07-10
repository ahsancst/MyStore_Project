package com.ahsan.selenium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class SignIn_Page_Object extends BasePageObject {

	public SignIn_Page_Object(WebDriver driver1) {
		super(driver1);
	}

	public void clickSignInLink() {
		try {
			uiClick(driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")));
		} catch (Error e) {
			System.out.println("Unable to click the Signin link " + e);
		}
	}

	public void enterUserName(String username) throws Exception {
		try {
			uiSendKeys(driver.findElement(By.xpath("//div[1]/input[contains(@id,'email')]")), username);
		} catch (Error e) {
			System.out.println("Unable to enter the username " + e);
		}
		Thread.sleep(2000);
	}

	public void enterPassword(String password) throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)");
			Thread.sleep(2000);

			uiSendKeys(driver.findElement(By.xpath("//input[contains(@id,'passwd')]")), password);
		} catch (Error e) {
			System.out.println("Unable to enter the password " + e);
		}
		Thread.sleep(2000);
	}

	public Home_Page_Object clickSignIn() throws Exception {
		try {
			Home_Page_Object homePg = new Home_Page_Object(driver);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, -250)");
			Thread.sleep(2000);

			uiClick(driver.findElement(By.xpath("//button[contains(@id,'SubmitLogin')]")));
			Thread.sleep(2000);
			return homePg;
		} catch (Error e) {
			System.out.println("Unable to click the sign in button " + e);
			Thread.sleep(2000);
			return null;
		}

	}
}
