package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {
	
	protected WebDriver driver;

	private By logoLink = By.xpath("//h1[@class='header__heading']");
	private By searchButton = By.xpath("//details-modal[@class='header__search']");
	
	private By searchInputField = By.xpath("//input[@id='Search-In-Modal']");
	private By searchSubmit = By.xpath("//button[@class='search__button field__button']");
	private By searchHeader = By.xpath("//h1[contains(.,'Search results')]");
	private By notFoundText = By.xpath("//p[contains(.,'No results found for ')]");
	
	
	
	
	public void onHomePage(WebDriver driver, Logger logger) throws FileNotFoundException, IOException {
		this.driver = driver;
		Properties propVal = new Properties();
		propVal.load(new FileInputStream(System.getProperty("user.dir")+"\\Enviroment.properties"));
		driver.get(propVal.getProperty("AUT_URL").toString());
		logger.info("Launching URL - "+propVal.getProperty("AUT_URL").toString());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 	
		WebElement headerLogo = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(logoLink));
	}
	
	public void searchOption(WebDriver driver, String searchInput) {
		this.driver = driver;
		driver.findElement(searchButton).click();
		//WebElement motorlinkElement = new WebDriverWait(driver, Duration.ofSeconds(10))
		        //.until(ExpectedConditions.elementToBeClickable(searchSubmit));
		driver.findElement(searchInputField).sendKeys(searchInput);
		driver.findElement(searchSubmit).click();
		WebElement headerLogo = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(searchHeader));
		
	}
	
	public void invalidSearchOption(WebDriver driver, String searchInput) {
		this.driver = driver;
		driver.findElement(searchButton).click();
		//WebElement motorlinkElement = new WebDriverWait(driver, Duration.ofSeconds(10))
		        //.until(ExpectedConditions.elementToBeClickable(searchSubmit));
		driver.findElement(searchInputField).sendKeys(searchInput);
		driver.findElement(searchSubmit).click();
		WebElement invalidSearchParagraph = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(notFoundText));
		
	}
	
	public void searchAndOpenItems(WebDriver driver, String searchInput) {
		this.driver = driver;
		driver.findElement(searchButton).click();
		//WebElement motorlinkElement = new WebDriverWait(driver, Duration.ofSeconds(10))
		        //.until(ExpectedConditions.elementToBeClickable(searchSubmit));
		driver.findElement(searchInputField).sendKeys(searchInput);
		driver.findElement(searchSubmit).click();
		WebElement headerLogo = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(searchHeader));
		driver.findElement(By.xpath("(//a[contains(.,'"+searchInput+"')])[2]")).click();
		
	}
	
}
