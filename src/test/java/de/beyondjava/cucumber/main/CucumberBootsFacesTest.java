package de.beyondjava.cucumber.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This class make the Cucumber test suite available to JUnit. Run this class as a JUnit test
 * to run every Cucumber test in the BootsFaces test folder.
 * @author Stephan Rauh, http://www.beyondjava.net Rauh, http://www.beyondjava.net
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/BootsFaces",
glue={"de.beyondjava.cucumber.dsl"})
public class CucumberBootsFacesTest {

}
