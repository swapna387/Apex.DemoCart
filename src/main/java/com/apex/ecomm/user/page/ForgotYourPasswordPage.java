package com.apex.ecomm.user.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apex.web.core.ApexWebDriverUtil;

public class ForgotYourPasswordPage {
	
	private WebDriver driver ;
	
	private By email = By.id("input-email");
	
	private By backBtn = By.xpath("//a[text()='Back']");
	
	private By continueBtn = By.cssSelector("input.btn.btn-primary");
	
	ApexWebDriverUtil web_Util;
	
	
	public ForgotYourPasswordPage(WebDriver driver)
	{
		this.driver = driver;
		web_Util = new ApexWebDriverUtil(driver);
	}
	
	
	
	public String getTitle()
	{
		return web_Util.titleOfPage();
	}
	
	
	
	

}
