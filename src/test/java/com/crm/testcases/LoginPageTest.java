package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends TestBase{
	
	static Loginpage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public static void setUP()
	{
		initialization();
		 loginpage = new Loginpage();
	}
	
	@Test(priority=1)
	public void validatePageTitleTest()
	{
		String title = Loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void CRMlogoImageTest()
	{
		boolean flag = loginpage.valiadateCRMimage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homepage = loginpage.logIN(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
