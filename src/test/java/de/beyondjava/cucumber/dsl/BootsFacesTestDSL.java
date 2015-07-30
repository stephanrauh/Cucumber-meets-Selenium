package de.beyondjava.cucumber.dsl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.beyondjava.cucumber.base.DriverFactory;

/**
 * This class implements the cucumber DSL needed to test BootsFaces.
 * 
 * @author Stephan Rauh, http://www.beyondjava.net
 */
public class BootsFacesTestDSL {

	private final WebDriver driver = DriverFactory.createHtmlUnitInstance();
	
	@Given("^I am on the BootsFaces start page$")
	public void i_am_on_the_BootsFaces_start_page() throws Throwable {
		driver.get("http://www.bootsfaces.net");
	}

	@Then("^I can download BootsFaces$")
	public void the_I_can_download_BootsFaces() throws Throwable {
		WebElement greenButton = driver.findElement(By.className("btn-success"));
		HtmlUnitWebElement innerSpan = (HtmlUnitWebElement) greenButton.findElement(By.tagName("span"));
		Assert.assertNotNull(innerSpan);
		System.out.println("Download button found");
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
