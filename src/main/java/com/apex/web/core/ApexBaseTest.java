package com.apex.web.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.apex.ecomm.user.page.AccountsPage;
import com.apex.ecomm.user.page.LoginPage;
import com.apex.ecomm.user.page.RegistrationPage;



public class ApexBaseTest   {
	
	String browserType = "chrome";
	
	public LoginPage lp;
	public AccountsPage accountsPage;
	public RegistrationPage registrationPage;
	
	static  WebDriver driver=null;
	
	@BeforeTest
	public void setUp() {
		driver = ApexBrowserFactory.getDriver(browserType);
		
		lp = new LoginPage(driver);
		
		
	
	}
	
	@AfterTest
	
	public void cleanUp()
	{
		driver = null;
		
		
	}

}
