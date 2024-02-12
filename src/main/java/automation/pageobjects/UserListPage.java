package automation.pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.AbstarctComponent.AbstarctCompoent;
import junit.framework.Assert;

public class UserListPage extends AbstarctCompoent{
	
public WebDriver driver;
Random random = new Random();
String firstName1 ;
String name;
	
	public UserListPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void checkAllUserTab() {
		String allUser = driver.findElement(By.xpath("//*[@class='ant-tabs-tab-btn' and @tabindex='0']")).getAttribute("aria-selected");
		if (allUser== "true"){
			Assert.assertTrue(true);
		}
	}
	
	public void addUser() {
		driver.findElement(By.cssSelector(".tw-pr-4 button:nth-of-type(3)")).click();
		driver.findElement(By.cssSelector(".anticon-user-add")).click();
		
	}
	
	public void addUserDetails() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='e.g. Alex Richards']")).sendKeys(generateName());
		driver.findElement(By.xpath("//input[@placeholder='e.g. alex@example.com']")).sendKeys(email()+ "@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//nz-select-placeholder[.=' Enter department here ']/parent::nz-select-top-control//input")).sendKeys("Engineering");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Engineering')]")).click();
	
		driver.findElement(By.xpath("//nz-select-placeholder[.=' Enter title here ']/parent::nz-select-top-control//input")).sendKeys("QA");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(text(),'QA')])[1]")).click();		
		
		//nz-select[@formcontrolname='manager_email']//i[@nztype='down']//*[name()='svg']
		driver.findElement(By.xpath("//nz-select[@formcontrolname='manager_email']//i[@nztype='down']//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.='Akshay (akshayxyz@gmail.com)']")).click();
		int id = random.nextInt(25);
		String st = String.valueOf(id);
		//add user id
		driver.findElement(By.xpath("//input[@placeholder='Enter employee id here']")).sendKeys(st);
		driver.findElement(By.xpath("//input[@placeholder='Enter location here']")).sendKeys("Pune");
		//nz-select[@formcontrolname='hrbp_email']//i[@nztype='down']//*[name()='svg']
		driver.findElement(By.xpath("//nz-select[@formcontrolname='hrbp_email']//i[@nztype='down']//*[name()='svg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[normalize-space()='Akash Davad (akkidavada@gmail.com)'])[1]")).click();
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1300, 1000)");
		WebElement btn = driver.findElement(By.xpath("//span[contains(text(),'Add Now')]"));
		js.executeScript("arguments[0].click();", btn);

	}
	public String generateName() {
		String[] firstName = {"Sima","Neha","Priya","Rani","Soni"};
		String[] lastName = {"Roy","Singh","Menan","Milkha","Lamba"};
		firstName1 = firstName[random.nextInt(firstName.length)];
		name = firstName1  +" " +lastName[random.nextInt(lastName.length)];
		
		return name;
	}
	
	public String email() {
		int val = random.nextInt(234);
		String email = firstName1.toLowerCase()+ String.valueOf(val);
		return email;
	}
	
	public void editUser() {
		String lable = driver.findElement(By.xpath("//div[contains(text(),'Personal')]")).getText();
		System.out.println(lable);
		Assert.assertEquals(lable, "Personal");
		
	}
	
	public void back() {
		driver.findElement(By.xpath("//i[@nztype='arrow-left']")).click();
	}
	
	public void checkUserName() throws InterruptedException {
		driver.findElement(By.cssSelector(".search-container input")).sendKeys(name);
		Thread.sleep(2000);
		String userName = driver.findElement(By.xpath("(//td[@data-cy='user-list-user-email-field']//span)[2]")).getText();
		Assert.assertEquals(name, userName);
	}
	
	public void customFieldDate() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@role='tab'])[3]")).click();
		driver.findElement(By.xpath("//span[@class='anticon anticon-plus']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter field name...']")).sendKeys("CDate");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ant-select-selection-search-input")).sendKeys("Date");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='ant-tabs-tab-btn'])[1]")).click();
		driver.findElement(By.xpath("(//td[@data-cy='user-list-user-email-field']//span)[2]")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'Company')])[1]")).click();
		List<WebElement> list = driver.findElements(By.cssSelector(".ant-row form"));
		for (int i =0; i<list.size();i++) {
			if (list.get(i).getText()=="CDate"){
				Assert.assertTrue(true);	
			}
			
		}
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1000, 1300)");
		WebElement btn = driver.findElement(By.xpath("(//nz-date-picker/div/input[@placeholder='Select date'])[6]"));
		js.executeScript("arguments[0].click();", btn);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//nz-date-picker/div/input[@placeholder='Select date'])[6]")).sendKeys("2024-05-29");
