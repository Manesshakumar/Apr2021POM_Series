package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	ElementUtil elementUtil;

	By headerPart = By.xpath("//div[@id = 'content']/h2");
	By accountLink = By.xpath("//a[text() = 'Account']");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void getaccountLink() {
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

}
