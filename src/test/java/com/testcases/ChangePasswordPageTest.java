package com.testcases;

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

public class ChangePasswordPageTest extends Testbase {

	
	
	public ChangePasswordPageTest() throws Exception {
		super();
		
	}

	LoginPage login;
	SearchHotelPage sh;
	ChangePasswordPage cp;
	BookedItineraryPage bi;
	LogoutPage lp;
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		login = new LoginPage(driver);
		login.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		sh = new SearchHotelPage(driver);
		cp = sh.changePassword();
		cp = new ChangePasswordPage(driver);
	}
	
	@Test(priority=1)
	public void labelTest() {
		String currentPasswordLabel = cp.currentPasswordLabel();
		Assert.assertEquals(currentPasswordLabel, "Current Password* ");
		String newPasswordLabel = cp.newPasswordLabel();
		Assert.assertEquals(newPasswordLabel, "New Password* ");
		String confirmPasswordLabel = cp.confirmPasswordLabel();
		Assert.assertEquals(confirmPasswordLabel, "Confirm Password* ");
	}
	
	@Test(priority=2)
	public void changePasswordErrorTest() {
		cp.submitbutton();
		String emptyErrorText = cp.emptyErrorText();
		Assert.assertEquals(emptyErrorText, "Please enter correct current password!!!");
		cp.currentpwd("Hello");
		cp.newPwd("Welcome");
		cp.confirmPwd("Welcome");
		cp.submitbutton();
		cp.newPwd("1");
		cp.submitbutton();
		cp.currentpwd("1");
		cp.submitbutton();
		cp.confirmPwd("1");
		cp.submitbutton();//only return the error please enter correct current password!!!.
	}
	
	@Test(priority=3)
	public void changePasswordTest() {
		cp.currentpwd(prop.getProperty("pwd"));
		cp.newPwd(prop.getProperty("newpwd"));//accepted even we give a single char password and also accepted even we give a current password as new password
		//cp.confirmPwd(prop.getProperty("newpwd"));
		cp.submitbutton();//its working either we don't given the value in new password and confirm password;
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
