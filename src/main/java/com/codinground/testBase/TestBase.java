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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.codinground.resourceHelper.ResourceHelper;
import com.google.common.io.Files;
import com.google.j2objc.annotations.Property;

public class TestBase {

	private WebDriver driver;
	
	
	/*
	 * This method will setup your test browser and launch it with given URL
	 */
	public WebDriver setup(String testBrowser ,String TestURL)
	{
		setBrowser(testBrowser);
	    getUrl(TestURL);
	    
	    return driver;
	}
	
	/* 
	 * This method will set given browser details  
	 */
	public WebDriver setBrowser(String browser)
	{   
		/*
		 * Replaced given chromedriver exe as it is not compatible 
		 */
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",ResourceHelper.getBasePath()+"//src//main//drivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			return driver;
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",ResourceHelper.getBasePath()+"//src//main//drivers//geckodriver.exe");
			return driver;
		}
		else if (browser.equalsIgnoreCase("") || browser.isEmpty()) {
			return null;
		}
		return null;
	}
	
	/*
	 * This method will take URL and navigate to given URL
	 * parameter url = application url
	 */
	public void getUrl(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
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
  
	public void closeBrowser()
	{
		
		driver.close();
	}
	
}
