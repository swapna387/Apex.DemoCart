package com.apex.web.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApexWebDriverUtil {

	private WebDriver driver;

	public ApexWebDriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String data) {
		getElement(locator).sendKeys(data);

	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String titleOfPage() {
		return driver.getTitle();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	
	
	public void doSelectValueByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	
	
	public String waitForTitle(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();

	}

}
