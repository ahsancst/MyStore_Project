package com.ahsan.selenium.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	static WebDriver driver;
	
	
	public BasePageObject(WebDriver driver1) {
		driver = driver1;
	}
	
	// Click Function
	public void uiClick(WebElement uiElement){
		uiElement.click();
	}
	
	//  SendKey Function
	public void uiSendKeys(WebElement uiElement,String value) {
		uiElement.clear();
		uiElement.sendKeys(value);
	}
	
	// IsDiplay Function
	public Boolean uiIsDisplayed(WebElement uiElement) {
		if (uiElement.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	// IsEnable Function
	public Boolean  uiIsEnabled(WebElement uiElement) {
		boolean status;
		if(uiElement.isEnabled()){
			status	=	true;
		}else{
			status	=	false;
		}
		return status;	
	}
	
	// Select Function
	public void uiSelectByVisibleText(Select uiElement,String value) {
		uiElement.selectByVisibleText(value);
	}
	
	// DeSelect Function
	public void uiDeselectAll(Select uiElement){
		uiElement.deselectAll();
	}
	
	// Get Text Function
	public String uiGetText(WebElement uiElement) {
		return uiElement.getText();
	}
	
	// Clear Function
	public void uiClear(WebElement uiElement) {
		uiElement.clear();
	}
	
	// Alert Function
	public void uiAlertOkBtnClick() {
		try {
			Alert alert	=driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
		
	
	public boolean uiWaitForElementPresent(String xpath){
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		boolean status;
		if(element.isEnabled()){
			status	=	true;
		}else{
			status	=	false;
		}
		
		return status;
	}
}
