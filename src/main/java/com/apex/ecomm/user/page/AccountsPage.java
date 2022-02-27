package com.apex.ecomm.user.page;

import org.openqa.selenium.WebDriver;

import com.apex.web.core.ApexWebDriverUtil;

public class AccountsPage {
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

}
