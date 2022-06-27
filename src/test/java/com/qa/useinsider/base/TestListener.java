package com.qa.useinsider.base;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import Tests.UseInsider;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "::" + result.getMethod().getMethodName());

		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String logTest = "<br>Test Method" + result.getMethod().getMethodName() + " successful</br>";
		Markup m = MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

		extentTest.get().fail("<details><summary><b><font color=red>Exception Occured , click here to see details : "
				+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>\n");

		WebDriver driver = ((UseInsider) result.getInstance()).driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());

		try {
			extentTest.get().fail("<b><font color=red>" + "screenshot of failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} catch (Exception e) {
			extentTest.get().fail("Test Failed ,cannot attach screenshot");
		}

		String logTest = "<b> Test Method " + methodname + " Failed</b>";
		Markup m = MarkupHelper.createLabel(logTest, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		String logTest = "<br>Test Method" + result.getMethod().getMethodName() + " successful</br>";
		Markup m = MarkupHelper.createLabel(logTest, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}
	}

	public String takeScreenshot(WebDriver driver, String methodname) {
		String filename = getScreenshotName(methodname);
		String directory = System.getProperty("use.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + filename;

		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;

	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String filename1 = methodName + "_" + d.toString().replace(":", "_").replace(",", "_") + ".png";
		return filename1;
	}

}
