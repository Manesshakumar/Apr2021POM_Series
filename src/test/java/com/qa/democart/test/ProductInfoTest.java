package com.qa.democart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.democart.base.BaseTest;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoTestSetUp() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@BeforeMethod
	public void doSearchTest() {
		accountPage.doSearch("iMac");
		productInfoPage = accountPage.doSelectProductFromList("iMac");
	}
	
	
	
   @Test(priority = 2)
	public void verifyProductInfoTest() {	
		Map<String,String> productInfo = productInfoPage.getProductInformation();
	    productInfo.forEach((K,V)->System.out.println(K +" "+ V));
	    Assert.assertEquals(productInfo.get("name"), "iMac");
	    Assert.assertEquals(productInfo.get("Brand"), "Apple");
	    
	    /**
	     * SoftAssert
	     */
	    
	    SoftAssert softassert = new SoftAssert();
	    softassert.assertEquals(productInfo.get("productInfo"), "Product 14");
	    softassert.assertAll();
	}
	
	
   @Test(priority = 3)
	public void verifyProductPriceTest() {
		Map<String,String> priceDetails = productInfoPage.doPriceDetails();
		priceDetails.forEach((K,V) ->System.out.println(K + " " +V));
		Assert.assertEquals(priceDetails.get("price"), "$100.00");
		
		
		
		
   }
   
   @Test(priority = 4)
	public void verifyTitleTest() {
		String title = productInfoPage.getTitle("iMac");
		Assert.assertEquals(title, "iMac");
	}
   
   @Test(priority = 5)
 	public void productImgTest() {
 		int imgCount = productInfoPage.getImgCount();
 		Assert.assertEquals(imgCount, 3, "Image Count");
 	}
 	
   
   @Test(priority = 6)
  	public void productAddToCartTest() {
  		productInfoPage.doQty("3");
  		productInfoPage.doClickAddToCart();  		
  	}
  	
	

}
