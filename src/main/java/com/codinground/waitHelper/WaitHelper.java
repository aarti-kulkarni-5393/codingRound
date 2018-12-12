package com.codinground.waitHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	WebDriver driver;
	WebDriverWait waitDriver;
	
	public WaitHelper(WebDriver driver) {
		
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
	public void waitForElement(WebElement element)
	{
		waitDriver= new WebDriverWait(driver, 60);
		waitDriver.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void pageLoad()
	{
		
		
	}

}
