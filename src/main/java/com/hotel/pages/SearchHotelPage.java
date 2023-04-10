package com.hotel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Testbase;

public class SearchHotelPage extends Testbase {
	
	public SearchHotelPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(id="location")
	WebElement location;
	
	@FindBy(id="hotels")
	WebElement hotels;
	
	@FindBy(id="room_type")
	WebElement roomType;
	
	@FindBy(id="room_nos")
	WebElement roomNos;
	
	@FindBy(id="datepick_in")
	WebElement datein;
	
	@FindBy(id="datepick_out")
	WebElement dateout;
	
	@FindBy(id="adult_room")
	WebElement adultRoom;
	
	@FindBy(id="child_room")
	WebElement childRoom;
	
	@FindBy(id="Submit")
	WebElement submit;
	
	@FindBy(id="Reset")
	WebElement reset;
	
	@FindBy(xpath="//td[contains(text(),'Welcome to Adactin')]")
	WebElement welcomehd;

	@FindBy(id="username_show")
	WebElement userNameShow;
	
	@FindBy(xpath="//a[text()='Search Hotel']")
	WebElement searchHotel;
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	WebElement bookedItinerary;
	
	@FindBy(xpath="//a[text()='Change Password']")
	WebElement changePassword;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(css=".login_title")
	WebElement loginTitle;
	
	@FindBy(id = "location_span")
	WebElement locationNotSelected;
	
	@FindBy(id="num_room_span")
	WebElement numberOfRoomsNotSelected;
	
	@FindBy(id="adults_room_span")
	WebElement adultsPerRoomNotSelected;
	
	@FindBy(id="checkin_span")
	WebElement checkinerror;
	
	@FindBy (id = "checkout_span")
	WebElement checkouterror;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[2]")
	WebElement locationLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[4]")
	WebElement hotelLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[6]")
	WebElement roomtypeLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[8]")
	WebElement numroomsLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[10]")
	WebElement checkInLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[12]")
	WebElement checkOutLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[14]")
	WebElement adultsPerLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[16]")
	WebElement childrenPerLabel;
	
	public Select location(String locations) {
		Select  loc = new Select(location);
		loc.selectByVisibleText(locations);
		return loc;
	}
	
	public Select hotels(String hotel) {
		Select ho = new Select(hotels);
		ho.selectByVisibleText(hotel);
		return ho;
	}
	
	public Select roomtype(String rtype) {
		Select rt = new Select(roomType);
		rt.selectByVisibleText(rtype);
		return rt;
		
	}
	
	public Select roomNum(String rnum) {
		Select rn = new Select(roomNos);
		rn.selectByVisibleText(rnum);
		return rn;		
	}
	public String dateIn(String din) {
		datein.clear();
		datein.sendKeys(din);
		return din;		
	}
	
	public String dateOut(String dout) {
		dateout.clear();
		dateout.sendKeys(dout);
		return dout;
	}
	
	public Select adultRoom(String aroom) {
		Select ar = new Select(adultRoom);
		ar.selectByVisibleText(aroom);
		return ar;
	}
	
	public Select childRoom(String croom) {
		Select cr = new Select(childRoom);
		cr.selectByVisibleText(croom);
		return cr;
	}
	
	public SelectHotelPage submit() throws Exception {
		submit.click();
		return new SelectHotelPage(driver);
	}
	
	public void reset() {
		reset.click();
	
	}
	
	public String welcomeHd() {
		return welcomehd.getText();
	}
	
	public String userNameShow() {
		return userNameShow.getText();
		
	}
	
	public void searchHotel() {
		searchHotel.click();
	}
	
	public BookedItineraryPage bookedItinerary() throws Exception {
		bookedItinerary.click();
		return new BookedItineraryPage(driver);
	}
	
	public ChangePasswordPage changePassword() throws Exception {
		changePassword.click();
		return new ChangePasswordPage(driver);
	}
	
	public LogoutPage logout() throws Exception {
		logout.click();
		return new LogoutPage(driver);
	}
	
	public void links() throws InterruptedException {
		WebElement links = driver.findElement(By.xpath("//table[2]/tbody/tr/td/a"));
		for(int i =0; i < links.findElements(By.xpath("//table[2]/tbody/tr/td/a")).size(); i++) {
			String clickOnLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			links.findElements(By.xpath("//table[2]/tbody/tr/td/a")).get(i).sendKeys(clickOnLinks);
			Thread.sleep(3000);
		}
	}

	public String loginTitle() {
		return loginTitle.getText();
	}
	
	public String locationNotSelected() {
		return locationNotSelected.getText();
	}
	
	public String numberOfRoomsNotSelected() {
		return numberOfRoomsNotSelected.getText();
	}
	
	public String adultsPerRoomNotSelected() {
		return adultsPerRoomNotSelected.getText();
	}
	
	public String checkInError() {
		return checkinerror.getText();
	}
	
	public String checkOutError() {
		return checkouterror.getText();
	}
	
	public String locationLabels() {
		return locationLabel.getText();
	}
	
	public String hotelsLabels() {
		return hotelLabel.getText();
	}
	
	public String roomtypeLabel() {
		return roomtypeLabel.getText();
	}
	
	public String numOfRoomsLabel() {
		return numroomsLabel.getText();
	}
	
	public String checkInDateLabel() {
		return checkInLabel.getText();
	}
	
	public String chekcOutDateLabel() {
		return checkOutLabel.getText();
	}
	
	public String adultsRoomLabel() {
		return adultsPerLabel.getText();
	}
	
	public String childrenRoomLabel() {
		return childrenPerLabel.getText();
	}
	
	public SelectHotelPage searchHotelInputs() throws Exception{
		SearchHotelPage s = new SearchHotelPage(driver);
		SelectHotelPage sp;
		s.location(prop.getProperty("location"));
		s.hotels(prop.getProperty("hotel"));
		s.roomtype(prop.getProperty("rtype"));
		s.roomNum(prop.getProperty("rno"));
		s.dateIn(prop.getProperty("indate"));
		s.dateOut(prop.getProperty("outdate"));
		s.adultRoom(prop.getProperty("adult"));
		s.childRoom(prop.getProperty("child"));
		return sp = s.submit();
	}
}
