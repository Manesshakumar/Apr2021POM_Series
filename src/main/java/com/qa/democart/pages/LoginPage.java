package com.qa.democart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Utils.ElementUtil;

public class LoginPage {
	
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginPage.class));

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 2.By Locator:

	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type = 'submit']");
	private By headertext = By.xpath("//h2[text() = 'Returning Customer']");
	private By registerLink = By.xpath("//div[@class = 'list-group'] /a[text() = 'Register']");

	// 3.Cons:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 4.PageActions:

	public String titleCheck() {
		LOGGER.info("Title Check");
		return elementUtil.getTitle();

	}

	public boolean headerCheck() {
		return elementUtil.getElement(headertext).isDisplayed();
	}

	public AccountPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailID, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountPage(driver);

	}
	
	public RegisterPage doRegisterClick() {
		elementUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}
