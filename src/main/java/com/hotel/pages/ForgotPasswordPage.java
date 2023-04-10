package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class ForgotPasswordPage extends Testbase {

	public ForgotPasswordPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[text()='Forgot Password?']")
	WebElement forgotpwd;
	
	@FindBy (css = ".login_title")
	WebElement loginTitle;
	
	@FindBy (xpath = "//a[text()='Go back to Login page']")
	WebElement goBackToLoginPage;
	
	@FindBy (id = "emailadd_recovery")
	WebElement emailId;
	
	@FindBy (id = "Submit")
	WebElement emailPwd;
	
	@FindBy (id="Reset")
	WebElement reset;
	
	@FindBy (xpath = "//span[@style='color:#FF0000;']")
	WebElement invalidEmailId;
	
	@FindBy (xpath = "((//tbody)[3]/tr/td)[2]")
	WebElement emailLabel;
	
	@FindBy (id = "emailadd_span")
	WebElement empty;
	
	@FindBy (xpath = "((//tbody)[5]/tr/td)[9]")
	WebElement invalidLoginDetails;
	
	@FindBy (xpath = "//a[text()='Click here']")
	WebElement resetPwd;
	
	public String loginTitle() {
		return loginTitle.getText();
	}
	
	public LoginPage goBackToLoginPage() throws Exception {
		goBackToLoginPage.click();
		return new LoginPage(driver);
	}
	
	public String emailId(String email) {
		emailId.sendKeys(email);
		return email;
	}
	
	public void emailClear() {
		emailId.clear();
	}
	
	public void submit() {
		emailPwd.click();
	}
	
	public void reset() {
		reset.click();
	}
	
	public String invalidEmail() {
		return invalidEmailId.getText();
	}
	
	public boolean email() {
		return emailLabel.isDisplayed();
	}
	
	public String emptyEmailAddress() {
		return empty.getText();
	}
	
	public String invalidLoginDetails() {
		return invalidLoginDetails.getText();
	}
	
	public ForgotPasswordPage resetPwd() throws Exception {
		resetPwd.click();
		return new ForgotPasswordPage(driver);
	}

}
