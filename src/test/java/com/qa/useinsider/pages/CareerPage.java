package com.qa.useinsider.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.useinsider.base.BaseTest;

public class CareerPage extends BaseTest{

	public CareerPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
	public WebElement acceptCookies;
	
}
