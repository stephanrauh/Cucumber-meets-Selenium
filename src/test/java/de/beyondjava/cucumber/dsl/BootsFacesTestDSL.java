package de.beyondjava.cucumber.dsl;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitWebElement;

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
	// private final WebDriver driver = DriverFactory.createFirefoxInstance();

	@Given("^I am on the BootsFaces start page$")
	public void i_am_on_the_BootsFaces_start_page() {
		driver.get("http://127.0.0.1:8080/BootsFacesWeb/");
		// driver.get("http://www.bootsfaces.net");
	}

	@Then("^I can download BootsFaces$")
	public void then_I_can_download_BootsFaces() throws Throwable {
		WebElement greenButton = driver.findElement(By.className("btn-success"));
		HtmlUnitWebElement innerSpan = (HtmlUnitWebElement) greenButton.findElement(By.tagName("span"));
		Assert.assertNotNull(innerSpan);
		System.out.println("Download button found");
	}

	@When("^I navigate to \"([^\"]*)\" / \"([^\"]*)\"$")
	public void navigateToMenu(String menu, String submenu) {
		WebElement menuToggle = driver.findElement(By.cssSelector(".navbar-toggle"));
		menuToggle.click();

		WebElement menuElement = findMenu(driver.findElement(By.tagName("body")), menu);
		Assert.assertNotNull("Couldn't find menu " + menu, menuElement);
		menuElement.click();
		WebElement submenuElement = findMenu(menuElement, submenu);
		Assert.assertNotNull("Couldn't find submenu " + submenu, submenuElement);
		submenuElement.click();
	}

	private WebElement findMenu(WebElement parent, String menu) {
		return parent.findElement(By.xpath("//a[contains(.,'" + menu + "')]"));
	}

	@Then("^I can read \"([^\"]*)\"$")
	public void checkWhetherTextIsPresent(String text) {
		WebElement textElement = driver.findElement(By.xpath("//p[contains(.,'" + text + "')]"));
		Assert.assertNotNull("The expected text is missing: " + text, textElement);
	}

	@Then("^the page contents equals \"([^\"]*)\"$")
	public void the_page_contents_equals(String filename) throws Throwable {
		List<WebElement> elementUnderTest = driver.findElements(By.className("contentToTest"));
		if (null != elementUnderTest && elementUnderTest.size()==1) {
		String content = WebDriverUtils.extractInnerHTML(driver, elementUnderTest.get(0));
		content=WebDriverUtils.removeVariableStuff(content);
		if (new File("src/test/resources/recordedTestResults/" + filename).exists()) {
			String original = WebDriverUtils.read("src/test/resources/recordedTestResults/" + filename);
			Assert.assertEquals("The generated HTML code differs from the recorded HTML code.", original, content);
		} else {
			WebDriverUtils.write("src/test/resources/recordedTestResults/" + filename, content);
		}
		}
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
