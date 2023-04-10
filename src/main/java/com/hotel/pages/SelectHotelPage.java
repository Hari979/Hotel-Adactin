package com.hotel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class SelectHotelPage extends Testbase {

	public SelectHotelPage(WebDriver driver) throws Exception {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Hello Username! ']")
	WebElement userNameShow;
	
	@FindBy(css=".login_title")
	WebElement loginTitle;
	
	@FindBy(id="radiobutton_0")
	WebElement select;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="cancel")
	WebElement cancel;
	
	@FindBy(id="radiobutton_span")
	WebElement notSelected;
	
	public String userNameShow() {
		return userNameShow.getText();
	}
	
	public String loginTitle() {
		return loginTitle.getText();
	}
	
	public void select() {
		select.click();
	}
	
	public BookHotelPage continueButton() throws Exception {
		continueButton.click();
		return new BookHotelPage(driver);
	}
	
	public SearchHotelPage cancel() throws Exception {
		cancel.click();
		return new SearchHotelPage(driver);
	}
	
	public String hotelNotSelected() {
		return notSelected.getText();
	}
}
