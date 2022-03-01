package com.apex.ecomm.search.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.apex.ecomm.order.page.ProductDetailsPage;
import com.apex.web.core.ApexWebDriverUtil;

public class SearchPage {

	private WebDriver driver;

	private ApexWebDriverUtil web_Util;

	private By productCount = By.xpath("//div[@class='product-thumb']");
	private By selectProduct = By.xpath("//div[@class='product-thumb']//h4/a");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		web_Util = new ApexWebDriverUtil(driver);
	}

	public int getProductCount() {
		return web_Util.getElements(productCount).size();
	}

	public ProductDetailsPage selectProductFromResult(String productName) {
		List<WebElement> productListElem = web_Util.getElements(selectProduct);

		System.out.println("the total number of items for " + productName + " " + productListElem.size());

		for (WebElement e : productListElem) {

			if (e.getText().equals(productName)) {

				System.out.println("the product selected is : " + e.getText());

				e.click();
				break;
			}
		}

		return new ProductDetailsPage(driver);
	}

}
