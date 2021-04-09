package com.qa.democart.test;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.democart.base.BaseTest;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accountPageSetUp() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority = 1)
	public void accountLinkTest() {
		accountPage.getaccountLink();
	}
	
	@Test(priority = 2)
	public void headerInfoTest() {
		List<String> textlist = accountPage.getHeaderInfo();
		System.out.println(textlist);
  
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"iMac"},{"MacBook"}};
	}
	
	@Test(priority = 3,dataProvider = "getData")
		public void searchTest(String prodName) {
			accountPage.doSearch(prodName);
		}
//	@Test(priority = 4 )
//	public void searchTest_MacBook() {
//		accountPage.doSearch("MacBook");
//	}
	
	@Test(priority = 5 )
	public void verifyProductResult() {
		accountPage.doSearch("iMac");
		productInfoPage = accountPage.doSelectProductFromList("iMac");
	}
	









}
	
	
	
	
	

