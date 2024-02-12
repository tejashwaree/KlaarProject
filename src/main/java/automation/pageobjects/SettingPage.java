package automation.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class SettingPage {
	public WebDriver driver;
	String str1;
	String str2;
	
	public SettingPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public UserListPage clickSetting() {
		//driver.findElement(By.xpath("//span[normalize-space()='Workspace']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='User List']")).click();
		UserListPage listPage =  new UserListPage(driver);
		return listPage;
	}
	
	public void workspacePage() {
		driver.findElement(By.cssSelector(".anticon-setting")).click();
		Boolean settingPage = driver.findElement(By.xpath("//h2[@data-cy='workspace-settings-heading']")).isDisplayed();
		Assert.assertTrue(settingPage);
		//check functionality
		String workspaceName = "Workspace";
		WebElement  wname = driver.findElement(By.cssSelector("input[placeholder='Organization name']"));
		wname.clear();
		wname.sendKeys(workspaceName);
		driver.findElement(By.cssSelector(".ant-btn-primary:nth-child(1)")).click();
		WebElement profile = driver.findElement(By.cssSelector(".user-name"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(profile));
		profile.click();
		
		String name = driver.findElement(By.xpath("//p[@data-cy='profile-dropdown-user-org-name-field']")).getText().substring(1, 10);
		System.out.println(name);
		System.out.println(workspaceName);

		//Assert.assertEquals(workspaceName,name);
		Assert.assertEquals(name, workspaceName);
	}
	public void changeLogo() throws AWTException, InterruptedException {
		Thread.sleep(2000);
		str1 = driver.findElement(By.xpath("//img[@data-cy='side-menu-logo']")).getAttribute("src");
		Boolean logo = driver.findElement(By.xpath("//h2[@data-cy='settings-workspace-logo-heading']")).isDisplayed();
		Assert.assertTrue(logo);
		driver.findElement(By.cssSelector(".ant-layout-content")).click();
		
		WebElement choosefile = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg ng-star-inserted']"));
		
		Actions a = new Actions(driver);
		a.click(choosefile).build().perform();
//		
		Robot rb = new Robot();
		rb.delay(1000);
		//copy filr to clip board
		StringSelection ss = new StringSelection("C:\\Users\\tejum\\git\\repository\\KlaarProject1\\src\\main\\java\\automation\\AbstarctComponent\\Files\\Logoimage.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.delay(3000);
		//perform cntl + v opr to paste file
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
//		
//		//Runtime.getRuntime();
//		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1000, 1300)");
		WebElement btn = driver.findElement(By.xpath("//p[normalize-space()='Save']"));
		js.executeScript("arguments[0].click();", btn);
	}
	public void checkLogo() throws InterruptedException {
		Thread.sleep(2000);
		String str2 = driver.findElement(By.xpath("//img[@data-cy='side-menu-logo']")).getAttribute("src");
		if (str1 != str2) {
			System.out.println("Logo changed");
		}
		
	}
	
	public void deleteLogo() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(1000, 1300)");
		WebElement btn = driver.findElement(By.cssSelector("button[data-cy='settings-workspace-logo-delete-button'] i"));
		js.executeScript("arguments[0].click();", btn);
		Thread.sleep(2000);
		WebElement btn1 = driver.findElement(By.xpath("//p[normalize-space()='Delete']"));
		js.executeScript("arguments[0].click();", btn1);
		//driver.findElement(By.xpath("//p[normalize-space()='Delete']")).click();
	}
	
}
