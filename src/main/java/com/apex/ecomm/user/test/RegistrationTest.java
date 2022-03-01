package com.apex.ecomm.user.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.ecomm.user.constant.UserConstants;
import com.apex.web.core.ApexBaseTest;
import com.apex.web.core.ApexExcelUtil;

public class RegistrationTest extends ApexBaseTest implements UserConstants {
	
	@BeforeClass
	public void setUpp()
	{
		registrationPage = lp.navigateToRegister();
	}
	
	
	public String generateRandomNumber()

	{
		Random randomGenerator = new Random();
		String email = "testautomation" + randomGenerator.nextInt(10000) + "@gmail.com" ;
		
		return email;
	}
	//testautomation3473@gmail
	@DataProvider
	public Object[][] getRegisterData()
	{
		Object regData[][] = ApexExcelUtil.getData(UserConstants.SHEET_NAME);
		
		return regData;
	}
	
	
	@Test(dataProvider = "getRegisterData")
	public void successRegistrationTest(String firstname, String lastname,String phone, 
			                             String pwd, String subscribe)
	{
		Assert.assertTrue(registrationPage.userRegistration( firstname, lastname, 
				                                           generateRandomNumber(),  phone,  pwd,  
				                                           subscribe));
		
	}

}
