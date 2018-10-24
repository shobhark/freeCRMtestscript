package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Loginpage extends TestBase{
	
	HomePage homePage;
	
	//Page factory ------OR(object repository)
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@class = 'btn btn-small']")
	WebElement loginBtn;

	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li[2]")
	WebElement signUpLink;
	
	@FindBy(xpath = "(//img[contains(@class,'img-responsive')])[1]")
	WebElement crmLogo;
	
	
	//initializing all the webElements with the driver
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//page library----actions or methods
	public static String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean valiadateCRMimage()
	{
		return crmLogo.isDisplayed();
		
	}
	
	public  HomePage logIN(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
	
}
