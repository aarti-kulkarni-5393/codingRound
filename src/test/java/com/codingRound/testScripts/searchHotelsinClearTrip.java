package com.codingRound.testScripts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.codinground.pageObjects.clearTripPage.HotelBookingTest;
import com.codinground.pageObjects.clearTripPage.SignInTest;
import com.codinground.testBase.TestBase;

public class searchHotelsinClearTrip extends TestBase  {
    WebDriver driver;
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
		
		HotelBookingTest obj_hotel = new HotelBookingTest(driver);
		obj_hotel.searchHotels("Mumbai");
	}

}
