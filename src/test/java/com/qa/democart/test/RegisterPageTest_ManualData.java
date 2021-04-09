package com.qa.democart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.democart.base.BaseTest;

public class RegisterPageTest_ManualData extends BaseTest {
	
	@BeforeClass
	public void getRegisterClick() {
		registerPage = loginPage.doRegisterClick();
	}
	
	@Test
	public void doRegistrationTest() {
		registerPage.accountRegistration("David", 
				"Steve", 
				"DavidSteve345@gmail.com", 
				"1258746", 
				"1234567890", "yes");
	}

}
