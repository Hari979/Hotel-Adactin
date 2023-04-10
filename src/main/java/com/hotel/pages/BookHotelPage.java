package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.Testbase;

public class BookHotelPage extends Testbase {

	public BookHotelPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//form //td[@colspan='2'])[2]")
	WebElement loginTitle;
	
	@FindBy(xpath = "//a[text()='Back']")
	WebElement back;
	
	@FindBy(xpath="(//tbody)[2]/tr/td[1]")
	WebElement welcomeText;
	
	@FindBy(xpath="(//tbody)[2]/tr/td[2]")
	WebElement welcomeMenuText;
	
	@FindBy(id = "hotel_name_dis")
	WebElement hotelName;
	
	@FindBy(id = "location_dis")
	WebElement locationName;
	
	@FindBy(id = "room_type_dis")
	WebElement roomType;
	
	@FindBy(id = "room_num_dis")
	WebElement roomNumber;

	@FindBy(id = "total_days_dis")
	WebElement totalDays;
	
	@FindBy(name = "price_night_dis")
	WebElement pricePerNight;
	
	@FindBy(name = "total_price_dis")
	WebElement totalPrice;
	
	@FindBy(name = "gst_dis")
	WebElement gst;
	
	@FindBy(id = "final_price_dis")
	WebElement finalPrice;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "last_name")
	WebElement lastName;
	
	@FindBy(id = "address")
	WebElement address;
	
	@FindBy(id = "cc_num")
	WebElement creditCardNum;
	
	@FindBy(id = "cc_type")
	WebElement creditCardType;
	
	@FindBy(id = "cc_exp_month")
	WebElement month;
	
	@FindBy(id = "cc_exp_year")
	WebElement year;
	
	@FindBy(id = "cc_cvv")
	WebElement ccv;
	
	@FindBy(id = "book_now")
	WebElement bookNow;
	
	@FindBy(id = "cancel")
	WebElement cancel;
	
	@FindBy(id = "cc_num_tip")
	WebElement numTipLabel;
	
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressText;
	
	@FindBy(id = "order_no")
	WebElement orderNo;
	
	@FindBy(id = "search_hotel")
	WebElement searchHotel;
	
	@FindBy (id = "my_itinerary")
	WebElement bookedItinerary;
	
	@FindBy (id = "logout")
	WebElement logout;
	
	@FindBy(id="first_name_span")
	WebElement emptyFname;
	
	@FindBy(id="last_name_span")
	WebElement emptyLname;
	
	@FindBy(id="address_span")
	WebElement emptyAddress;
	
	@FindBy(id="cc_num_tip")
	WebElement ccnumtip;
	
	@FindBy(id="cc_num_span")
	WebElement emptyccnum;
	
	@FindBy(id="cc_type_span")
	WebElement cardTypeNotSelected;
	
	@FindBy(id="cc_expiry_span")
	WebElement expiryMonthNotSelected;
	
	@FindBy(id="cc_expiry_span")
	WebElement expiryYearNotSelected;
	
	@FindBy(id="cc_cvv_span")
	WebElement emptyCVV;
	
	@FindBy(id="cancel")
	WebElement cancelButton;
	
	
	public String welcomeMenuText() {
		return welcomeMenuText.getText();
	}
	
	public SelectHotelPage back() throws Exception {
		back.click();
		return new SelectHotelPage(driver);
	}
	
	public String welcomeText() {
		return welcomeText.getText();
	}
	
	public String loginTitle() {
		return loginTitle.getText();
	}
	
	public String hotelNameText() {
		return hotelName.getAttribute("value");
	}

	public String locationText() {
		return locationName.getAttribute("value");
	}
	
	public String roomTypeText() {
		return roomType.getAttribute("value");
	}
	
	public String roomNumberText() {
		return roomNumber.getAttribute("value");
	}
	
	public String totalDaysText() {
		return totalDays.getAttribute("value");
	}
	
	public String pricePerNight() {
		return pricePerNight.getAttribute("value");
	}
	
	public String totalPrice() {
		return totalPrice.getAttribute("value");
	}
	
	public String gst() {
		return gst.getAttribute("value");
	}
	
	public String finalPrice() {
		return finalPrice.getAttribute("value");
	}
	
	public String firstName(String fname) {
		firstName.sendKeys(fname);
		return fname;
	}
	
	public String lastName(String lname) {
		lastName.sendKeys(lname);
		return lname;
	}
	
	public String address(String addss) {
		address.sendKeys(addss);
		return addss;
	}
	
	public String creditCardNum(String ccno) {
		creditCardNum.sendKeys(ccno);
		return ccno;
	}
	
	public Select creditCardType(String cardtype) {
		Select cct = new Select(creditCardType);
		cct.selectByVisibleText(cardtype);
		return cct;
	}
	
	public Select month (String m) {
		Select mn = new Select(month);
		mn.selectByVisibleText(m);
		return mn;
	}
	
	public Select year(String y) {
		Select yr = new Select(year);
		yr.selectByVisibleText(y);
		return yr;
	}
	
	public String ccvn(String ccvn) {
		ccv.sendKeys(ccvn);
		return ccvn;
	}
	
	public void bookNow() {
		bookNow.click();
	}
	
	public String firstNameConfirmation() {
		return firstName.getAttribute("value");
	}
	
	public String lastNameConfirmation() {
		return lastName.getAttribute("value");
	}
	
	public String addressConfirmation() {
		return addressText.getText();
	}
	
	public String orderNoConfirmation() {
		return orderNo.getAttribute("value");
	}
	
	public SearchHotelPage searchHotel() throws Exception {
		searchHotel.click();
		return new SearchHotelPage(driver);
	}
	
	public BookedItineraryPage bookedItinerary() throws Exception {
		bookedItinerary.click();
		return new BookedItineraryPage(driver);
	}
	
	public LogoutPage logout() throws Exception {
		logout.click();
		return new LogoutPage(driver);
	}
	
	public String emptyFirstName() {
		return emptyFname.getText();
	}
	
	public String emptyLastName() {
		return emptyLname.getText();
	}
	
	public String emptyAddress() {
		return emptyAddress.getText();
	}
	
	public String ccnumTip() {
		return ccnumtip.getText();
	}
	
	public String emptyccnum() {
		return emptyccnum.getText();
	}
	
	public String cardTypeNotSelected() {
		return cardTypeNotSelected.getText();
	}
	
	public String expiryMonthNotSelected() {
		return expiryMonthNotSelected.getText();
	}
	
	public String expiryYearNotSelected() {
		return expiryYearNotSelected.getText();
	}
	
	public String emptyCVV() {
		return emptyCVV.getText();
	}
	
	public void bookHotel() throws Exception {
		BookHotelPage bh = new BookHotelPage(driver);
		bh.firstName(prop.getProperty("fname"));
		bh.lastName(prop.getProperty("lname"));
		bh.address(prop.getProperty("address"));
		bh.creditCardNum(prop.getProperty("cardnumber"));
		bh.creditCardType(prop.getProperty("cardtype"));
		bh.month(prop.getProperty("month"));
		bh.year(prop.getProperty("year"));
		bh.ccvn(prop.getProperty("ccv"));
		bh.bookNow();
	}
}
