package com.hotel.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class NewUserPage extends Testbase {

	public NewUserPage(WebDriver driver) throws Exception {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(text(),'New User')]")
	WebElement newUser;
	
	@FindBy (css = ".login_title")
	WebElement loginTitle;
	
	@FindBy (xpath = "//a[contains(text(),'Go back')]")
	WebElement goBack;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[2]")
	WebElement usernameLabel;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[4]")
	WebElement passwordLabel;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[6]")
	WebElement confirmPasswordLabel;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[8]")
	WebElement nameLabel;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[10]")
	WebElement emailLabel;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[12]")
	WebElement captchaImgLabel;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[14]")
	WebElement captchaTextLabel;
	
	@FindBy (xpath = "(//form/table/tbody/tr/td)[16]")
	WebElement termsLabel;
	
	@FindBy (id = "username")
	WebElement username;
	
	@FindBy (id = "password")
	WebElement password;
	
	@FindBy (id = "re_password")
	WebElement confirmPassword;
	
	@FindBy (id = "full_name")
	WebElement fullName;
	
	@FindBy (id = "email_add")
	WebElement email;
	
	@FindBy (id = "captcha")
	WebElement captcha;
	
	@FindBy (id = "captcha-form")
	WebElement captchaText;
	
	@FindBy (id = "change-image")
	WebElement changeImage;
	
	@FindBy (id = "tnc_box")
	WebElement terms;
	
	@FindBy (xpath = "//a[text()='Terms & Conditions']")
	WebElement termsLink;
	
	@FindBy (id = "username_span")
	WebElement emptyuname;
	
	@FindBy (id = "password_span")
	WebElement emptypwd;
	
	@FindBy (id = "re_password_span")
	WebElement emptyconfirmpwd;
	
	@FindBy (id ="full_name_span")
	WebElement emptyFullName;
	
	@FindBy (id = "email_add_span")
	WebElement emptyEmail;
	
	@FindBy (id = "captcha_span")
	WebElement emptyCaptcha;
	
	@FindBy (id = "tnc_span")
	WebElement termsNotClick;
	
	@FindBy (id = "Submit")
	WebElement submit;
	
	@FindBy (id = "Reset")
	WebElement reset;
	
	@FindBy (css = ".reg_success")
	WebElement regsuccess;
	
	@FindBy (linkText = "Click here to login")
	WebElement login;
	
	@FindBy (css = ".register_msg")
	WebElement regmsg;
	
	
	public String loginTitle() {
		return loginTitle.getText();
	}
	
	public void goBack() {
		goBack.click();
	}
	
	public String usernameLabel() {
		return usernameLabel.getText();
	}
	
	public String passwordLabel() {
		return passwordLabel.getText();
	}
	
	public String confrimPasswordLabel() {
		return confirmPasswordLabel.getText();
	}
	
	public String fullNameLabel() {
		return fullName.getText();
	}
	
	public String emailLabel() {
		return emailLabel.getText();
	}
	
	public String captchaImgLabel() {
		return captchaImgLabel.getText();
	}
	
	public String captchaTextLabel() {
		return captchaTextLabel.getText();
	}
	
	public String termsLabel() {
		return termsLabel.getText();
	}
	
	public String emptyUname() {
		return emptyuname.getText();
	}
	
	public String emptypwd() {
		return emptypwd.getText();
	}

	public String emptyconfirmpwd() {
		return emptyconfirmpwd.getText();
	}
	
	public String emptyFullName() {
		return emptyFullName.getText();
	}
	
	public String emptyEmail() {
		return emptyEmail.getText();
	}
	
	public String emptyCaptchaText() {
		return emptyCaptcha.getText();
	}
	
	public String termsNotCheck() {
		return termsNotClick.getText();
	}
	
	public void register() {
		submit.click();
	}
	
	public String uname(String n) {
		username.sendKeys(n);
		return n;
	}
	
	public String password (String p) {
		password.sendKeys(p);
		return p;
	}
	
	public String confirmPwd(String c) {
		confirmPassword.sendKeys(c);
		return c;
	}
	
	public String fullName(String f) {
		fullName.sendKeys(f);
		return f;
	}
	
	public String email(String e) {
		email.sendKeys(e);
		return e;
	}
	
	public String captchaText(String captchatext) throws IOException, TesseractException {
		File src = captcha.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\Hhari\\eclipse-workspace\\Hotel\\screenshot\\captcha.png";
		FileHandler.copy(src, new File(path));
		ITesseract image = new Tesseract();
		image.setDatapath("C:\\Users\\Hhari\\eclipse-workspace\\Hotel\\tessdata");
		image.setTessVariable("user_defined_dpi", "80");
		captchatext = image.doOCR(new File(path));
		captchaText.sendKeys(captchatext);
		prop.setProperty("captcha", captchatext);
		return captchatext;
	}
	
	public void changeCaptchaImg() {
		changeImage.click();
	}
	
	public String captcha(String s) {
		captchaText.sendKeys(s);
		return s;
	}
	
	public void terms() {
		terms.click();
	}
	
	public void reset() {
		reset.click();
	}
	
	public String regsuccess() {
		return regsuccess.getText();
	}
	
	public String regmsg() {
		return regmsg.getText();
	}
	
	public void login() {
		login.click();
	}
	
	public void screenshot(String screen) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Hhari\\eclipse-workspace\\Demo.java\\screenshot\\"+screen+".png");
		FileUtils.copyFile(src, des);
	}
	
	public void captchaTextclear() {
		captchaText.clear();
	}
}
