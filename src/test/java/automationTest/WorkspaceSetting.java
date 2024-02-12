package automationTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import automation.TestComponent.BaseClass;
import automation.pageobjects.LandingPage;
import automation.pageobjects.SettingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class WorkspaceSetting extends BaseClass{
	
	@SuppressWarnings("deprecation")
	@Test
	public  void workspacrSetting() throws AWTException, IOException, InterruptedException {
		launchApplication();
		LandingPage landingPage = new LandingPage(driver);
		SettingPage page = landingPage.loginApplication("deepa.nayak@gamma.klaar.team", "Klaar2021");
		page.workspacePage();
		page.changeLogo();
		page.checkLogo();
		page.deleteLogo();
		
	}
	 
}
