package com.codinground.uiActions;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUIActions {
	
	private WebDriver driver;
	
	
	public CommonUIActions(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	public void iHandleFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	
	public void iHandleFrame (int indx)
	{
		
		driver.switchTo().frame(indx);
		
	}
	
   public void checkNumberOfFrames()
   {
	   
	   JavascriptExecutor exe = (JavascriptExecutor) driver;
		 Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		 System.out.println("Number of iframes on the page are " + numberOfFrames);
   }
   
   
   public boolean isElementDisplayed(WebElement element)
   {
	  return element.isDisplayed();
   }
   
   
   public void selectDate(String Mymonth,String Myday)
   {
	   
	   java.util.List<WebElement> ForAllTwoMonths  = driver.findElements(By.xpath(".//*[@class='ctDatePicker']/div"));
	   
	   // This check for 
	   for (WebElement month : ForAllTwoMonths) {
		   
		   if (month.toString().equalsIgnoreCase("break")) {
			   break;
		   } else if (month.findElement(By.xpath("//*[@class='header']//*[contains(text(),"+Mymonth+")]")).isDisplayed()) {
			   
			   java.util.List<WebElement> rows = month.findElements(By.xpath("//*[@class='calendar']/tbody/tr"));
			   for (WebElement row : rows) {
				
				   java.util.List<WebElement> days = row.findElements(By.xpath("td"));
				   
				   for (WebElement day : days) {
					  
					   if (day.findElement(By.xpath("/a")).equals(Myday)) 
					   {
						   
						   day.findElement(By.xpath("/a")).click();
						}
					
						
					}
					   
					   
					
				}
			}
			
		}
		  
		
	}
	   
	   public void dateIsSelected()
	   {
		   //.//*[@id='FromDate' and @value='13/12/2018']
		   
		   
	   }
	   
	   
	   
	   
	   
	   
	   
   }


