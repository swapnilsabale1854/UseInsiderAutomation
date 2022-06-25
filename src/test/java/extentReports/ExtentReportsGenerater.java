package extentReports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportsGenerater {	

	public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public void startReport() {

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Swapnil sable ","Use Insider Automation");
		extent.setSystemInfo("Envirnment=> Automation", "Staging");
		htmlreporter.config().setDocumentTitle("Test report of Automation => use Insider");
		htmlreporter.config().setTheme(Theme.DARK);
		
		
	}

}
