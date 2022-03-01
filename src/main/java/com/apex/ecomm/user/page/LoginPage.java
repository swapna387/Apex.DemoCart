package com.apex.ecomm.user.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apex.ecomm.user.constant.UserConstants;
import com.apex.web.core.ApexBasePage;
import com.apex.web.core.ApexWebDriverUtil;



public class LoginPage   {

	public By EMAIL_LOCATOR = By.id("input-email");

	private By PASSWORD_LOCATOR = By.id("input-password");

	private By LOGIN_BTN_LOCATOR = By.xpath("//input[@type='submit']");

	private By ERROR_MSG = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	private By FORGOTPASSWORD_LINK = By.linkText("Forgotten Password");

	private By LOGOUT_LINK = By.linkText("Logout");

	private By REGISTER_LINK = By.linkText("Register");

	private WebDriver driver;
	ApexWebDriverUtil web_Util;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		web_Util = new ApexWebDriverUtil(driver);
		
	}
	
	public String doGetText()
	{
		return web_Util.doGetText(ERROR_MSG);
	}
	
	
	public ForgotYourPasswordPage doClick()
	{
		 web_Util.doClick(FORGOTPASSWORD_LINK);
		 
		 return new ForgotYourPasswordPage(driver);
	}
	
	
	public AccountsPage doLogin(String un, String pwd)
	{
		web_Util.doSendKeys(EMAIL_LOCATOR, un);
		web_Util.doSendKeys(PASSWORD_LOCATOR,pwd);
		web_Util.doClick(LOGIN_BTN_LOCATOR);
		
		return new AccountsPage(driver);
		
	}
		
		public RegistrationPage navigateToRegister()
		{
			web_Util.doClick(REGISTER_LINK);
			
			return new RegistrationPage(driver);
		}
		
		
		
	

}
