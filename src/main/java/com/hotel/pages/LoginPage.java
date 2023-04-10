package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class LoginPage extends Testbase {

	public LoginPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy (id = "username")
	WebElement username;
	
	@FindBy (id = "password")
	WebElement password;
	
	@FindBy (id="login")
	WebElement login;
	
	@FindBy (id = "username_span")
	WebElement usernameError;
	
	@FindBy (id = "password_span")
	WebElement passwordError;
	
	@FindBy (xpath = "//a[text()='Forgot Password?']")
	WebElement forgotpwd;
	
	@FindBy (xpath = "//a[contains(text(),'New User')]")
	WebElement newUser;
	
	@FindBy (css = ".logo")
	WebElement logo;
	
	@FindBy(css = ".login_title")
	WebElement loginTitle;
	
	@FindBy(xpath = "((//tbody)[5]/tr/td)[2]")
	WebElement unameText;
	
	@FindBy(xpath = "((//tbody)[5]/tr/td)[4]")
	WebElement pwdText;
	
	@FindBy(xpath = "//p[contains(text(),'Adactin Launches')]")
	WebElement appLaunchText;
	
	@FindBy(xpath = "((//tbody)[3]//td)[2]")
	WebElement freeLearningText;
	
	@FindBy(xpath = "//img[@alt='Hotel Image 3']")
	WebElement hotelAppImg;
	
	@FindBy(xpath = "//img[contains(@alt,'Hotel Reservation System')]")
	WebElement reservationImg;
	
	@FindBy(xpath = "(//img)[4]")
	WebElement iosImg;
	
	@FindBy(xpath = "(//img)[5]")
	WebElement androidImg;
	
	@FindBy (xpath = "//a[text()='Click here']")
	WebElement resetPwd;
	
	@FindBy (xpath = "((//tbody)[5]/tr/td)[9]")
	WebElement invalidLoginDetails;
	
	public String longinPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public boolean hotelAppImage() {
		return hotelAppImg.isDisplayed();
	}
	
	public boolean reservationImage() {
		return reservationImg.isDisplayed();
	}
	
	public boolean iosImage() {
		return iosImg.isDisplayed();
	}
	
	public boolean androidImage() {
		return androidImg.isDisplayed();
	}
	
	public void iosApp() {
		iosImg.click();
	}
	
	public void androidApp() {
		androidImg.click();
	}
	
	public String loginTitle() {
		String title = loginTitle.getText();
		return title;
	}
	
	public String userNameText() {
		return unameText.getText();
	}
	
	public String passwordText() {
		return pwdText.getText();
	}
	
	public String appLaunchText() {
		return appLaunchText.getText();
	}
	
	public String freeLearningText() {
		return freeLearningText.getText();
	}
	
	
	public SearchHotelPage login(String un, String pwd) throws Exception {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new SearchHotelPage(driver);
	}
	
	public ForgotPasswordPage forgotPassword() throws Exception {
		forgotpwd.click();
		return new ForgotPasswordPage(driver);
	}
	
	public NewUserPage newUser() throws Exception {
		newUser.click();
		return new NewUserPage(driver);
	}
	
	public String username(String u) {
		username.sendKeys(u);
		return u;
	}
	
	public String password(String p) {
		password.sendKeys(p);
		return p;
	}
	
	public void loginButton() {
		login.click();
	}
	
	public ForgotPasswordPage resetPwd() throws Exception {
		resetPwd.click();
		return new ForgotPasswordPage(driver);
	}
	
	public String invalidLoginDetails() {
		return invalidLoginDetails.getText();
	}
	
	public String emptyUsername() {
		return usernameError.getText();
	}
	
	public String emptypwd() {
		return passwordError.getText();
	}
}
