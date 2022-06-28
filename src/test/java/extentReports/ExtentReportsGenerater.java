//package extentReports;
//
//import java.io.File;
//import java.util.Arrays;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.Markup;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.qa.useinsider.base.ExtentManager;
//
//
//
//public class ExtentReportsGenerater {
//
//	public ExtentTest extentTest;
//	public WebDriver driver;
//	private static ExtentReports extent = ExtentManager.createInstance();
//	//private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
//	
//	
//	@AfterMethod
//	public void afterMethod(ITestResult result) {
//		String methodname = result.getMethod().getMethodName();
//		if (result.getStatus() == ITestResult.FAILURE) {
//			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
//			extentTest.fail("<details><summary><b><font color=red>Exception Occured , click here to see details : "
//					+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>\n");
//			String path = takeScreenshot(driver, result.getMethod().getMethodName());
//			try {
//				extentTest.fail("<b><font color=red>" + "screenshot of failure" + "</font></b>",
//						MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//
//			} catch (Exception e) {
//				extentTest.fail("Test Failed ,cannot attach screenshot");
//			}
//			String logTest = "<b> Test Method " + methodname + " Failed</b>";
//			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.RED);
//			extentTest.log(Status.FAIL, m);
//
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			String logTest = "<br>Test Method" + result.getMethod().getMethodName() + " successful</br>";
//			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
//			extentTest.log(Status.PASS, m);
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			String logTest = "<br>Test Method" + result.getMethod().getMethodName() + " successful</br>";
//			Markup m = MarkupHelper.createLabel(logTest, ExtentColor.YELLOW);
//			extentTest.log(Status.SKIP, m);
//		}
//	}
//	
//	public String takeScreenshot(WebDriver driver, String methodname) {
//		String filename = getScreenshotName(methodname);
//		String directory = System.getProperty("use.dir") + "/screenshots/";
//		new File(directory).mkdirs();
//		String path = directory + filename;
//
//		try {
//			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(screenshot, new File(path));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return path;
//
//	}
//
//	public static String getScreenshotName(String methodName) {
//		Date d = new Date();
//		String filename1 = methodName + "_" + d.toString().replace(":", "_").replace(",", "_") + ".png";
//		return filename1;
//	}
//
//}
