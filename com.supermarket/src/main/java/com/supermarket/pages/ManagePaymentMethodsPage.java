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

public class ManagePaymentMethodsPage 
{
WebDriver driver;
PageUtility pageutility;
GeneralUtility generalutility;
Excel excel=new Excel();

@FindBy(xpath="//i[@class='nav-icon fas fa-credit-card']")
private WebElement managePaymentMethods;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement sucessAlertMessage;

@FindBy(xpath="//input[@id='name']")
private WebElement title;

@FindBy(xpath="//input[@id='limit']")
private WebElement payLimit;

@FindBy(xpath="//button[@name='Update']")
private WebElement updateButton;

public ManagePaymentMethodsPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void scrollDownPage()
{
	pageutility=new PageUtility(driver);
	pageutility.scroll_DownJSExecutor(0,6000);
}
public void click_OnManagePaymentMethods()
{
	pageutility=new PageUtility(driver);
	pageutility.click_JSExceutor(managePaymentMethods);
}
public void enter_Title(String Title)
{
	title.sendKeys(Title);
}
public void enter_PayLimit(String PayLimit)
{
	payLimit.sendKeys(PayLimit);
}
public void click_OnUpdateButton()
{
	updateButton.click();
}
public void deactivate_StatusManagePayment(String Title)
{
	generalutility=new GeneralUtility(driver);
	int j=0;
	List<String> titles=new ArrayList<String>();
	titles=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<titles.size();j++)
	{
		if(Title.equals(titles.get(j)))
		{
			j++;
			break;
		}
	}
	WebElement deactivateButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[3]//a"));
	deactivateButton.click();
}
public void click_OnDeactivate_StatusManagePaymentButton(String Title)
{
	scrollDownPage();
	click_OnManagePaymentMethods();
	deactivate_StatusManagePayment(Title);
}
public boolean is_StatusAlertTextMessageDisplayed()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(sucessAlertMessage);
}
public void edit_ActionManagePayment(String Title)
{
	generalutility=new GeneralUtility(driver);
	int j=0;
	List<String> titles=new ArrayList<String>();
	titles=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	for(j=0;j<titles.size();j++)
	{
		if(Title.equals(titles.get(j)))
		{
			j++;
			break;
		}
}
WebElement editAdminUserButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[4]//a"));
editAdminUserButton.click();
}
public void clear_Field()
{
	generalutility=new GeneralUtility(driver);
	generalutility.clear_Text(payLimit);
}
public void update_Field(String PayLimit)
{
	enter_PayLimit(PayLimit);
	click_OnUpdateButton();
}
public String get_colorAlertText()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(sucessAlertMessage,"color");
}
}
