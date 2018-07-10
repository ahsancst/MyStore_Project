package com.ahsan.selenium.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ahsan.selenium.PageObjects.Home_Page_Object;
import com.ahsan.selenium.PageObjects.SignIn_Page_Object;

public class BaseTestScript {
	public static WebDriver driver;
	String Environment = "QA";

	public static Properties prop = new Properties();
	public static String contactCodeGlobal;
	public static Home_Page_Object homePg;


	@BeforeTest
	public void testSetUp() throws InterruptedException {
		
		initData();
		if (prop.getProperty("browser").equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (prop.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/resources/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src/resources/Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.navigate().to(prop.getProperty("enviromenturl"));
	}

	public void initData() {
		try {
			if (Environment.equals("QA")) {
				prop.load(new FileInputStream("src/resources/testData/data_QA.properties"));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error IO exception");
			e.printStackTrace();
		}
	}

	@AfterClass
	public void logout() throws Exception {
		Thread.sleep(2000);
		System.out.println("/************** After Class Executed.**************/");
		System.out.println("Testcase End : " + this.getClass().getName());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public Home_Page_Object SignIn() throws Exception {

		driver.navigate().to(prop.getProperty("enviromenturl"));
		System.out.println("Enter Url..............");
		Thread.sleep(3000);

		SignIn_Page_Object signInPg = new SignIn_Page_Object(driver);
		signInPg.clickSignInLink();
		signInPg.enterUserName(prop.getProperty("username"));	
		signInPg.enterPassword(prop.getProperty("password"));
		homePg = signInPg.clickSignIn();
		System.out.println("Successfuly login.");
		Thread.sleep(1000);
		System.out.println("Testcase started");

		return homePg;
	}
}
