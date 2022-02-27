package com.apex.web.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.apex.ecomm.user.page.AccountsPage;
import com.apex.ecomm.user.page.LoginPage;



public class ApexBaseTest   {
	
	String browserType = "chrome";
	
	public LoginPage lp;
	public AccountsPage accountsPage;
	
	static  WebDriver driver=null;
	
	@BeforeMethod
	public void setUp() {
		driver = ApexBrowserFactory.getDriver(browserType);
		
		lp = new LoginPage(driver);
		
		
	
	}
	
	@AfterMethod
	
	public void cleanUp()
	{
		driver = null;
		
		
	}

}
