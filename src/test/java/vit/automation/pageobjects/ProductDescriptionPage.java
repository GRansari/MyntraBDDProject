package vit.automation.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDescriptionPage {

	
	private static final Logger logger = LogManager.getLogger(landingPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductDescriptionPage(WebDriver driver , WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}
	
	public void ProductDescription() {
		Set<String> handle =  driver.getWindowHandles();// get all the open windows
	     Iterator<String> it = handle.iterator(); // get the iterator to iterate the elements in set
	     String parent = it.next();
	     String child1= it.next();      
	     driver.switchTo().window(child1); 
	     logger.info("driver swiched to the chaild window");
	     WebElement AddToCartBTN = driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']"));
        Assert.assertEquals(true, AddToCartBTN.isDisplayed());
        logger.info("add to the cart button is displayed");
        driver.switchTo().window(parent);
        logger.info("Swichted back to the parent window");
	}
}
