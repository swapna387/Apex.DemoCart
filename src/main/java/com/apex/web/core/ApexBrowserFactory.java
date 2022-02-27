package com.apex.web.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.safari.SafariDriver;

public class ApexBrowserFactory {
	
	static WebDriver driver;
	
	
	public static WebDriver getDriver(String driverType)
	{
		switch(driverType)
		{
		case "chrome": createChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		break;
		
			
		
		case "FF": createFireFoxDriver();
		break;
		
		
		case "safari": createSafariDriver();
		break;
		
			
		}
		
		return driver;
	}


	private static WebDriver createSafariDriver() {
		 return driver = new SafariDriver();
		
	}


	private static WebDriver createFireFoxDriver() {
		
		driver = new FirefoxDriver();
		return driver ;
		
	}


	private static WebDriver createChromeDriver() {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/bvg/downloads/chromedriver");
		driver = new ChromeDriver();
		return driver ;
		

		
	}


	 

}
