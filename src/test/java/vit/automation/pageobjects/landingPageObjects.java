package vit.automation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class landingPageObjects {

	private static final Logger logger = LogManager.getLogger(landingPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	
	private By SearchBOX = By.xpath("//input[@class='desktop-searchBar']");
	private By SearchBTN = By.xpath("//a[@class='desktop-submit']");
	public landingPageObjects(WebDriver driver , WebDriverWait wait) {
		this.driver=driver;
		this .wait=wait;
	}
	
	public void SearchForProduct(String product) {
		driver.findElement(SearchBOX).sendKeys(product);
		logger.info("Sending the keys into the search box");
		wait.until(ExpectedConditions.elementToBeClickable(SearchBTN));
		driver.findElement(SearchBTN).click();
		logger.info("clicking on the search BTN");
	}
	 	
	public void invokedToTheLandinPage(String url) {
	driver.get(url);
	logger.info("invoked the URL => " + url);
	String Expected = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
	String Actual = driver.getTitle();
	wait.until(ExpectedConditions.titleIs(Expected));
	logger.info("waiting for the title confirmation");
	Assert.assertEquals(Expected, Actual);
	logger.info("title confirmed");
	
	}
	
	
}
