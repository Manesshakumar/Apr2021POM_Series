package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	ElementUtil elementUtil;

	// 2.By Locator:

	By emailID = By.id("input-email");
	By password = By.id("input-password");
	By loginBtn = By.xpath("//input[@type = 'submit']");
	By headertext = By.xpath("//h2[text() = 'Returning Customer']");

	// 3.Cons:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 4.PageActions:

	public String titleCheck() {
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

}
