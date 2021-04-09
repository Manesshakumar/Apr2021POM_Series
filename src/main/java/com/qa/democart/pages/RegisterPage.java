package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Utils.Constants;
import com.qa.Utils.ElementUtil;

public class RegisterPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By registerLink = By.xpath("//div[@class = 'list-group'] /a[text() = 'Register']");
	private By firstName = By.xpath("//div[@class = 'col-sm-10'] /input[@id = 'input-firstname']");
	private By lastName = By.xpath("//div[@class = 'col-sm-10'] /input[@id = 'input-lastname']");
	private By emailID = By.xpath("//div[@class = 'col-sm-10'] /input[@id = 'input-email']");
	private By telephoneNo = By.xpath("//div[@class = 'col-sm-10'] /input[@id = 'input-telephone']");
	private By password = By.xpath("//div[@class = 'col-sm-10'] /input[@id = 'input-password']");
	private By confirmPassword = By.xpath("//div[@class = 'col-sm-10'] /input[@id = 'input-confirm']");
	private By subscribeYes  = By.xpath("(//input[@type ='radio' and @value = '1'])[2]");
	private By subscribeNo  = By.xpath("//input[@type ='radio' and @value = '0']");
	private By privacyCheckbox = By.xpath("//input[@type ='checkbox' and @value = '1']");
	private By agreeBtn = By.xpath("//input[@type ='submit']");
	private By accountHeaderCheck = By.cssSelector("div#content h1");
	private By logoutLink = By.xpath("//div[@class = 'list-group'] /a[text() = 'Logout']");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public boolean accountRegistration(String firstName,String lastName,String emailId,String telephoneNo,String password,String subscribe) {
		elementUtil.doSendKeys(this.firstName,firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.emailID, emailId);
		elementUtil.doSendKeys(this.telephoneNo, telephoneNo);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);
		
		if(subscribe.equals("yes")) {
	          elementUtil.doClick(subscribeYes);          
		}else {
			elementUtil.doClick(subscribeNo);
		}
		
		elementUtil.doClick(privacyCheckbox);
		elementUtil.doClick(agreeBtn);
		String text = elementUtil.doGetText(accountHeaderCheck);
		if(text.contains(Constants.ACCOUNT_SUCCESS_MSG)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}else {
			return false;
		}
				
		
	}
	
	
			

}
