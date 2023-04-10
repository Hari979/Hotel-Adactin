package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase {

	protected WebDriver driver = null;
	protected Properties prop;
	
	public Testbase() throws Exception {

		prop = new Properties();
		prop.load(new FileInputStream("C:\\Users\\Hhari\\eclipse-workspace\\Hotel\\src\\main\\java\\com\\hotel\\pages\\hotdata.properties"));
		
	}
	
	
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hhari\\eclipse-workspace\\Hotel\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}
