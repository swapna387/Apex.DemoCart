package com.apex.ecomm.user.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apex.ecomm.order.page.OrderPage;
import com.apex.ecomm.search.page.SearchPage;
import com.apex.web.core.ApexWebDriverUtil;



public class AccountsPage {
	
	
	
	private By searchBar = By.name("search");
	private By searchButton = By.xpath("//span[@class='input-group-btn']");
	
	private By viewCartBtn = By.id("cart-total");
	private By itemscartBtn = By.xpath("//span[@id='cart-total']/i");
	
	private By viewCrtBtn2 = By.xpath("//p[@class='text-right']/a[1]");
	
	private WebDriver driver;
	ApexWebDriverUtil web_Util;

	public AccountsPage(WebDriver driver) {
		
		this.driver=driver;
		web_Util = new ApexWebDriverUtil(driver);
		
	}
	
	
	public String doGetTitle()
	{
		return web_Util.titleOfPage();
	}
	
	
	

	//Search operation
	
	
	public SearchPage searchProductName(String productName)
	{
		
		System.out.println("Searching for the product" + productName);
		web_Util.doSendKeys(searchBar, productName);
		web_Util.doClick(searchButton);
		
		return new SearchPage(driver);
	}

	//View Cart operation

	
	public OrderPage	viewCart()
	{
		web_Util.doClick(viewCartBtn);
		
		web_Util.doClick(viewCrtBtn2);
		
		
		return new OrderPage(driver);
		
	}

}
