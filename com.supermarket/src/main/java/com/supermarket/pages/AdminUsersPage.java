package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class AdminUsersPage 
{
WebDriver driver;
GeneralUtility generalutility;
PageUtility pageutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
private WebElement adminUsersLink;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;
@FindBy(xpath="//input[@id='username']")
private WebElement userName;
@FindBy(xpath="//input[@id='password']")
private WebElement passWord;
@FindBy(xpath="//select[@id='user_type']")
private WebElement userType;
@FindBy(xpath="//button[@name='Create']")
private WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
private WebElement alertMessage;


public AdminUsersPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void click_OnAdminUsers()
{
	adminUsersLink.click();
}
public void click_OnNewButton() 
{
	newButton.click();
}
public void enter_UserName(String UserName)
{
	userName.sendKeys(UserName);
}
public void enter_PassWord(String PassWord)
{
	passWord.sendKeys(PassWord);
}
public void choose_UserType()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(3,userType);
}
public void click_OnSaveButton()
{
	saveButton.click();
}

public void AdminUserDetails(String UserName,String PassWord)
{
	click_OnAdminUsers();
	click_OnNewButton();
	enter_UserName(UserName);
	enter_PassWord(PassWord);
	choose_UserType();
	click_OnSaveButton();
}
public String get_alertTextMessage()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(alertMessage);
}
public String get_backgroundColorAlertText()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(alertMessage,"background-color");
}
public void deactivate_statusAdminUser(String adminUserName)
{
	generalutility=new GeneralUtility(driver);
	int j=0;
	List<String> names=new ArrayList<String>();
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<names.size();j++)
	{
		if(adminUserName.equals(names.get(j)))
		{
			j++;
			break;
		}
	}
WebElement deactivateButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[3]//a"));
deactivateButton.click();
}
public void deactivate_actionButtonAdminUser(String adminUserName)
{
	generalutility=new GeneralUtility(driver);
	int j=0;
	List<String> names=new ArrayList<String>();
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<names.size();j++)
	{
		if(adminUserName.equals(names.get(j)))
		{
			j++;
			break;
		}
	}
WebElement deactivateActionButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[5]//a)[1]"));
deactivateActionButton.click();
}
public void deleteAdminUser(String adminUserName)
{
	generalutility=new GeneralUtility(driver);
	int j=0;
	List<String> names=new ArrayList<String>();
	names=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<names.size();j++)
	{
		if(adminUserName.equals(names.get(j)))
		{
			j++;
			break;
		}
	}
WebElement deleteAdminUserButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[5]//a)[3]"));
deleteAdminUserButton.click();
driver.switchTo().alert().accept();
}

}


