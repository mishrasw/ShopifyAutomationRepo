package runner;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import io.restassured.config.LogConfig;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;






@CucumberOptions(
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src/test/resources/features",  
		glue = "steps"  ,
		tags = "@regression"
		)


public class TestRunner extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public static Properties prop;

	public static Logger logger = LogManager.getLogger(TestRunner.class);
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException {
		
			//REading commong properties
			prop = new Properties();
			prop.load(new FileInputStream(System.getProperty("user.dir")+"\\Enviroment.properties"));
					
			Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.INFO);
			//Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.DEBUG);
			//Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ERROR);
			//Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.WARN);
			

	}
	
	
	@BeforeMethod(alwaysRun = true)  
    public void initiate() throws FileNotFoundException, IOException {		
    	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_win32\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	options.addArguments("--incognito");
    	try {
		driver = new ChromeDriver(options);
    	}catch(Exception e) {
    		
    	}

	}   
   
	
	@AfterMethod(alwaysRun = true)  
    public void drawDown() {
    	driver.close();   	 	
    }

    

    
}
