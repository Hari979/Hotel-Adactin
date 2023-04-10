package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.hotel.pages.ForgotPasswordPage;
import com.hotel.pages.LoginPage;
import com.hotel.pages.NewUserPage;
import com.hotel.pages.SearchHotelPage;

public class LoginTest extends Testbase{

	public LoginTest() throws Exception {
		super();
	}
	
	LoginPage login;
	SearchHotelPage sh;
	ForgotPasswordPage fp;
	NewUserPage nu;
	

	@BeforeMethod
	public void setUp() throws Exception {

		initialization();
		login = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loginTest() throws Exception {
		sh = login.login(prop.getProperty("uname"), prop.getProperty("pwd"));
	}
	
	@Test(priority=2)
	public void invalidLoginTest() throws Exception {
		login.username("hari9790");
		login.password("12345");
		login.loginButton();
		Thread.sleep(3000);
		String invalidLoginDetails = login.invalidLoginDetails();
		Assert.assertEquals(invalidLoginDetails, "Invalid Login details or Your Password might have expired. Click here to reset your password");
		fp = login.resetPwd();
	}
	
	@Test(priority=3)
	public void forgotPwdTest() throws Exception {
		fp = login.forgotPassword();
	}
	
	@Test(priority=4)
	public void newUserTest() throws Exception {
		nu = login.newUser();
	}
	
	@Test(priority=5)
	public void emptyUsernamePwdTest() {
		login.loginButton();
		String emptyUsername = login.emptyUsername();
		Assert.assertEquals(emptyUsername, "Enter Username");
		login.username("123");
		login.loginButton();
		String emptypwd = login.emptypwd();
		Assert.assertEquals(emptypwd, "Enter Password");
	}
	
	@Test (priority=6)
	public void validateImages() {
		
		boolean logo = login.validateLogo();
		Assert.assertTrue(logo);
		
		boolean hotelAppImage = login.hotelAppImage();
		Assert.assertTrue(hotelAppImage);
		
		boolean reservationImage = login.reservationImage();
		Assert.assertTrue(reservationImage);
		
		boolean iosImage = login.iosImage();
		Assert.assertTrue(iosImage);
		
		boolean androidImage = login.androidImage();
		Assert.assertTrue(androidImage);
	}
	
	@Test(priority=7)
	public void validateTextTest() {
		
		String loginTitle = login.loginTitle();
		Assert.assertEquals(loginTitle, "Existing User Login - Build 1");
		
		String pageTitle = login.longinPageTitle();
		Assert.assertEquals(pageTitle, "Adactin.com - Hotel Reservation System");
		
		String userNameText = login.userNameText();
		Assert.assertEquals(userNameText, "Username "); 
		
		String passwordText = login.passwordText();
		Assert.assertEquals(passwordText, "Password "); 
		
		String appLaunchText = login.appLaunchText();
		Assert.assertEquals(appLaunchText, "Adactin Launches The Adactin Hotel App!");
		
		String freeLearningText = login.freeLearningText();
		Assert.assertEquals(freeLearningText, "The best Free learning platform for Software Testing\n"
				+ "Now available to download for free on IOS and Android.");
		

	}
	
	@Test(priority=8)
	public void iosAppLinkClickTest() {
		login.iosApp();
	}
	
	@Test(priority=9)
	public void androidAppLinkClickTest()
	{
		login.androidApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
