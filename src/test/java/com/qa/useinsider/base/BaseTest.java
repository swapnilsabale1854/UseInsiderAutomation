package com.qa.useinsider.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public Properties prop;
	public WebDriver driver;

	public WebDriver browserSetUp() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(new File(
					"C:/Users/Swapnil Sable/eclipse-workspace/UseInsiderAutomation/src/test/java/com/qa/useinsider/utility/config.properties"));
			prop.load(fis);

			/*
			 * to handle notification in selenium
			 */
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.cookies", 2);
			prefs.put("profile.default_content_setting_values.cookies", 2);
			

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			//options.setExperimentalOption("prefs", prefs);
		

			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Swapnil Sable/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public boolean verifyElementPresent(WebDriver driver, WebElement element) {
		
		return element.isDisplayed();
	}
	
	public void acceptCookies(WebDriver driver,WebElement element) throws InterruptedException
	{
		
	}

}
