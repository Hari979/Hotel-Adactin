package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class ChangePasswordPage extends Testbase {

	public ChangePasswordPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username_show")
	WebElement usernameShow;
	
	@FindBy(css=".welcome_menu")
	WebElement welcomeText;
	
	@FindBy(xpath="((//tbody/tr)[3]/td/a)[1]")
	WebElement searchHotel;
	
	@FindBy(xpath="((//tbody/tr)[3]/td/a)[2]")
	WebElement bookedItinerary;
	
	@FindBy(xpath="((//tbody/tr)[3]/td/a)[3]")
	WebElement changePassword;
	
	@FindBy(xpath="((//tbody/tr)[3]/td/a)[4]")
	WebElement logout;
	
	@FindBy(css=".login_title")
	WebElement loginTitle;
	
	@FindBy(css=".login_title_comm")
	WebElement mandText;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[7]")
	WebElement currentPasswordLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[9]")
	WebElement newPasswordLabel;
	
	@FindBy(xpath="(//form/table/tbody/tr/td)[11]")
	WebElement confirmPasswordLabel;
	
	@FindBy(id="current_pass")
	WebElement currentPass;
	
	@FindBy(id="new_password")
	WebElement newPassword;
	
	@FindBy(id="re_password")
	WebElement confirmPassword;
	
	@FindBy(id="Submit")
	WebElement submit;
	
	@FindBy(xpath="(//form//preceding::table/tbody/tr/td)[1]")
	WebElement adactinLogo;
	
	@FindBy(xpath="(//form//preceding::table/tbody/tr/td)[2]")
	WebElement reservationImg;
	
	@FindBy(xpath="//a[text()='Change Password']")
	WebElement changepwd;
	
	@FindBy(xpath="(//span[@class='reg_error'])[1]")
	WebElement emptyErrorText;
	
	
	public String currentPasswordLabel() {
		return currentPasswordLabel.getText();
	}
	
	public String newPasswordLabel() {
		return newPasswordLabel.getText();
	}
	
	public String confirmPasswordLabel() {
		return confirmPasswordLabel.getText();
	}
	
	public String currentpwd(String p) {
		currentPass.sendKeys(p);
		return p;
	}
	
	public String newPwd(String np) {
		newPassword.sendKeys(np);
		return np;
	}
	
	public String confirmPwd(String cp) {
		confirmPassword.sendKeys(cp);
		return cp;
	}
	
	public void submitbutton() {
		submit.click();
	}
	
	public String usernameText() {
		return usernameShow.getText();
	}
	
	public String  welcomeText() {
		return  welcomeText.getText();
	}
	
	public SearchHotelPage searchHotel() throws Exception {
		searchHotel.click();
		return new SearchHotelPage(driver);
	}
	
	public ChangePasswordPage changepwd() throws Exception {
		changepwd.click();
		return new ChangePasswordPage(driver);
	}
	
	public LogoutPage logout() throws Exception {
		logout.click();
		return new LogoutPage(driver);
	}
	
	public BookedItineraryPage bookedItinerary() throws Exception {
		bookedItinerary.click();
		return new BookedItineraryPage(driver);
	}
	
	public String loginTitleText() {
		return loginTitle.getText();
	}
	
	public String mandText() {
		return mandText.getText();
	}
	
	public boolean adactinLogo() {
		return adactinLogo.isDisplayed();
	}
	
	public boolean reservationImg() {
		return reservationImg.isDisplayed();
	}
	
	public ChangePasswordPage changepass() throws Exception {
		changepwd.click();
		return new ChangePasswordPage(driver);
	}
	
	public String emptyErrorText() {
		return emptyErrorText.getText();
	}

}
