package automationTest;

import java.time.Duration;

import org.checkerframework.checker.regex.qual.Regex;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.TestComponent.BaseClass;
import automation.pageobjects.LandingPage;
import automation.pageobjects.SettingPage;
import automation.pageobjects.UserListPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class AddNewUser extends BaseClass{
	@Test
	public  void addNewUser() throws InterruptedException {
		launchApplication();
		LandingPage landingPage = new LandingPage(driver);
		SettingPage page = landingPage.loginApplication("deepa.nayak@gamma.klaar.team", "Klaar2021");
		page.clickSetting();
		UserListPage listPage = new UserListPage(driver);
		listPage.checkAllUserTab();
		listPage.addUser();
		listPage.addUserDetails();
		listPage.editUser();
		listPage.back();
		listPage.checkUserName();
		tearDown();
		
	}
}
