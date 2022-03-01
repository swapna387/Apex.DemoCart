package com.apex.ecomm.user.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.apex.ecomm.user.constant.UserConstants;
import com.apex.web.core.ApexWebDriverUtil;

public class RegistrationPage {
	
	
	private By registerLink = By.linkText("Register");
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By phone=By.id("input-telephone");
	private By pwd=By.id("input-password");
	private By confirmpwd=By.id("input-confirm");
	
	private By subscriberNo = By.xpath("//label[@class='radio-inline'][2]");
	private By subscriberYes = By.xpath("//label[@class='radio-inline'][1]");
	private By agreeCheckBox = By.xpath("//input[@name='agree']");
	
	private By continueButton = By.xpath("//input[@type='submit']");
	private By LOGOUT_LINK = By.linkText("Logout");
	
	private By successfulRegistration = By.cssSelector("div#content h1");
	
	private By errorMsgForAlreadyPresentUser = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	private By errorMsgForNotAgreePolicy = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	ApexWebDriverUtil web_Util;
	
	public RegistrationPage(WebDriver driver)
	{
		web_Util = new ApexWebDriverUtil(driver);
	}
	
	
	
	public Boolean userRegistration(String firstName , String lastName , String email, 
			                      String phone, String pwd, String subscribe)
			                      
	{
		web_Util.doSendKeys(this.firstName,firstName);
		web_Util.doSendKeys(this.lastName,lastName);
		web_Util.doSendKeys(this.email,email);
		web_Util.doSendKeys(this.phone,phone);
		web_Util.doSendKeys(this.pwd, pwd);
		web_Util.doSendKeys(confirmpwd, pwd);
		
		
		
		if(subscribe.equals("yes"))
		{
			web_Util.doClick(subscriberYes);
		}else
		{
			web_Util.doClick(subscriberNo);
		}
		
		
		web_Util.doClick(agreeCheckBox);
		
		web_Util.doClick(continueButton);
		
		
		String msg = web_Util.waitForElementVisible(successfulRegistration, 5).getText();
		 
		 if(msg.contains(UserConstants.REGISTRATION_SUCCESMSG))
				 {
			        web_Util.doClick(LOGOUT_LINK);
			        web_Util.doClick(registerLink);
			        
			        return true;
			 
				 }
		 
		 return false;
		 
		 
		 
		 
		
		
		
		
	}
	
	
	

}
