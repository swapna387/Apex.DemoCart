package com.apex.ecomm.order.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.apex.ecomm.order.constant.OrderConstants;
import com.apex.web.core.ApexWebDriverUtil;

public class ProductDetailsPage


{

	private WebDriver driver;
	private ApexWebDriverUtil web_Util;

	private  By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails li img");
	private By productMetaData =  	By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData= By.cssSelector("div.col-sm-4 ul.list-unstyled:nth-of-type(2) li");

	private By quantity= By.id("input-quantity");
	private By addToCartBtn= By.id("button-cart");

	private By successMsg = By.cssSelector("div.alert.alert-success.alert-dismissible");

	public ProductDetailsPage(WebDriver driver)
		{
			this.driver= driver;
			web_Util = new ApexWebDriverUtil(driver);
		}

	public String getPageTitle() {
		return web_Util.waitForTitle(5, OrderConstants.PRODUCTINFO_URL);
	}

	public String getProductHeaderText() {
		return web_Util.doGetText(productHeader);
	}

	public int getProductImgCount() {
		int n = web_Util.getElements(productImages).size();

		System.out.println("number of images are present for the product is " + n);
		return n;
	}

	public Map<String, String> getProductMetaDataInfo() {
		Map<String, String> productMetaList = new HashMap<String, String>();

		productMetaList.put("name", getProductHeaderText());

		List<WebElement> productList = web_Util.getElements(productMetaData);
		for (WebElement e : productList) {
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();

			productMetaList.put(metaKey, metaValue);

		}

		List<WebElement> priceList = web_Util.getElements(productPriceData);

		String price = priceList.get(0).getText().trim();

		String ExPrice = priceList.get(1).getText().trim();

		productMetaList.put("price", price);

		productMetaList.put("ExTaxPrice", ExPrice);

		return productMetaList;

	}

	public void selectQuantity(String qty) {
		web_Util.getElement(quantity).clear();
		web_Util.doSendKeys(quantity, qty);
	}

	public void addToCrtBtn() {
		System.out.println("clicking on add to cart button");
		web_Util.doClick(addToCartBtn);

	}

	public String successMsg() {
		return web_Util.doGetText(successMsg);
	}

}


