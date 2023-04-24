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
import pages.loginPage;
import runner.TestRunner;

public class loginSteps extends TestRunner {

	private WebDriver driver=super.driver;
	private Logger logger = super.logger;
	private loginPage login = new loginPage();

	@When("^I login to shopify website$")
	public void i_search_by_text() throws FileNotFoundException, IOException {
		login.loginShopifyWebsite(driver);
	   logger.info("Successfully search for option");
	}



}
