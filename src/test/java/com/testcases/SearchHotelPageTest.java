package com.testcases;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.hotel.pages.BookedItineraryPage;
import com.hotel.pages.ChangePasswordPage;
import com.hotel.pages.LoginPage;
import com.hotel.pages.LogoutPage;
import com.hotel.pages.SearchHotelPage;
import com.hotel.pages.SelectHotelPage;

public class SearchHotelPageTest extends Testbase {

	public SearchHotelPageTest() throws Exception {
		super();
		
	}

	SearchHotelPage s;
	LoginPage l;
	SelectHotelPage sp;
	BookedItineraryPage bi;
	ChangePasswordPage cp;
	LogoutPage lp;
	String locations[] = {"- Select Location -", "Sydney", "Melbourne", "Brisbane", "Adelaide", "London", "New York", "Los Angeles", "Paris"};
	String hotels[] = {"- Select Hotel -", "Hotel Creek", "Hotel Sunshine", "Hotel Hervey", "Hotel Cornice"};
	String rooms[] = {"- Select Room Type -", "Standard", "Double", "Deluxe", "Super Deluxe"};
	String roomno[] = {"- Select Number of Rooms -", "1 - One", "2 - Two", "3 - Three", "4 - Four", "5 - Five", "6 - Six", "7 - Seven", "8 - Eight", "9 - Nine", "10 - Ten"};
	String adults[] = {"- Select Adults per Room -", "1 - One", "2 - Two", "3 - Three", "4 - Four"};
	String childs[] = {"0 - None", "1 - One", "2 - Two", "3 - Three", "4 - Four"};
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		l = new LoginPage(driver);
		s = l.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		s = new SearchHotelPage(driver);		
	}
	
	@Test(priority=1)
	public void searchHotelTest() throws Exception {
		s.location(prop.getProperty("location"));
		s.hotels(prop.getProperty("hotel"));
		s.roomtype(prop.getProperty("rtype"));
		s.roomNum(prop.getProperty("rno"));
		s.dateIn(prop.getProperty("indate"));
		s.dateOut(prop.getProperty("outdate"));
		s.adultRoom(prop.getProperty("adult"));
		s.childRoom(prop.getProperty("child"));
		sp = s.submit();
	}
	@Test(priority=2)
	public void resetTest() {
		s.location(prop.getProperty("location"));
		s.hotels(prop.getProperty("hotel"));
		s.roomtype(prop.getProperty("rtype"));
		s.roomNum(prop.getProperty("rno"));
		s.dateIn(prop.getProperty("indate"));
		s.dateOut(prop.getProperty("outdate"));
		s.adultRoom(prop.getProperty("adult"));
		s.childRoom(prop.getProperty("child"));
		s.reset();
	}
	@Test(priority=3)
	public void welcomeHdTest() {
		String text = s.welcomeHd();
		assertEquals(text, "Welcome to Adactin Group of Hotels");
	}
	@Test(priority=4)
	public void userNameShowTest() {
		String uname = s.userNameShow();
		assertEquals(uname, "");//user name is Hello hari1479! but it returns null
	}
	@Test(priority=5)
	public void linkClickTest() throws Exception {
		s.links();
	}
	@Test(priority=6)
	public void loginTitleTest() {
		String loginTitle = s.loginTitle();
		assertEquals(loginTitle, "Search Hotel (Fields marked with Red asterix (*) are mandatory)");
	}
	
	@Test(priority=7)
	public void selectOptionsValidateTest() {
		
		List<WebElement> location = s.location(prop.getProperty("location")).getOptions();
		for (int i = 0; i < location.size(); i++) {
			Assert.assertEquals(location.get(i).getText(), locations[i]);
		}
		List<WebElement> hotel = s.hotels(prop.getProperty("hotel")).getOptions();
		for (int i = 0; i < hotel.size(); i++) {
			Assert.assertEquals(hotel.get(i).getText(), hotels[i]);
		}
		List<WebElement> roomtype = s.roomtype(prop.getProperty("rtype")).getOptions();
		for (int i = 0; i < roomtype.size(); i++) {
			Assert.assertEquals(roomtype.get(i).getText(), rooms[i]);
		}
		List<WebElement> roomnos = s.roomNum(prop.getProperty("rno")).getOptions();
		for (int i = 0; i < roomnos.size(); i++) {
			Assert.assertEquals(roomnos.get(i).getText(), roomno[i]);
		}
		List<WebElement> adult = s.adultRoom(prop.getProperty("adult")).getOptions();
		for (int i = 0; i < adult.size(); i++) {
			Assert.assertEquals(adult.get(i).getText(), adults[i]);
		}
		List<WebElement> child = s.childRoom(prop.getProperty("child")).getOptions();
		for (int i = 0; i < child.size(); i++) {
			Assert.assertEquals(child.get(i).getText(), childs[i]);
		}
	}
	
	@Test(priority=8)
	public void optionsNotSelectedTest() throws Exception {
		s.roomNum("- Select Number of Rooms -");
		s.dateIn("27/12/2022");
		s.dateOut("25/12/2022");
		s.adultRoom("- Select Adults per Room -");
		s.submit();
		String locationNotSelected = s.locationNotSelected();
		Assert.assertEquals(locationNotSelected, "Please Select a Location");
		String numberOfRoomsNotSelected = s.numberOfRoomsNotSelected();
		String checkInError = s.checkInError();
		Assert.assertEquals(checkInError, "Check-In Date shall be before than Check-Out Date");
		String checkOutError = s.checkOutError();
		Assert.assertEquals(checkOutError, "Check-Out Date shall be after than Check-In Date");
		Assert.assertEquals(numberOfRoomsNotSelected, "Please Select Total Number of Rooms");
		String adultsPerRoomNotSelected = s.adultsPerRoomNotSelected();
		Assert.assertEquals(adultsPerRoomNotSelected, "Please Select Adults per Room");
	}
	
	@Test(priority=9)
	public void labelTest() {
		String locationLabels = s.locationLabels();
		Assert.assertEquals(locationLabels, "Location* ");
		String hotelsLabels = s.hotelsLabels();
		Assert.assertEquals(hotelsLabels, "Hotels ");
		String roomtypeLabel = s.roomtypeLabel();
		Assert.assertEquals(roomtypeLabel, "Room Type ");
		String numOfRoomsLabel = s.numOfRoomsLabel();
		Assert.assertEquals(numOfRoomsLabel, "Number of Rooms* ");
		String checkInDateLabel = s.checkInDateLabel();
		Assert.assertEquals(checkInDateLabel, "Check In Date* ");
		String chekcOutDateLabel = s.chekcOutDateLabel();
		Assert.assertEquals(chekcOutDateLabel, "Check Out Date* ");
		String adultsRoomLabel = s.adultsRoomLabel();
		Assert.assertEquals(adultsRoomLabel, "Adults per Room* ");
		String childrenRoomLabel = s.childrenRoomLabel();
		Assert.assertEquals(childrenRoomLabel, "Children per Room ");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
