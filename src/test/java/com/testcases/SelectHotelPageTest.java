package com.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.hotel.pages.BookHotelPage;
import com.hotel.pages.LoginPage;
import com.hotel.pages.SearchHotelPage;
import com.hotel.pages.SelectHotelPage;

public class SelectHotelPageTest extends Testbase {

	public SelectHotelPageTest() throws Exception {
		super();
	}

	SearchHotelPage shp;
	BookHotelPage bhp;
	SelectHotelPage sep;
	LoginPage l;
	
	@BeforeMethod
	public void setup() throws Exception {
		
		initialization();
		l = new LoginPage(driver);
		l.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		shp = new SearchHotelPage(driver);
		shp.location(prop.getProperty("location"));
		shp.hotels(prop.getProperty("hotel"));
		shp.roomtype(prop.getProperty("rtype"));
		shp.roomNum(prop.getProperty("rno"));
		shp.dateIn(prop.getProperty("indate"));
		shp.dateOut(prop.getProperty("outdate"));
		shp.adultRoom(prop.getProperty("adult"));
		shp.childRoom(prop.getProperty("child"));
		sep = shp.submit();
		sep = new SelectHotelPage(driver);
	}
	@Test(priority=1)
	public void loginTitleTest() {
		String loginTitle = sep.loginTitle();
		assertEquals(loginTitle, "Select Hotel");

	}
	
	@Test(priority=2)
	public void textShowTest() {
		String userNameShow = sep.userNameShow();
		Assert.assertEquals(userNameShow, "Hello Username! Search Hotel | Booked Itinerary | Change Password | Logout"); //shows hello username instead of hello hari1479
	}
	
	@Test(priority=3)
	public void selectTest() {
		sep.select();
	}
	
	@Test(priority=4)
	public void continueButtonTest() throws Exception {
		sep.select();
		bhp = sep.continueButton();
	}
	
	@Test(priority=5)
	public void cancelTest() throws Exception {
		shp = sep.cancel();
	}
	
	@Test(priority=6)
	public void hotelNotSelectedTest() throws Exception {
		bhp = sep.continueButton();
		String hotelNotSelected = sep.hotelNotSelected();
		Assert.assertEquals(hotelNotSelected, "Please Select a Hotel");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
