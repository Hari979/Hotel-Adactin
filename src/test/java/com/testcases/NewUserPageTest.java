package com.testcases;

import java.io.IOException;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Testbase;
import com.hotel.pages.LoginPage;
import com.hotel.pages.NewUserPage;

import net.sourceforge.tess4j.TesseractException;

public class NewUserPageTest extends Testbase {

	public NewUserPageTest() throws Exception {
		
	}
	
	LoginPage login;
	NewUserPage nu;
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		login=new LoginPage(driver);
		nu=login.newUser();
		nu = new NewUserPage(driver);
		
	}
	
	@Test(priority=1)
	public void labelsTextTest() throws IOException, TesseractException, InterruptedException {
		String loginTitle = nu.loginTitle();
		Assert.assertEquals(loginTitle, "New User Registration Form (Fields marked with Red asterix (*) are mandatory)");
		String usernameLabel = nu.usernameLabel();
		Assert.assertEquals(usernameLabel, "Username* ");
		String passwordLabel = nu.passwordLabel();
		Assert.assertEquals(passwordLabel, "Password* ");
		String confrimPasswordLabel = nu.confrimPasswordLabel();
		Assert.assertEquals(confrimPasswordLabel, "Confirm Password* ");
		String fullNameLabel = nu.fullNameLabel();
		Assert.assertEquals(fullNameLabel, "");
		String emailLabel = nu.emailLabel();
		Assert.assertEquals(emailLabel, "Email Address* ");
		String captchaImgLabel = nu.captchaImgLabel();
		Assert.assertEquals(captchaImgLabel, "Captcha Image ");
		String captchaTextLabel = nu.captchaTextLabel();
		Assert.assertEquals(captchaTextLabel, "Captcha Text* ");
		String termsLabel = nu.termsLabel();
		Assert.assertEquals(termsLabel, "Terms/Conditions* ");
		
		nu.register();
		String emptyUname = nu.emptyUname();
		Assert.assertEquals(emptyUname, "Username is Empty");
		String emptypwd = nu.emptypwd();
		Assert.assertEquals(emptypwd, "Password is Empty");
		String emptyconfirmpwd = nu.emptyconfirmpwd();
		Assert.assertEquals(emptyconfirmpwd, "Confirm Password is Empty");
		String emptyFullName = nu.emptyFullName();
		Assert.assertEquals(emptyFullName, "Full Name is Empty");
		String emptyEmail = nu.emptyEmail();
		Assert.assertEquals(emptyEmail, "Email Address is Empty");
		String emptyCaptchaText = nu.emptyCaptchaText();
		Assert.assertEquals(emptyCaptchaText, "Captcha is Empty");
		String termsNotCheck = nu.termsNotCheck();
		Assert.assertEquals(termsNotCheck, "You must agree to Terms and Conditions");
		
		nu.uname("a");
		nu.password("p");
		nu.register();
		String unameerror = nu.emptyUname();
		String charerror = nu.emptypwd();
		Assert.assertEquals(unameerror, "Username must contain minimum 8 characters");
		Assert.assertEquals(charerror, "Password must contain minimum 6 characters");
		nu.confirmPwd("c");
		nu.register();
		String pwdnotmatch = nu.emptyconfirmpwd();
		Assert.assertEquals(pwdnotmatch, "Passwords Do Not Match");
		nu.fullName("a");//accept single char name
		nu.register();
		nu.captchaText(prop.getProperty("captcha"));//using tesseractOCR it read captcha from the taken screenshot 90% not match.
		Thread.sleep(7000);
		nu.register();
		Thread.sleep(5000);
		String invalidcaptcha = nu.emptyCaptchaText();
		Assert.assertEquals(invalidcaptcha, "Captcha is Invalid");
		nu.changeCaptchaImg();
		Thread.sleep(2000);
		nu.captchaTextclear();
		String captchaText = nu.captchaText(prop.getProperty("captcha"));
		System.out.println(captchaText);
		nu.register();
	}
	
	@Test(priority=2)
	public void inputTest() throws InterruptedException, IOException {
		nu.uname(prop.getProperty("newusername"));
		nu.password(prop.getProperty("newpassword"));
		nu.confirmPwd(prop.getProperty("confirmpassword"));
		nu.fullName(prop.getProperty("fullname"));
		nu.email(prop.getProperty("demail"));
		System.out.println("Enter the captcha");
		Thread.sleep(5000);
		Scanner s = new Scanner(System.in);
		String cap = s.nextLine();
		nu.captcha(cap);
		nu.terms();
		nu.register();
		Thread.sleep(5000);
		nu.screenshot("registration success.png");
		Thread.sleep(1000);
		nu.login();	
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
