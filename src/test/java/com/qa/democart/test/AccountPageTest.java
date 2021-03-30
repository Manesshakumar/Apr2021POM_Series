package com.qa.democart.test;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
	
	
	
	
	
}
