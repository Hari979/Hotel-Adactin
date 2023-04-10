package com.hotel.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class BookedItineraryPage extends Testbase {

	public BookedItineraryPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".welcome_menu")
	WebElement welcomeText;
	
	@FindBy (id = "username_show")
	WebElement usernameShow;
	
	@FindBy (css = ".login_title")
	WebElement loginTitle;
	
	@FindBy (id = "order_id_text")
	WebElement orderIdText;
	
	@FindBy (id = "search_hotel_id")
	WebElement searchHotelId;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	WebElement selectOrderId;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[2]/input")
	WebElement orderId;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[4]/input")
	WebElement hotelName;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[5]/input")
	WebElement location;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[6]/input")
	WebElement rooms;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[7]/input")
	WebElement firstName;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[8]/input")
	WebElement lastName;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[9]/input")
	WebElement arrivalDate;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[10]/input")
	WebElement depatureDate;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[11]/input")
	WebElement noOfDays;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[12]/input")
	WebElement roomType;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[13]/input")
	WebElement pricePerNight;
	
	@FindBy (xpath = "(((//table)[5]/tbody/tr)[2]/td)[14]/input")
	WebElement TotalPricePerNight;
	
	@FindBy (name = "cancelall")
	WebElement cancel;
	
	public String loginTitle() {
		return loginTitle.getText();
	}
	
	public String usernameShow() {
		return usernameShow.getText();
	}
	
	public String searchOrderId(String order) {
		orderIdText.sendKeys(order);
		return order;
	}
	
	public void searchHotelIdButton() {
		searchHotelId.click();
	}
	
	public String orderId() {
		return orderId.getAttribute("value");
	}
	
	public String hotelName() {
		return hotelName.getAttribute("value");
	}
	
	public String location() {
		return location.getAttribute("value");
	}
	
	public String rooms() {
		return rooms.getAttribute("value");
	}
	
	public String firstName() {
		return firstName.getAttribute("value");
	}
	
	public String lastName() {
		return lastName.getAttribute("value");
	}
	
	public String arrivalDate() {
		return arrivalDate.getAttribute("value");
	}
	
	public String depatureDate() {
		return depatureDate.getAttribute("value");
	}
	
	public String noOfDays() {
		return noOfDays.getAttribute("value");
	}
	
	public String roomType() {
		return roomType.getAttribute("value");
	}
	
	public String pricePerNight() {
		return pricePerNight.getAttribute("value");
	}
	
	public String TotalPricePerNight() {
		return TotalPricePerNight.getAttribute("value");
	}
	
	public void cancelButton() {
		cancel.click();
	}

}
