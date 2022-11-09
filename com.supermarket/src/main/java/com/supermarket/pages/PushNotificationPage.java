package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;

public class PushNotificationPage 
{
WebDriver driver;
GeneralUtility generalutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-fas fa-bell']")
private WebElement pushNotificationLink;

@FindBy(xpath="//input[@id='title']")
private WebElement titleField;

@FindBy(xpath="//input[@id='description']")
private WebElement descriptionField;

@FindBy(xpath="//i[@class='fa fa-bell']")
private WebElement sendButton;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement successAlertMessage;

public PushNotificationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnPushNotification()
{
	pushNotificationLink.click();
}
public void enter_title(String title)
{
	titleField.sendKeys(title);
}
public void enter_description(String description)
{
	descriptionField.sendKeys(description);
}
public void click_onSendButton()
{
	sendButton.click();
}
public String visibilityOfSucessAlertMessage()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Attribute(successAlertMessage,"class");
}
public void add_PushNotificationsInformations(String title,String description)
{
	List<String> list=new ArrayList<>();
	list.add(title);
	list.add(description);
	enter_title(list.get(0));
	enter_description(list.get(1));
}
public String get_sucessAlertTextBackgroundColor()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(successAlertMessage,"background-color");
}
public String getText_SuccessAlertPushNotificationMessage()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(successAlertMessage);
}
}


