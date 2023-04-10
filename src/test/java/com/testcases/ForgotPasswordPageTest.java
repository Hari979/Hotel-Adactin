package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.hotel.pages.ForgotPasswordPage;
import com.hotel.pages.LoginPage;

public class ForgotPasswordPageTest extends Testbase {

	public ForgotPasswordPageTest() throws Exception {
		super();
	}
	ForgotPasswordPage fp;
	LoginPage lp;
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		lp = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void forgotPasswordTest() throws Exception {
		fp = lp.forgotPassword();
		fp = new ForgotPasswordPage(driver);
		String loginTitle = fp.loginTitle();
		Assert.assertEquals(loginTitle, "Forgot Password Form (Fields marked with Red asterix (*) are mandatory)");
		boolean email = fp.email();
		Assert.assertTrue(email);
		fp.submit();
		String emptyEmailAddress = fp.emptyEmailAddress();
		Assert.assertEquals(emptyEmailAddress, "Email Address is Empty");
		fp.emailId("123456");
		fp.reset();
		fp.emailId(prop.getProperty("demail"));
		fp.submit();
		Thread.sleep(2000);
		String invalidEmail = fp.invalidEmail();
		Assert.assertEquals(invalidEmail, "Email Address does not exsit in database");
		fp.reset();// after click the email password button, reset button does'nt work
		fp.emailClear();
		fp.emailId("1");
		fp.submit();//its working even we given a invalid email address
	}
	
	@Test(priority=2)
	public void goBackToLoginPageTest() throws Exception {
		fp = lp.forgotPassword();
		fp = new ForgotPasswordPage(driver);
		lp = fp.goBackToLoginPage();
	}
	
	@Test(priority=3)
	public void resetPwdTest() throws Exception {
		lp.username("hari9790");
		lp.password("12345");
		lp.loginButton();
		Thread.sleep(3000);
		String invalidLoginDetails = lp.invalidLoginDetails();
		Assert.assertEquals(invalidLoginDetails, "Invalid Login details or Your Password might have expired. Click here to reset your password");
		fp = lp.resetPwd();
		fp.emailId(prop.getProperty("email"));
		Thread.sleep(3000);
		fp.submit();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
