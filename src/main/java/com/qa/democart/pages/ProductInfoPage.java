package com.qa.democart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By productHeader = By.xpath("(//div[contains(@class,'col-sm-4')])[2]//h1");
	private By productValue = By.xpath("(//div[contains(@class,'col-sm-4')])[2]//ul[1]/li");
	private By productPrice = By.xpath("(//div[contains(@class,'col-sm-4')])[2]//ul[2]/li");
	private By quantity = By.xpath("//input[@id = 'input-quantity']");
	private By addToCart = By.id("button-cart");
	private By imgListCount = By.xpath("//ul[@class = 'thumbnails']/li");

	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getTitle(String productName) {
		return elementUtil.waitForPageTitlePresent(productName, 5);
	}
	
	public int getImgCount() {
		List<WebElement> imgList = elementUtil.getElements(imgListCount);
		return imgList.size();
	}
	
	public Map<String, String> getProductInformation() {
		Map<String,String> productMap = new HashMap<String,String>();
		String prodheader = elementUtil.doGetText(productHeader);
		productMap.put("name", prodheader);
		List<WebElement> prodValue = elementUtil.getElements(productValue);
		for(WebElement x : prodValue) {
			String prodDes[]= x.getText().split(":"); //Brand: Apple
			String prodkey = prodDes[0].trim();
			String prodval = prodDes[1].trim();
			productMap.put(prodkey, prodval);
		}
	 return productMap;
	}
	
	public Map<String, String> doPriceDetails() {
	List<WebElement> productPriceList = elementUtil.getElements(productPrice);
	Map<String,String> productPriceMap = new HashMap<String,String>();
	String dollar = productPriceList.get(0).getText();
	String tax = productPriceList.get(1).getText().split(":")[1].trim();
	productPriceMap.put("price",dollar);
	productPriceMap.put("etax",tax);
	return productPriceMap;
	}
	
	
	
	public void doQty(String value) {
		elementUtil.doSendKeys(quantity,value);
	}

	public void doClickAddToCart() {
		elementUtil.doClick(addToCart);
		
	}
}
