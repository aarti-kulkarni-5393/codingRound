package com.codinground.pageObjects.clearTripPage;
import com.codinground.uiActions.CommonUIActions;
import com.codinground.waitHelper.WaitHelper;
import com.sun.javafx.PlatformUtil;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.helpers.HeaderFooterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

   private WebDriver driver;


     @FindBy(how=How.XPATH,using = ".//*[@class='navGroup productNav withArrows']//*[@class='hotelApp ']/a")
      WebElement hotelLink;

    @FindBy(xpath = ".//input[@id='Tags']")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    @FindBy(xpath=".//h1[contains(text(),'Search for hotels')]")
    WebElement searchHotel_header;

    @FindBy(id="wgSelectChoosen")
    WebElement select_option;
    
    @FindBy(id="SearchHotelsButton")
    WebElement SearchHotelsButton;
    
    @FindBy(id="srpHeaderLabel")
    public WebElement header_hotelSearch;
    
    @FindBy(className="center colZero col19 viewController")
    public WebElement results_hotelSearch;
    
    @FindBy(id="ui-datepicker-div")
    WebElement datepicker;
    
    @FindBy(id="Home")
    WebElement home;
    
    @FindBy(xpath=".//*[@id='CheckOutDate' and @placeholder='Pick a date']")
    WebElement CheckOutDate;
    
    @FindBy(id="lineMessage ugly icon")
    WebElement error_message_date;
    
//    @FindBy(xpath=".//option[@value='Mumbai']")
//    WebElement option_cities;
    
    public HotelBookingTest(WebDriver driver) {
    	
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
    
    
    //WaitHelper helpwithwait = new WaitHelper(driver);
    public void searchHotels(String city,String From_Mnth ,String from_day,String to_month,String to_day )
    {   
    	
    	hotelLink.click();
        //helpwithwait.waitForElement(searchHotel_header);
    	localityTextBox.clear();
    	localityTextBox.sendKeys(city);
    	CommonUIActions Act = new CommonUIActions(driver);
    	driver.findElement(By.xpath(".//*[@class='autoComplete']/li[@class='list']/a[contains(text(),'"+city+"')]")).click();
    	//Act.selectElement(city, select_option);
    	try{
    	Act.selectDate(From_Mnth, from_day);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	Act.selectDate(to_month, to_day);
    	}catch (StaleElementReferenceException e) {
			
    		if (datepicker.isDisplayed()) {
    			
    			home.click();
    			CheckOutDate.click();
    			Act.selectDate(to_month, to_day);
				
			}
		}
    	travellerSelection.click();
    	SearchHotelsButton.click();
    }
    
 
//    @Test
//    public void shouldBeAbleToSearchForHotels() {
//        setDriverPath();
//
//        driver.get("https://www.cleartrip.com/");
//        hotelLink.click();
//
//        localityTextBox.sendKeys("Indiranagar, Bangalore");
//
//        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
//        searchButton.click();
//
//        driver.quit();

    

//    private void setDriverPath() {
//        if (PlatformUtil.isMac()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver");
//        }
//        if (PlatformUtil.isWindows()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        }
//        if (PlatformUtil.isLinux()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
//        }
    }


