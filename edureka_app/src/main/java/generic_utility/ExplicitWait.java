package generic_utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	

	    WebDriverWait wait;

	    public ExplicitWait(WebDriver driver) {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    public void waitForElementToBeVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementToBeClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public void waitForElementToBeInvisible(WebElement element) {
	        wait.until(ExpectedConditions.invisibilityOf(element));
	    }
	

}
