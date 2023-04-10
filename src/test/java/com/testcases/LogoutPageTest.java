package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.hotel.pages.LoginPage;
import com.hotel.pages.LogoutPage;
import com.hotel.pages.SearchHotelPage;

public class LogoutPageTest extends Testbase {

	public LogoutPageTest() throws Exception {
		super();
	}
	
	LoginPage login;
	LogoutPage logout;
	SearchHotelPage s;
	
	@BeforeMethod
	public void setUp() throws Exception {

		initialization();
		login = new LoginPage(driver);
		s = login.login(prop.getProperty("uname"), prop.getProperty("pwd"));
		s = new SearchHotelPage(driver);
	}
	@Test
	public void logoutPageTest() throws Exception {
		logout = s.logout();
		logout = new LogoutPage(driver);
		boolean logo = logout.logo();
		Assert.assertTrue(logo);
		boolean reservationImage = logout.reservationImage();
		Assert.assertTrue(reservationImage);
		String logoutText = logout.logoutText();
		Assert.assertEquals(logoutText, "You have successfully logged out. Click here to login again");
		//String loginAgainText = logout.loginAgainText();
		//Assert.assertEquals(loginAgainText, "Click here to login again");
		login = logout.loginAgain();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
