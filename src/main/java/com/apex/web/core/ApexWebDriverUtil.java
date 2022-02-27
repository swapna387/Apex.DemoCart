package com.apex.web.core;


	
	
	

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	

	public class ApexWebDriverUtil   {
		
		
		
		private WebDriver driver;
		
		public ApexWebDriverUtil(WebDriver driver)
		{
			this.driver = driver;
		}


		 


		public  WebElement getElement(By locator)
		{
			return driver.findElement(locator);
		}
		
		
		public  void doSendKeys(By locator , String data)
		{
			getElement(locator).sendKeys(data);
			
		}
		
		
		
		public  void doClick(By locator)
		{
			getElement(locator).click();
		}
		
		public  String titleOfPage()
		{
			return driver.getTitle();
		}
		
		
		public  String doGetText(By locator)
		{
			return getElement(locator).getText();
		}

	}



