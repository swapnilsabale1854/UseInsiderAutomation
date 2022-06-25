package com.qa.useinsider.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.useinsider.base.BaseTest;

public class Homepage extends BaseTest{
	

	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link btn btn-navy rounded text-nowrap']")
	public WebElement getDemoButtom;
	
	@FindBy(xpath = "(//a[@id='mega-menu-1'])[6]")
	public WebElement Menu;

	@FindBy(xpath = "//a[@id='wt-cli-accept-btn']")
	public WebElement rejectCookies;
	
	@FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
	public WebElement acceptCookies;
	
	@FindBy(xpath = "//h5[contains(text(),'Careers')]")
	public WebElement career;
	

	}
