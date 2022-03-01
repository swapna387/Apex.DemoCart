package com.apex.ecomm.order.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apex.web.core.ApexWebDriverUtil;

public class OrderPage {

	private By estimateshiplink = By.linkText("Estimate Shipping & Taxes ");
	private By countryDropDown = By.id("input-country");
	private By regionDropDown = By.id("input-zone");
	private By postCodeText = By.id("input-postcode");
	private By checkOutBtn = By.linkText("Checkout");
	private By continueShopBtn = By.linkText("Continue Shopping");

	private By getQuotesbtn = By.id("button-quote");

	private ApexWebDriverUtil web_Util;
	private WebDriver driver;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		web_Util = new ApexWebDriverUtil(driver);
	}

	public void selectCountry(String country) {
		web_Util.getElement(estimateshiplink).click();
		web_Util.doSelectValueByVisibleText(countryDropDown, country);

	}

	public void selectRegion(String Region) {
		web_Util.getElement(regionDropDown).click();
		web_Util.doSelectValueByVisibleText(regionDropDown, Region);
	}

	public void enterPostCode(String postCode) {
		web_Util.doSendKeys(postCodeText, postCode);
	}

	public void clickquotesBtn() {
		web_Util.doClick(getQuotesbtn);
	}

	public void clickCheckOutBtn() {
		web_Util.doClick(checkOutBtn);
	}

	public void clickContinueShopBtn() {
		web_Util.doClick(continueShopBtn);
	}

}
