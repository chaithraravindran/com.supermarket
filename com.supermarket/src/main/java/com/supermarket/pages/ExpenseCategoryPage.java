package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ExpenseCategoryPage 
{
WebDriver driver;
PageUtility pageutility;
GeneralUtility generalutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
private WebElement manageExpenseLink;

@FindBy(xpath="(//ul[@class='nav nav-treeview'])[1]")
private WebElement expenseCategory;

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;

@FindBy(xpath="//input[@id='name']")
private WebElement title;

@FindBy(xpath="//button[@name='Create']")
private WebElement saveButton;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement sucessAlertMessage;

public ExpenseCategoryPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnManageExpense()
{
	manageExpenseLink.click();
}
public void click_OnExpenseCategory()
{
	expenseCategory.click();
}
public void click_OnNewButton()
{
	newButton.click();
}
public void enter_TitleField(String Title)
{
	title.sendKeys(Title);
}
public void click_OnSaveButton()
{
	saveButton.click();
}
public void add_ExpenseCategoryInformations(String Title)
{
	List<String> list=new ArrayList<>();
	list.add(Title);
	enter_TitleField(list.get(0));
}
public boolean is_SucessAlertTextMessageDisplayed()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(sucessAlertMessage);
}

}
