package com.qa.democart.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory_1 {
	
	Properties prop;
	WebDriver driver;
	public static String highlight;
	OptionManager optionManager;

	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream io = new FileInputStream("./src/test/resources/com/qa/config/config.properties");
			prop.load(io);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public WebDriver init_browser(Properties prop) {
		
		String browser =  prop.getProperty("browser");
		highlight = prop.getProperty("highlight");	
		
		optionManager = new OptionManager(prop);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionManager.getChromeOptions());
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionManager.getFireFoxOptions());
		}else if(browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("Pass the Valid browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}
	
	/**
	 * This Driver Factory is created before thread Local.
	 */
	
	

}
