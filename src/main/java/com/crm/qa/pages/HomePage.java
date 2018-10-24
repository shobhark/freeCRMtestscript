package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//page factory------OR (object Repository)
	
	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement userNamelabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[text()='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Task')]")
	WebElement newTasksLink;
	
	
	//initializing webElements with driver 
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//PageLibrary or Actions on webElements
	public String verifyHomepageTitle()
	{
	return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername()
	{
		 return  userNamelabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink()
	{
		 tasksLink.click();
		 return new TasksPage();
	}

	public void clickNewContactsLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public void clickNewTasksLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(tasksLink).build().perform();
		newTasksLink.click();
	}
	
	
	
}
