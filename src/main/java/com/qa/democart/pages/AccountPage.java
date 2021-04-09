package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.ElementUtil;

public class AccountPage {
	
	 private static final Logger LOGGER = Logger.getLogger(String.valueOf(AccountPage.class));

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By headerPart = By.xpath("//div[@id = 'content']/h2");
	private By accountLink = By.xpath("//a[text() = 'Account']");
	
	private By searchBar = By.xpath("//input[@name = 'search']");
	private By searchBtn = By.xpath("//div[@id = 'search']//button[@type= 'button']");
	private By resultText = By.xpath("//div[@class = 'caption']//a");
	private By resultItemList = By.cssSelector("div.product-layout div.product-thumb");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void getaccountLink() {
		LOGGER.info("Account Link Click");
		elementUtil.doClick(accountLink);
	}

	public List<String> getHeaderInfo() {
		List<String> sectionList = new ArrayList<String>();
		List<WebElement> headerInfoList = elementUtil.getElements(headerPart);
		System.out.println(headerInfoList.size());
		for (WebElement x : headerInfoList) {
			String headerText = x.getText();
			sectionList.add(headerText);
		}

		return sectionList;
	}
	
	//********Search Functionality feature*************
	
	public boolean doSearch(String productName) {
		elementUtil.doSendKeys(searchBar, productName);
		elementUtil.doClick(searchBtn);
		if(elementUtil.getElements(resultItemList).size()>0) {
			return true;			
		}else {
			return false;
		}
	}
	
	public ProductInfoPage doSelectProductFromList(String productName) {
	 List<WebElement> itemList = elementUtil.getElements(resultText);
	 System.out.println(itemList.size());
	 for(WebElement x :itemList ) {
		 String productDetails = x.getText();
		 if(productDetails.equals(productName)) {
			 x.click();
			 break;
		 }
	 }
	 return new ProductInfoPage(driver);
	}
	
}
