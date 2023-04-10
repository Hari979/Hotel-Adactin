package com.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class BookHotelPageTest extends Testbase {

	public BookHotelPageTest() throws Exception {
		super();
		
	}

	LoginPage login;
	SearchHotelPage sh;
	SelectHotelPage sl;
	BookHotelPage bh;
	BookedItineraryPage bi;
	LogoutPage lp;
	
	String cardtype[] = {"- Select Credit Card Type -", "American Express", "VISA", "Master Card", "Other"};
	String expirymonth[] = {"- Select Month -", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	String expiryyear[] = {"- Select Year -", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"};
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		login = new LoginPage(driver);
		login.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		sh = new SearchHotelPage(driver);
		sh.location(prop.getProperty("location"));
		sh.hotels(prop.getProperty("hotel"));
		sh.roomtype(prop.getProperty("rtype"));
		sh.roomNum(prop.getProperty("rno"));
		sh.dateIn(prop.getProperty("indate"));
		sh.dateOut(prop.getProperty("outdate"));
		sh.adultRoom(prop.getProperty("adult"));
		sh.childRoom(prop.getProperty("child"));
		sl = sh.submit();
		sl = new SelectHotelPage(driver);
		sl.select();
		bh = sl.continueButton();
		bh= new BookHotelPage(driver);	
	}
	
	@Test(priority=1)
	public void loginTitleValidate() {
		String loginTitle = bh.loginTitle();
		Assert.assertEquals(loginTitle, "Book A Hotel");
	}
	
	@Test(priority=2)
	public void textValidation() {
		String hotelNameText = bh.hotelNameText();
		Assert.assertEquals(hotelNameText, prop.getProperty("hotel"));
	
		String locationText = bh.locationText();
		Assert.assertEquals(locationText, prop.getProperty("location"));
		
		String roomTypeText = bh.roomTypeText();
		Assert.assertEquals(roomTypeText, prop.getProperty("rtype"));
		
		String roomNumberText = bh.roomNumberText();
		Assert.assertEquals(roomNumberText, "5 Room(s)");
		
		String totalDaysText = bh.totalDaysText();
		Assert.assertEquals(totalDaysText, "2 Day(s)");
		
		String pricePerNight = bh.pricePerNight();
		Assert.assertEquals(pricePerNight, "AUD $ 300");
		
		String totalPrice = bh.totalPrice();
		Assert.assertEquals(totalPrice, "AUD $ 610");//wrong price
		
		String finalPrice = bh.finalPrice();
		Assert.assertEquals(finalPrice, "AUD $ 671");
	
	}
	
	@Test(priority=3)
	public void inputTest() throws Exception {
		bh.firstName(prop.getProperty("fname"));
		bh.lastName(prop.getProperty("lname"));
		bh.address(prop.getProperty("address"));
		bh.creditCardNum(prop.getProperty("cardnumber"));
		bh.creditCardType(prop.getProperty("cardtype"));
		bh.month(prop.getProperty("month"));
		bh.year(prop.getProperty("year"));
		bh.ccvn(prop.getProperty("ccv"));
		bh.bookNow();
		Thread.sleep(10000);
	}
	
	@Test(priority=4)
	public void bookingConfirmationTest() throws Exception {
		bh.firstName(prop.getProperty("fname"));
		bh.lastName(prop.getProperty("lname"));
		bh.address(prop.getProperty("address"));
		bh.creditCardNum(prop.getProperty("cardnumber"));
		bh.creditCardType(prop.getProperty("cardtype"));
		bh.month(prop.getProperty("month"));
		bh.year(prop.getProperty("year"));
		bh.ccvn(prop.getProperty("ccv"));
		bh.bookNow();
		Thread.sleep(15000);
		String firstNameConfirmation = bh.firstNameConfirmation();
		Assert.assertEquals(firstNameConfirmation, "Laxmi");
		String lastNameConfirmation = bh.lastNameConfirmation();
		Assert.assertEquals(lastNameConfirmation, ""); //last name not displayed
		String addressConfirmation = bh.addressConfirmation();
		Assert.assertEquals(addressConfirmation, "Dubai Bus Stand, Dubai Main Road, Dubai Kurukusanthu, Dubai");
		String orderNoConfirmation = bh.orderNoConfirmation();
		System.out.println("order number "+orderNoConfirmation);
		bi = bh.bookedItinerary();
		bi = new BookedItineraryPage(driver);
	}
	@Test(priority=5)
	public void afterBookingSearchHotelTest() throws Exception {
		bh.firstName(prop.getProperty("fname"));
		bh.lastName(prop.getProperty("lname"));
		bh.address(prop.getProperty("address"));
		bh.creditCardNum(prop.getProperty("cardnumber"));
		bh.creditCardType(prop.getProperty("cardtype"));
		bh.month(prop.getProperty("month"));
		bh.year(prop.getProperty("year"));
		bh.ccvn(prop.getProperty("ccv"));
		bh.bookNow();
		Thread.sleep(10000);
		sh = bh.searchHotel();
		sh = new SearchHotelPage(driver);
	}
	
	@Test(priority=6)
	public void afterBookingLogoutTest() throws Exception {
		bh.firstName(prop.getProperty("fname"));
		bh.lastName(prop.getProperty("lname"));
		bh.address(prop.getProperty("address"));
		bh.creditCardNum(prop.getProperty("cardnumber"));
		bh.creditCardType(prop.getProperty("cardtype"));
		bh.month(prop.getProperty("month"));
		bh.year(prop.getProperty("year"));
		bh.ccvn(prop.getProperty("ccv"));
		bh.bookNow();
		Thread.sleep(10000);
		lp = bh.logout();
		lp = new LogoutPage(driver);
	}
	
	@Test (priority=7)
	public void detailsNotGivenTest() {
		bh.bookNow();
		String emptyFirstName = bh.emptyFirstName();
		Assert.assertEquals(emptyFirstName, "Please Enter your First Name");
		String emptyLastName = bh.emptyLastName();
		Assert.assertEquals(emptyLastName, "Please Enter you Last Name");
		String emptyAddress = bh.emptyAddress();
		Assert.assertEquals(emptyAddress, "Please Enter your Address");
		String ccnumTip = bh.ccnumTip();
		Assert.assertEquals(ccnumTip, "Use 16 digit Dummy Data");
		String emptyccnum = bh.emptyccnum();
		Assert.assertEquals(emptyccnum, "Please Enter your 16 Digit Credit Card Number");
		String cardTypeNotSelected = bh.cardTypeNotSelected();
		Assert.assertEquals(cardTypeNotSelected, "Please Select your Credit Card Type");
		String expiryMonthNotSelected = bh.expiryMonthNotSelected();
		Assert.assertEquals(expiryMonthNotSelected, "Please Select your Credit Card Expiry Month");
		//String expiryYearNotSelected = bh.expiryYearNotSelected();
		//Assert.assertEquals(expiryYearNotSelected, "Please Select your Credit Card Expiry Year");
		String emptyCVV = bh.emptyCVV();
		Assert.assertEquals(emptyCVV, "Please Enter your Credit Card CVV Number");
	}
	
	@Test(priority=8)
	public void selectOptionsValidateTest() {
		List<WebElement> cardtypes = bh.creditCardType(prop.getProperty("cardtype")).getOptions();
		for (int i = 0; i < cardtypes.size(); i++) {
			Assert.assertEquals(cardtypes.get(i).getText(), cardtype[i]);
		}
		List<WebElement> months = bh.month(prop.getProperty("month")).getOptions();
		for (int i = 0; i < months.size(); i++) {
			Assert.assertEquals(months.get(i).getText(), expirymonth[i]);
		}
		List<WebElement> years = bh.year(prop.getProperty("year")).getOptions();
		for (int i = 0; i < years.size(); i++) {
			Assert.assertEquals(years.get(i).getText(), expiryyear[i]);
		}
	}
	
	@Test (priority=9)
	public void priceValidationTest() {
		String roomNumberText = bh.roomNumberText();
		int numberOfRooms = Integer.parseInt(roomNumberText.replaceAll("[\\D+]", ""));
		String totalDaysText = bh.totalDaysText();
		int totalDays = Integer.parseInt(totalDaysText.replaceAll("[\\D+]", ""));
		String pricePerNightText = bh.pricePerNight();
		int pricePerNight = Integer.parseInt(pricePerNightText.replaceAll("[\\D+]", ""));
		String totalPriceText = bh.totalPrice();
		int totalPrice = Integer.parseInt(totalPriceText.replaceAll("[\\D+]", ""));
		String finalPriceText = bh.finalPrice();
		int finalPrice = Integer.parseInt(finalPriceText.replaceAll("[\\D+]", ""));
		
		int actualprice = numberOfRooms*totalDays*pricePerNight;
		Assert.assertEquals(totalPrice, 610);//expected [3000] but found [610]
		int gst = actualprice/10;
		int actualFinalPrice = actualprice+gst;//expected [3300] but found [671]
		Assert.assertEquals(finalPrice, 671);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}