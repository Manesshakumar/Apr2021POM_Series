package com.qa.democart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Utils.Constants;
import com.qa.democart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Story(value = "32078")
public class LoginPageTest extends BaseTest{
	
    @Test(priority = 1)
    @Description("Verify Title")
    @Severity(SeverityLevel.MINOR)
    public void titleTest() {
    	String title = loginPage.titleCheck();
    	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
    }
    
    @Test(priority = 2)
    public void headerDisplayTest() {
    	Assert.assertTrue(loginPage.headerCheck());
    }

    @Test(priority = 3)
    @Step("Enter username :{0}and Enter password : {1}")
    public void doLoginTest() {
    	System.out.println("Verify Login Page Test");
    	String un = prop.getProperty("username");
    	String pwd = prop.getProperty("password");
        loginPage.doLogin(un, pwd);
    }

}
