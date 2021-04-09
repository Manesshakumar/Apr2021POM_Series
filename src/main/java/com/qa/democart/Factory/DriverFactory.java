package com.qa.democart.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	Properties prop;
	WebDriver driver;
	public static String highlight;
	OptionManager optionManager;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>(); //create a local copy of WebDriver instances.

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
			//driver = new ChromeDriver(optionManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionManager.getFireFoxOptions());
			tlDriver.set(new FirefoxDriver(optionManager.getFireFoxOptions()));
		}else if(browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();			
		}else {
			System.out.println("Pass the Valid browser");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	/**
	 * Screenshot Feature
	 * @return path
	 */
	public static String getScreenshot() {		
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return path;
		
	}
	

}


