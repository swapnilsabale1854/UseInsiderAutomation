package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qa.useinsider.base.BaseTest;
import com.qa.useinsider.pages.CareerPage;
import com.qa.useinsider.pages.Homepage;

public class TestClassUsingListeners extends BaseTest{

	public Homepage home;
	@Test
	public void passTestCase() throws Exception {
		
		WebDriver driver=browserSetUp();
		System.out.println("open browser");
		home = new Homepage(driver);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		clickOn(home.acceptCookies);
		clickOn(home.Menu);
		Assert.assertEquals(prop.getProperty("HomePageTitle"),driver.getTitle());
		Thread.sleep(2000);
		clickOn(home.career);
		CareerPage career = new CareerPage();
		System.out.println("pass test");
		
	}
	
	@Test
	public void failTestCase() {
		System.out.println("fail  test");
		Assert.fail();
		
	}
	
	@Test
	public void skipTestCase() {
		System.out.println("skip test");
		throw new SkipException("skipped");
		
	}
	
}
