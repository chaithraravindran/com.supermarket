package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.PageUtility;

public class ManagePaymentMethodsPage 
{
WebDriver driver;
PageUtility pageutility;
Excel excel=new Excel();
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-payment-methods']")
private WebElement managePaymentMethods;
@FindBy(xpath="(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
private WebElement actionButton;
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
	pageutility.scroll_Down(0,6000);
}
public void click_OnManagePaymentMethods()
{
	pageutility=new PageUtility(driver);
	pageutility.click_Element(managePaymentMethods);
}
public void click_OnActionButton()
{
	actionButton.click();
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
public void updatePaymentMethods(String Title,String PayLimit)
{
	scrollDownPage();
	click_OnManagePaymentMethods();
	click_OnActionButton();
	enter_Title(Title);
	enter_PayLimit(PayLimit);
	click_OnUpdateButton();
}
public void updatePaymentMethods()
{
	String title;
	String payLimit;
	excel.setExcelFile("Manage Payment Methods Update", "Manage Payment Methods Information");
	title=excel.getCellData(0,0);
	payLimit=excel.getCellData(0,1);
	updatePaymentMethods(title,payLimit);
}
}
