package steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IClassListener;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.internal.IConfiguration;
import org.testng.xml.XmlTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import runner.TestRunner;

public class searchSteps extends TestRunner {

	private WebDriver driver=super.driver;
	private Logger logger = super.logger;
	private homePage home = new homePage();

	@Given("^I navigate to website and launch home page$")
	public void i_am_on_the_home_page() throws FileNotFoundException, IOException {
	   home.onHomePage(driver, logger);
	   logger.info("Successfully navigate to home page");
	}
	@When("^I search for (.*)$")
	public void i_search_by_text(String searchString) throws FileNotFoundException, IOException {
	   home.searchOption(driver, searchString);
	   logger.info("Successfully search for option");
	}



}
