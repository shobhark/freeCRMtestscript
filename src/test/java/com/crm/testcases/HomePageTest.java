package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	Loginpage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginpage = new Loginpage();
		testUtil = new TestUtil();
		homepage = loginpage.logIN(prop.getProperty("username"), prop.getProperty("password"));
		
	}
		
	@Test(priority=1)
	public void verifyHomepageTitleTest()
	{
		String homepagetitle = homepage.verifyHomepageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","homePage title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserlabelTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyOnContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage = homepage.clickonContactsLink();
	}


	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}

}
