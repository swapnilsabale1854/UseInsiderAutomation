package com.qa.useinsider.base;

import java.io.File;
import java.util.Date;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	
	public static ExtentReports createInstance() {
		String filename = getReportName();
		String directory = System.getProperty("use.dir")+"/reports/";
		new File(directory).mkdirs();
		String path = directory + filename;
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(path);
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle("Automation report");
		htmlreporter.config().setReportName("Automation test report");
		htmlreporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization ", "Lets code");
		extent.setSystemInfo("browser", "chrome");
		extent.attachReporter(htmlreporter);
		return extent;

	}

	public static String getReportName() {
		Date d = new Date();
		String filename1 = "AutomationReport_" + d.toString().replace(":", "_").replace(",", "_") + ".html";
		return filename1;
	}
}
