package com.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.hotel.pages.BookHotelPage;
import com.hotel.pages.BookedItineraryPage;
import com.hotel.pages.LoginPage;
import com.hotel.pages.LogoutPage;
import com.hotel.pages.SearchHotelPage;
import com.hotel.pages.SelectHotelPage;

public class BookedItineraryPageTest extends Testbase {

	public BookedItineraryPageTest() throws Exception {
		super();
	}
	
	LoginPage login;
	SearchHotelPage sh;
	SelectHotelPage sl;
	BookHotelPage bh;
	BookedItineraryPage bi;
	LogoutPage lp;
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		login = new LoginPage(driver);
		login.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		sh = new SearchHotelPage(driver);
	}
	
	@Test (priority=1)
	public void loginTitleText() throws Exception {
		bi = sh.bookedItinerary();
		bi = new BookedItineraryPage(driver);
		String loginTitle = bi.loginTitle();
		Assert.assertEquals(loginTitle, "Booked Itinerary");
	}
	
	@Test (priority=2)
	public void bookedItineraryTest() throws Exception {
		sh.searchHotelInputs();
		sl = new SelectHotelPage(driver);
		sl.select();
		bh = sl.continueButton();
		bh= new BookHotelPage(driver);
		bh.bookHotel();
		Thread.sleep(15000);
		String orderNoConfirmation = bh.orderNoConfirmation();
		prop.setProperty("orderNo", orderNoConfirmation);
		bi = bh.bookedItinerary();
		bi = new BookedItineraryPage(driver);
		bi.searchOrderId(prop.getProperty("orderNo"));
		bi.searchHotelIdButton();
		Thread.sleep(10000);
		String orderId = bi.orderId();
		Assert.assertEquals(orderId, orderId);
		String hotelName = bi.hotelName();
		Assert.assertEquals(hotelName, prop.getProperty("hotel"));
		String location = bi.location();
		Assert.assertEquals(location, prop.getProperty("location"));
		String rooms = bi.rooms();
		Assert.assertEquals(rooms, "5 Rooms");
		String firstName = bi.firstName();
		Assert.assertEquals(firstName, prop.getProperty("fname"));
		String lastName = bi.lastName();
		Assert.assertEquals(lastName, prop.getProperty("lname"));
		String arrivalDate = bi.arrivalDate();
		Assert.assertEquals(arrivalDate, prop.getProperty("indate"));
		String depatureDate = bi.depatureDate();
		Assert.assertEquals(depatureDate, prop.getProperty("outdate"));
		String noOfDays = bi.noOfDays();
		Assert.assertEquals(noOfDays, prop.getProperty("numofdays"));
		String pricePerNight = bi.pricePerNight();
		Assert.assertEquals(pricePerNight, "AUD $ 300");
		String totalPricePerNight = bi.TotalPricePerNight();
		Assert.assertEquals(totalPricePerNight, "AUD $ 671");
	}
	
	@Test (priority=3)
	public void cancelbookingTest() throws Exception {
		sh.searchHotelInputs();
		sl = new SelectHotelPage(driver);
		sl.select();
		bh = sl.continueButton();
		bh= new BookHotelPage(driver);
		bh.bookHotel();
		Thread.sleep(15000);
		String orderNoConfirmation = bh.orderNoConfirmation();
		prop.setProperty("orderNo", orderNoConfirmation);
		bi = bh.bookedItinerary();
		bi = new BookedItineraryPage(driver);
		bi.searchOrderId(prop.getProperty("orderNo"));
		bi.searchHotelIdButton();
		Thread.sleep(10000);
		bi.cancelButton();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		String alertmsg = "Are you sure want to Cancel Selected?.";
		Assert.assertEquals(alerttext, alertmsg);
		alert.accept();//error msg not showed while we dont select any order.
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}
	
}
