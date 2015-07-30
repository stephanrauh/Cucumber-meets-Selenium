package de.beyondjava.cucumber.dsl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.beyondjava.cucumber.base.DriverFactory;

/**
 * While cucumbers with cheese don't sounds tasty to me, it's the default
 * example of both the Selenium and the Cucumber project pages.
 * Note that this example is very slow - probably due to the JavaScript code 
 * the Google search engine executes on every key stroke.
 * 
 * @author Stephan Rauh, http://www.beyondjava.net
 */
public class CucumberMeetsCheese {
//
//	private final WebDriver driver = DriverFactory.createIEDriverInstance();
//
//	@Given("^I am on the Google search page$")
//	public void visitGoogle() {
//		driver.get("http://www.google.de");
//	}
//
//	@When("^I search for \"(.*)\"$")
//	public void searchFor(String what) {
//		WebElement element = driver.findElement(By.name("q"));
//		element.sendKeys(what);
//		element.submit();
//	}
//
//	@Then("^The page title should start with \"(.*)\"$")
//	public void checkTitle(final String what) {
//		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
//
//			@Override
//			public Boolean apply(WebDriver driver) {
//
//				return driver.getTitle().toLowerCase().startsWith(what.toLowerCase());
//			}
//		});
//		Assert.assertTrue(driver.getTitle().startsWith(what));
//	}
//
//	@After
//	public void closeBrowser() {
//		driver.quit();
//	}
}
