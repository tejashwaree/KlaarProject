package automation.TestComponent;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import automation.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializedriver() {
		
	
	driver = WebDriverManager.chromedriver().create();
	driver.manage().window().maximize();
	//implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	
	
	public LandingPage launchApplication() {
		driver= initializedriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
