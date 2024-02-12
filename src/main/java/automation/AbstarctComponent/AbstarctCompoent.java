package automation.AbstarctComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstarctCompoent {

WebDriver driver;



	public void AbstarctComponent(WebDriver driver) 
	{
		this.driver = driver;
	}
	 public void waitEleToAppear(By webElement) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
	 }
	
}
