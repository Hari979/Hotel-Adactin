package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class LogoutPage extends Testbase {

	public LogoutPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".logo")
	WebElement logo;
	
	@FindBy(xpath = "//img[contains(@alt,'Hotel Reservation System')]")
	WebElement reservationImg;
	
	@FindBy(css = ".reg_success")
	WebElement logoutText;
	
	@FindBy(xpath = "(//a//preceding::tbody)[3]")
	WebElement loginAgain;
	
	
	public boolean logo() {
		return logo.isDisplayed();
	}
	
	public boolean reservationImage() {
		return reservationImg.isDisplayed();
	}
	
	public String logoutText() {
		return logoutText.getText();
	}
	
	public String loginAgainText() {
		return loginAgain.getText();
	}
	
	public LoginPage loginAgain() throws Exception {
		loginAgain.click();
		return new LoginPage(driver);
	}
	
	
}
