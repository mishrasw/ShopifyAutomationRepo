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
import org.testng.Assert;

public class itemsPage {
	
	protected WebDriver driver;

	private By productTitle = By.xpath("//div[@class='product__title']");
	private By addToCartBtn = By.xpath("(//button[contains(.,'Add to cart')])[1]");
	
	private By cartDrawerHeader = By.cssSelector("div.drawer__header");
	private By btnDrawerClose = By.cssSelector("button.drawer__close");
	private By addToCartItem = By.xpath("//td[@class='cart-item__details']/a");
	private By numberOfItems = By.xpath("//div[@class='quty-div']//input");
	
	
	
	
	public void addToCart(WebDriver driver, String searchString) throws FileNotFoundException, IOException {
		this.driver = driver;		
		WebElement productTitleHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(productTitle));
		System.out.println("Product Page Displayed Successfully - "+productTitleHeader.findElement(By.xpath("//h1")).getText());
		driver.findElement(addToCartBtn).click();
		WebElement addCartDrawerHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(cartDrawerHeader));
		Assert.assertEquals(searchString, driver.findElement(addToCartItem).getText().trim());
		Assert.assertEquals("1", driver.findElement(numberOfItems).getAttribute("value").trim());
		driver.findElement(btnDrawerClose).click();
	}

}
