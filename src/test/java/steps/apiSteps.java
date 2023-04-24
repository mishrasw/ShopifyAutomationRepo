package steps;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IClassListener;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.internal.IConfiguration;
import org.testng.xml.XmlTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.homePage;
import runner.TestRunner;
import utils.apiUtils;

public class apiSteps extends TestRunner {

	private WebDriver driver=super.driver;
	private Logger logger =super.logger;
	private Properties prop = super.prop;
	private apiUtils apiObj = new apiUtils();
	private Response response;

	@Given("^I am sending (.*?) request to (.*?)$")
	public void i_am_sending_the_request_home(String requestType, String endPoint) {

		response = apiObj.getRequestToEndpointUrlToFetchResponse("GET", prop.getProperty("API_Base_URL").toString()+endPoint,"");
		System.out.println("##### response ######"+response.asString());
		logger.info("##### response ######"+response.asString());
	}
	
	@Then("^Verify number of named cars to equal (.*?)$")
	public void verify_number_of_named_cars(int expectedNumber) {

		int numberOfNode = apiObj.getNumberofChildNodes(response,"Subcategories.Name");
		Assert.assertEquals(numberOfNode, expectedNumber);
		logger.info("##### Test Pass ###### Number of Named Cars - "+numberOfNode);
	
	}
	


}
