package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qa.useinsider.base.BaseTest;
import com.qa.useinsider.pages.CareerPage;
import com.qa.useinsider.pages.Homepage;

public class UseInsider extends BaseTest{


	public  Homepage home;
	@Test
	public void openBrowser() throws Exception
	{
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
		
		

	}
	
	
 
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
}
