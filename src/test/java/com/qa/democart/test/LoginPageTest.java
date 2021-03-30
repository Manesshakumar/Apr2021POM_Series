package com.qa.democart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Utils.Constants;
import com.qa.democart.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
    @Test(priority = 1)
    public void titleTest() {
    	String title = loginPage.titleCheck();
    	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
    }
    
    @Test(priority = 2)
    public void headerDisplayTest() {
    	Assert.assertTrue(loginPage.headerCheck());
    }

    @Test(priority = 3)
    public void doLoginTest() {
    	String un = prop.getProperty("username");
    	String pwd = prop.getProperty("password");
        loginPage.doLogin(un, pwd);
    }

}
