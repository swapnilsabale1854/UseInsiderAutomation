package com.qa.useinsider.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import freemarker.template.SimpleDate;

public class BaseTest {

	public Properties prop;
	public WebDriver driver;
	public WebDriverWait wait;

	public WebDriver browserSetUp() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(new File(
					"C:/Users/Swapnil Sable/eclipse-workspace/UseInsiderAutomation/src/test/java/com/qa/useinsider/utility/config.properties"));
			prop.load(fis);

//			System.setProperty("webdriver.chrome.driver",
//					"C:/Users/Swapnil Sable/Downloads/chromedriver_win32/chromedriver.exe");

			driver = new Driver().getDriver(prop.getProperty("browser"));

			driver.get(prop.getProperty("url"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public boolean verifyElementPresent(WebDriver driver, WebElement element) {

		return element.isDisplayed();
	}

	public void clickOn(WebElement element) {

		element.click();

	}

	public static String getScreenShot(WebDriver driver, String screenshotName) throws Exception {

		String dateName = new SimpleDateFormat("yyyymmddhhss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}

}
