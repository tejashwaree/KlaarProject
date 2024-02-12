package automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstarctComponent.AbstarctCompoent;

public class LandingPage extends AbstarctCompoent{
	public WebDriver driver;
//	public LandingPage(WebDriver driver) {
//		//initialization
//		super();
//		this.driver = driver;
//		PageFactory.initElements(driver, this); //created this to user driver in findby page factory 
//	}
	@FindBy
	By setting = By.cssSelector(".tw-relative.ng-star-inserted.main_menu button i");
	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public SettingPage loginApplication(String email, String pasword) throws InterruptedException {
		 driver.findElement(By.id("email-field")).sendKeys(email);
			driver.findElement(By.id("password-field")).sendKeys(pasword);
			driver.findElement(By.id("login-btn")).click();
			//waitEleToAppear(setting);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[7]//button[1]//li[1]")).click();
			SettingPage page = new SettingPage(driver);
			return page;
			
	 }
	 public void goTo() {
		 	driver.get("https://dev.klaarhq.com/");
			driver.findElement(By.xpath("//*[@data-cy='login-with-klaar-button']")).click();
		}
	 
}
