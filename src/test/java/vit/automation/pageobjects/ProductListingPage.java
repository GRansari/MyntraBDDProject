package vit.automation.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage {

	private static final Logger logger = LogManager.getLogger(landingPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductListingPage(WebDriver driver , WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}
	
	private By listOgKurtis = By.xpath("//ul[@class='results-base']//li");
	private By   Expected   = By.xpath("//div[@class='title-container']//h1");
	
	public void ClickingOnAnyProduct() {
		List<WebElement> a = driver.findElements(listOgKurtis);
    	logger.info("getting the list of all search results");
    	 a.get(0).click();
    	logger.info("clicked on one of the product from the list");
	}
	public void SearchProductConfirmation(String product) {
		
		Assert.assertEquals(product,driver.findElement(Expected).getText());
		logger.info("search result is displayed successfully");
	}
}
