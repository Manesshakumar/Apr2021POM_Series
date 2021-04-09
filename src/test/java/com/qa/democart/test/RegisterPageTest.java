package com.qa.democart.test;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Utils.Constants;
import com.qa.Utils.ExcelUtil;
import com.qa.democart.base.BaseTest;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void getRegisterClick() {
		registerPage = loginPage.doRegisterClick();
	}
	
	/**
	 * DD Approach
	 * @return 
	 * @return 
	 */
	
	public int generateRandomNo() {
		Random random = new Random();   
		int randomNo = random.nextInt(1000);
		System.out.println(randomNo);
		return randomNo;
	}
	
	@DataProvider
	public Object[][] getData() {
		Object data [][] = ExcelUtil.getTestData(Constants.SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void doRegistrationTest(String firstName,String lastName,String emailId,String telephoneNo,String password,String subscribe) {
		String email = emailId + generateRandomNo()+"@gmail.com";
		registerPage.accountRegistration(firstName, lastName, email, telephoneNo, password, subscribe);
	}

}
