package com.qa.useinsider.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver extends BaseTest {

	WebDriver driver;

	public WebDriver getDriver(String browserType) {
		
		System.out.println("Browser Type :" + browserType);

		switch (browserType) {
		case "chrome":
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.cookies", 2);
			prefs.put("profile.default_content_setting_values.cookies", 2);

			ChromeOptions options = new ChromeOptions();
			/*
			 * to handle notification in selenium
			 */
			options.addArguments("--disable-notifications");
			options.addArguments("start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			break;
		}
		return driver;

	}

}
