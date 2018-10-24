package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{
	
	TestUtil testutil;

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
//	---------new contact OR
	@FindBy(xpath = "//select[@name='title']")
	WebElement title;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save' and @class='button']")
	WebElement saveBtn;
	
//-------------------new Task  ORin
	@FindBy(xpath="//input[@name='title']")
	WebElement taskTitle;
	

	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean verifycontactslabel()
	{
		return contactslabel.isDisplayed();
	}
	
	public void selectContectsByName(String name)
	{
		driver.findElement(By.xpath("(//a[contains(text(),'"+name+"')])[1]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String titl,String firstnm, String lastnm, String comp)
	{
		Select select = new Select(title);
		select.selectByVisibleText(titl);
		
		firstName.sendKeys(firstnm);
		lastName.sendKeys(lastnm);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
}
