package de.beyondjava.cucumber.base;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Selenium can use various browsers to run the test. This factory provides a
 * common interface to create them.
 */
public class DriverFactory {

	private static final String WEBDRIVER_IE_DRIVER_KEY = "webdriver.ie.driver";
	private static final String DEFAULT_IE_PATH = "C:/jenkins/IEDriverServer.exe";

	public static InternetExplorerDriver createIEDriverInstance() {
		String iePath = System.getProperty(WEBDRIVER_IE_DRIVER_KEY);
		if (iePath == null || iePath.isEmpty()) {
			if (new File(DEFAULT_IE_PATH).exists()) {
				System.setProperty(WEBDRIVER_IE_DRIVER_KEY, DEFAULT_IE_PATH);
			} else {
				System.out.println("Please download the IE driver file first and put it into the folder C:/jenkins.");
				System.out.println("Alternatively, you can put the driver file into an arbitrary folder.");
				System.out.println(
						"In this case, start the java application with the parameter -Dwebdriver.ie.driver=<qualified file name>.");
			}
		}

		InternetExplorerDriver ieDriver = null;
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCapabilities.setJavascriptEnabled(true);

		ieDriver = new InternetExplorerDriver(ieCapabilities);
		return ieDriver;
	}

	public static FirefoxDriver createFirefoxInstance() {
		FirefoxDriver ieDriver = null;
		ieDriver = new FirefoxDriver();
		return ieDriver;
	}

	public static HtmlUnitDriver createHtmlUnitInstance() {
		HtmlUnitDriver ieDriver = null;
		ieDriver = new HtmlUnitDriver(true);
		return ieDriver;
	}

}
