package extentReports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportsGenerater {

	ExtentReports report;
	ExtentTest test;
	WebDriver driver;

	public void startReport() {

		report = new ExtentReports();

	}

}
