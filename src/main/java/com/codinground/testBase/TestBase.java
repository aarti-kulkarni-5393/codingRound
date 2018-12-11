package com.codinground.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.plaf.FileChooserUI;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;
import com.google.j2objc.annotations.Property;

public class TestBase {

	private WebDriver driver;
	
	
	/*
	 * This method will setup your test browser and launch it with given URL
	 */
	public void setup(String testBrowser ,String TestURL)
	{
		setBrowser(testBrowser);
		
		getUrl(TestURL);
	}
	
	/* 
	 * This method will set given browser details  
	 */
	public void setBrowser(String browser)
	{
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("usr.dir")+"//src//main//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//drivers//geckodriver.exe");
		}
		else if (browser.equalsIgnoreCase("") || browser.isEmpty()) {
		   
		}
		
	}
	
	/*
	 * This method will take URL and navigate to given URL
	 * parameter url = application url
	 */
	public void getUrl(String url)
	{
		driver.get(url);
	}
	
	/*
	 * This method will capture screenshot and return screenshot name
	 * parameter imageName= test case name
	 */
	public String getScreenShot(String imageName) throws IOException
	{
		
		if (imageName.equals("")) {
			imageName= "blank";
		}
		
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imageLocation = System.getProperty("user.dir")+"/src/main/screenshots/";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("DD_MM_YY_hh_mm_SS");
		String actualImageName = imageLocation+"_"+dateformat.format(cal.getTime())+".png";
		File Destfile = new File(actualImageName);
		Files.copy(image, Destfile);
		
		return actualImageName;
	}
  
}
