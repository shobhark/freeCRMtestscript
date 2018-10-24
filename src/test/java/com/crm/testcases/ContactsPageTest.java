package com.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase{
	
	
	
	Loginpage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		testUtil = new TestUtil();
		loginpage = new Loginpage();
		homepage = new HomePage();
		contactsPage = new ContactsPage();
		homepage = loginpage.logIN(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homepage.clickonContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactlabel()
	{
		
		Assert.assertTrue(contactsPage.verifycontactslabel());
	}
	
	@Test(priority=2)
	public void selectSingleContacts()
	{
	contactsPage.selectContectsByName("Amit Mohanty");
	}
	
	@Test(enabled = false)
	public void selectMultipleContacts()
	{
	contactsPage.selectContectsByName("Amit Thakur");
	contactsPage.selectContectsByName("Amrita Bastawade");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data = testUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	//columns in excel sheet and the no.of parameters we pass should match 
	public void validateCreateNewContact(String title, String firstname, String lastname, String company)
	{
		homepage.clickNewContactsLink();
		contactsPage.createNewContact(title, firstname, lastname, company);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
