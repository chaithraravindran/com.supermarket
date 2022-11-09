package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageUsersPage 
{
WebDriver driver;
GeneralUtility generalutility;
PageUtility pageutility;
Excel excel=new Excel();

@FindBy(xpath="//i[@class='nav-icon fas fa-user']")
private WebElement manageUsersLink;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement sucessAlertMessage;

@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
private WebElement searchButton;

@FindBy(xpath="//input[@placeholder='Name']")
private WebElement name;

@FindBy(xpath="//input[@placeholder='Email']")
private WebElement email;

@FindBy(xpath="//input[@placeholder='Phone Number']")
private WebElement phoneNumber;

@FindBy(xpath="//span[@id='res']")
private WebElement ListUsersTable;

@FindBy(xpath="//i[@class='fa fa-search']")
private WebElement searchButtonInSearchListUsers;

public ManageUsersPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnManageUsers()
{
	manageUsersLink.click();
}
public void click_OnSearchButton()
{
	searchButton.click();
}
public void enter_Name(String Name)
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
public void click_OnSearchButtonInSearchListUsers()
{
	searchButtonInSearchListUsers.click();
}
public void deactivate_User(String userName)
{
generalutility=new GeneralUtility(driver);
pageutility=new PageUtility(driver);
int j=0;
List<String> names=new ArrayList<String>();
names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
for(j=0;j<names.size();j++)
{
	if(userName.equals(names.get(j)))
		{
		j++;
		break;
		}
}
WebElement deactivateButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[5]//a"));
deactivateButton.click();
}
public void searchUser(String Name)
{
	click_OnManageUsers();
	click_OnSearchButton();
	enter_Name(Name);
	click_OnSearchButtonInSearchListUsers();
}
public void scroll_DownPage(int a,int b)
{
	pageutility=new PageUtility(driver);
	pageutility.scroll_DownJSExecutor(a,b);
}
public String get_TextListUsersTable()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(ListUsersTable);
} 
public boolean is_SucessAlertTextMessageDisplayed()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(sucessAlertMessage);
}
}
