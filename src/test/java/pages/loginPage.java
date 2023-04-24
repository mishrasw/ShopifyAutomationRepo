package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
protected WebDriver driver;
	
	private By userButton = By.xpath("//a[@class='header__icon header__icon--account link focus-inset']");
	private By emailField = By.xpath("//input[@id='CustomerEmail']");
	private By passwordField = By.xpath("//input[@id='CustomerPassword']");
	private By loginButton = By.xpath("//button[@class='button--primary login-btn']");
	private By accountLoginLable = By.xpath("//h2[.='Account details']");
	
	
	
	public void loginShopifyWebsite(WebDriver driver)  {
		this.driver = driver;
		driver.findElement(userButton).click();;
		new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(emailField));
		driver.findElement(emailField).sendKeys("mishra.swarup@gmail.com");
		driver.findElement(passwordField).sendKeys("Test@123");
		driver.findElement(loginButton).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(accountLoginLable));

	}
}
