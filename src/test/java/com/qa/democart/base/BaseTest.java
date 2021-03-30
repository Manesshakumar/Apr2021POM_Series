package com.qa.democart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.Factory.DriverFactory;
import com.qa.democart.pages.AccountPage;
import com.qa.democart.pages.LoginPage;

public class BaseTest {

	DriverFactory df;
	public Properties prop;
	WebDriver driver;
	public LoginPage loginPage ;
	public AccountPage accountPage;
	

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();	
		String url = prop.getProperty("url");		
	    driver = df.init_browser(prop);
	    driver.get(url);
	    loginPage = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
