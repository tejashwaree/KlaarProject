package automationTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import automation.TestComponent.BaseClass;
import automation.pageobjects.LandingPage;
import automation.pageobjects.SettingPage;
import automation.pageobjects.UserListPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserCustomeField extends BaseClass{
	@Test
	public void UserCustomeField() throws InterruptedException {
	launchApplication();
	LandingPage landingPage = new LandingPage(driver);
	SettingPage page = landingPage.loginApplication("deepa.nayak@gamma.klaar.team", "Klaar2021");
	page.clickSetting();
	UserListPage listPage = new UserListPage(driver);
	listPage.customFieldDate();
	listPage.back();
	listPage.customFieldList();
	listPage.back();
	listPage.toggleField();
	listPage.verifyCustomField();
	listPage.back();
	listPage.deleteCustomeField();
	listPage.verifyCustomField();
	tearDown();
}
}