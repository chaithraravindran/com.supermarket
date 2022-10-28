package com.supermarket.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;



public class DeliveryBoyPage 
{
WebDriver driver;
GeneralUtility generalutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-user-plus']")
private WebElement manageDeliveryBoy;

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;

@FindBy(xpath="//input[@id='name']")
private WebElement name;

@FindBy(xpath="//input[@id='email']")
private WebElement email;

@FindBy(xpath="//input[@id='phone']")
private WebElement phoneNumber;

@FindBy(xpath="//textarea[@id='address']")
private WebElement address;

@FindBy(xpath="//input[@id='username']")
private WebElement userName;

@FindBy(xpath="//input[@id='password']")
private WebElement passWord;

@FindBy(xpath="//button[@type='submit']")
private WebElement saveButton;

@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
private WebElement alertMessage;

@FindBy(xpath="//button[@type='submit']")
private WebElement updateButton;

@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
private WebElement searchButton;

@FindBy(xpath="//input[@placeholder='Name']")
private WebElement nameField;

public DeliveryBoyPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnDeliveryBoy()
{
	manageDeliveryBoy.click();
}
public void click_OnNewButton()
{
	newButton.click();
}
public void enterName(String Name) 
{
	name.sendKeys(Name);
}

public void enterEmail(String Email) 
{
	email.sendKeys(Email);
}

public void enterPhoneNumber(String PhoneNumber) 
{
	phoneNumber.sendKeys(PhoneNumber);
}

public void enterAddress(String Address) 
{
	address.sendKeys(Address);
}
public void enterUserName(String UserName) 
{
	userName.sendKeys(UserName);
}

public void enterPassword(String PassWord) 
{
	passWord.sendKeys(PassWord);
}

public void saveLink() 
{
	saveButton.click();
}
public void click_OnUpdateButton()
{
	updateButton.click();
}

public void create_DeliveryBoyDetails(String Name,String Email,String PhoneNumber,String Address,String UserName, String PassWord) 
{
	click_OnDeliveryBoy();
	click_OnNewButton();
	enterName(Name);
	enterEmail(Email);
	enterPhoneNumber(PhoneNumber);
	enterAddress(Address);
	enterUserName(UserName);
	enterPassword(PassWord);
	saveLink();		
}
public String get_alertTextMessage()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(alertMessage);
}
public String get_colorAlertText()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(alertMessage,"color");
}
public void deactivate_deliveryBoy(String deliveryBoyName)
{
	generalutility=new GeneralUtility(driver);
	int j=0;
	List<String> names=new ArrayList<String>();
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<names.size();j++)
	{
		if(deliveryBoyName.equals(names.get(j)))
		{
			j++;
			break;
		}
	}
WebElement statusButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[6]//a"));
statusButton.click();
}
public void edit_DeliveryBoy(String deliveryBoyName)
{
	generalutility=new GeneralUtility(driver);
	List<String> names=new ArrayList<String>();
	int j=0;
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<names.size();j++)
	{
		if(deliveryBoyName.equals(names.get(j)))
		{
			j++;
			break;
		}
	}
WebElement editButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[8]//a)[1]"));
editButton.click();
}
public void clear_Field()
{
	generalutility=new GeneralUtility(driver);
	generalutility.clear_Text(email);
}
public void update_Field(String Email)
{
	enterEmail(Email);
	//click_OnUpdateButton();
}

public void deleteDeliveryBoy(String deliveryBoyName)
{
	generalutility=new GeneralUtility(driver);
	List<String> names=new ArrayList<String>();
	int j=0;
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<names.size();j++)
	{
		if(deliveryBoyName.equals(names.get(j)))
		{
			j++;
			break;
		}
	}
WebElement deleteButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[8]//a)[2]"));
deleteButton.click();
driver.switchTo().alert().getText();
driver.switchTo().alert().accept();
}


}
