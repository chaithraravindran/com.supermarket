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
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage 
{
WebDriver driver;
GeneralUtility generalutility;
PageUtility pageutility;
WaitUtility waitutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
private WebElement adminUsersLink;

@FindBy(xpath="//a[@onclick='click_button(1)']")
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

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement sucessAlertMessage;

@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
private WebElement updateButton;

@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
private WebElement searchButton;

@FindBy(xpath="//button[@name='Search']")
private WebElement searchAdminUsersButton;

@FindBy(xpath="//tbody//tr//td[1]")
private WebElement searchedAdminUser;

@FindBy(xpath="//input[@id='un']")
private WebElement userNameSearch;

@FindBy(xpath="//i[@class='fa fa-unlock']")
private WebElement deactivateActionColor;

@FindBy(xpath="//li[@class='nav-item dropdown']")
private WebElement adminUserName;

@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
private WebElement logOutButton;

public AdminUsersPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnAdminUsers()
{
	waitutility=new WaitUtility(driver);
	waitutility.element_ToBeClickable(20L, "//i[@class='nav-icon fas fa-users']");
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
public void choose_UserType(int a)
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(a,userType);
}
public void click_OnSaveButton()
{
	saveButton.click();
}
public void click_OnUpdateButton()
{
	updateButton.click();
}
public void click_OnSearchButton()
{
	searchButton.click();
}
public void enter_UserNameSearchField(String UserName)
{
	userNameSearch.sendKeys(UserName);
}
public void click_OnSearchAdminUsersButton()
{
	searchAdminUsersButton.click();
}
public void click_OnAdminUserName()
{
	adminUserName.click();
}
public void click_OnLogOutButton()
{
	click_OnAdminUserName();
	logOutButton.click();
}
public void create_AdminUserDetails(String UserName,String PassWord)
{
	click_OnAdminUsers();
	click_OnNewButton();
	enter_UserName(UserName);
	enter_PassWord(PassWord);
}
public boolean is_alertTextMessageDisplayed()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(alertMessage);
}
public String visibilityOfAlertMessage()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Attribute(alertMessage,"class");
}
public String get_BackGroundColorAlertText()
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
public boolean is_SucessAlertTextMessageDisplayed()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(sucessAlertMessage);
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
public String visibilityOfSucessAlertMessage()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Attribute(sucessAlertMessage,"class");
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
public boolean searchedAdminUser_IsDisplayed()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(searchedAdminUser);
}
public void edit_AdminUser(String adminUserName)
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
WebElement editAdminUserButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[5]//a)[2]"));
editAdminUserButton.click();
}
public void clear_Field()
{
	generalutility=new GeneralUtility(driver);
	generalutility.clear_Text(userName);
}
public void update_Field(String UserName)
{
	enter_UserName(UserName);
}
public String  get_TextSearchName()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(searchedAdminUser);
}
}


