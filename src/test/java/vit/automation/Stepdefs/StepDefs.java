package vit.automation.Stepdefs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Iterators;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vit.automation.core.WebDriverFactory;
import vit.automation.pageobjects.ProductDescriptionPage;
import vit.automation.pageobjects.ProductListingPage;
import vit.automation.pageobjects.landingPageObjects;

public class StepDefs {

	private static final Logger logger = LogManager.getLogger(StepDefs.class);

	WebDriver driver;
	Scenario scn;
	WebDriverWait wait;
	int implicit_wait_timeout_in_sec = 20;
	int SEC = 20;
	String url = "https://www.myntra.com/";

	landingPageObjects landingPageObjects1;
	ProductListingPage productListingPage;
	ProductDescriptionPage productDescriptionPage;

	@Before
	public void setup(Scenario scn) throws Exception {
		this.scn = scn;

		//String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser("edge"); // driver = new ChromeDriver();
		wait = new WebDriverWait(driver, SEC);
		driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
		logger.info("Set webdriver wait in seconds => " + SEC);
		
		landingPageObjects1 = new landingPageObjects(driver, wait);
		productListingPage = new ProductListingPage(driver, wait);
		productDescriptionPage = new ProductDescriptionPage(driver, wait);
		
	}

	@Given("User Navigated to the landing page of the application")
	public void user_navigated_to_the_landing_page_of_the_application() {
		landingPageObjects1.invokedToTheLandinPage(url);
		scn.log("User Navigated to the landing page of the application");
	}

	@When("User search for the product {string}")
	public void user_search_for_the_product(String product) {
		landingPageObjects1.SearchForProduct(product);
		scn.log("User search for the product");
	}

	@Then("search result is displayed {string}")
	public void search_result_is_displayed(String product) {
		productListingPage.SearchProductConfirmation(product);
	}

	@When("User click on any product")
	public void user_click_on_any_product() {
		productListingPage.ClickingOnAnyProduct();
		scn.log("User click on any product");
	}

	@Then("Product Description is displayed in new tab")
	public void product_description_is_displayed_in_new_tab() {

		productDescriptionPage.ProductDescription();
		scn.log("Product Description is displayed in new tab");
	}

	@When("User Search for product {string}")
	public void user_search_for_product(String prod) {
		landingPageObjects1.SearchForProduct(prod);
		scn.log("User search for the product");
	}

	@Then("Search Result page is displayed as {string}")
	public void search_result_page_is_displayed_as(String prod_result) {
		productListingPage.SearchProductConfirmation(prod_result);
		scn.log("Search Result page is displayed as " + prod_result);
	}

	@After(order = 2)
	public void ScreeshotForFailure(Scenario scn) {
		if (scn.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot) driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Failed Step Name: " + scn.getName());
		} else {
			scn.log("Test case is passed, no screen shot captured");
		}
	}

	@After(order = 1)
	public void End() {
		WebDriverFactory.quitDriver();
		logger.info("browser closed");
		scn.log("browser closed successfully");
	}
}
