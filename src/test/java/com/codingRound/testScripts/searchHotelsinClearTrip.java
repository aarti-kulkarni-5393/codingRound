package com.codingRound.testScripts;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.codinground.pageObjects.clearTripPage.HotelBookingTest;
import com.codinground.pageObjects.clearTripPage.SignInTest;
import com.codinground.testBase.TestBase;
import com.codinground.uiActions.CommonUIActions;

public class searchHotelsinClearTrip extends TestBase  {
    public WebDriver driver;
	@Before
	public void setUp() throws Exception {
		
		driver = setup("chrome", "https://www.cleartrip.com/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		 SignInTest obj_signIn = new SignInTest(driver);
		//signing with valid user
		 obj_signIn.signINClearTrip("er.aartikulkarni@gmail.com", "aarti@123");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		 Assert.assertEquals(true, obj_signIn.verifyLoginSuccessful("er.aartikulkarni@gmail.com"));
	     
		 HotelBookingTest obj_hotelTest = new HotelBookingTest(driver);
		 
		 obj_hotelTest.searchHotels("Mumbai","December","15","December","16");
		 
		 Assert.assertEquals(true, obj_hotelTest.header_hotelSearch.isDisplayed());
		 Assert.assertEquals(true, obj_hotelTest.results_hotelSearch.isDisplayed());
         
}
}