//		Thread.sleep(2000);
//		try {
//			driver.findElement(By.cssSelector(".ant-picker-header-next-btn")).click();
//		}
//		catch(StaleElementReferenceException e) {
//			driver.findElement(By.cssSelector(".ant-picker-header-next-btn")).click();
//		}
		
		Thread.sleep(4000);
		//driver.findElement(By.xpath("(//div[@aria-selected='false'])[20]")).click();
		WebElement btn1 = driver.findElement(By.xpath("//span[@class='ng-star-inserted']"));
		js.executeScript("arguments[0].click();", btn1);
		//driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();
	}
	
	public void customFieldList() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@role='tab'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='anticon anticon-plus']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter field name...']")).sendKeys("CList");
		driver.findElement(By.cssSelector(".ant-select-selection-search-input")).sendKeys("List");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ant-select-item-option-content")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Add another Item']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Add another Item']")).click();
		String city = "Pune";
		driver.findElement(By.xpath("(//input[@placeholder='Option List'])[1]")).sendKeys("Pune");
		driver.findElement(By.xpath("(//input[@placeholder='Option List'])[2]")).sendKeys("Mumbai");
		driver.findElement(By.xpath("(//input[@placeholder='Option List'])[3]")).sendKeys("Goa");
		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='ant-tabs-tab-btn'])[1]")).click();
		driver.findElement(By.xpath("(//td[@data-cy='user-list-user-email-field']//span)[2]")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'Company')])[1]")).click();
		List<WebElement> list = driver.findElements(By.cssSelector(".ant-row form"));
		for (int i =0; i<list.size();i++) {
			if (list.get(i).getText()=="CList"){
				Assert.assertTrue(true);	
			}
			
		}
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement btn1 = driver.findElement(By.xpath("(//nz-select-search[@class='ant-select-selection-search ng-star-inserted'])[6]/input"));
		js.executeScript("arguments[0].click();", btn1);
		//driver.findElement(By.xpath("//nz-select-placeholder[normalize-space()='Select CList here']")).click();
		driver.findElement(By.xpath("(//nz-select-search[@class='ant-select-selection-search ng-star-inserted'])[6]/input")).sendKeys(city);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[1]")).click();
		Thread.sleep(4000);
		WebElement btn2 = driver.findElement(By.xpath("//span[@class='ng-star-inserted']"));
		js.executeScript("arguments[0].click();", btn2);
		//driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();
	}
	
	public void toggleField() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@role='tab'])[3]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		//boolean msg = driver.findElement(By.cssSelector(".toast-message")).isDisplayed();
		//Assert.assertTrue(msg);
	}
	
	public void verifyCustomField() {
		driver.findElement(By.xpath("(//*[@class='ant-tabs-tab-btn'])[1]")).click();
		driver.findElement(By.xpath("(//td[@data-cy='user-list-user-email-field']//span)[2]")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'Company')])[1]")).click();
		List<WebElement> list = driver.findElements(By.cssSelector(".ant-row form"));
		for (int i =0; i<list.size();i++) {
			if (list.get(i).getText()!="CDate"){
				Assert.assertTrue(true);	
			}
			if(list.get(i).getText()!="CList") {
				
			Assert.assertTrue(true);
			}
		}
	}
	
	public void deleteCustomeField() throws InterruptedException {
		driver.findElement(By.xpath("(//div[@role='tab'])[3]")).click();
		driver.findElement(By.xpath("(//div[@class='ant-col']/span)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='ant-col']/span)[1]")).click();
		boolean msg = driver.findElement(By.cssSelector(".toast-message")).isDisplayed();
		Assert.assertTrue(msg);
	}
}
