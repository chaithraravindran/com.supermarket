package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageExpensePage 
{
WebDriver driver;
PageUtility pageutility;
GeneralUtility generalutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
private WebElement manageExpenseLink;

@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[2]")
private WebElement subManageExpense;

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;

@FindBy(xpath="//select[@id='user_id']")
private WebElement user;

@FindBy(xpath="//input[@id='ex_date']")
private WebElement date;

@FindBy(xpath="//select[@id='ex_cat']")
private WebElement category;

@FindBy(xpath="//select[@id='order_id']")
private WebElement orderID;

@FindBy(xpath="//select[@id='purchase_id']")
private WebElement purchaseID;

@FindBy(xpath="//select[@id='ex_type']")
private WebElement expenseType;

@FindBy(xpath="//input[@id='amount']")
private WebElement amount;

@FindBy(xpath="//textarea[@id='content']")
private WebElement remarks;

@FindBy(xpath="//input[@type='file']")
private WebElement chooseFile;

@FindBy(xpath="//button[@type='submit']")
private WebElement saveButton;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement sucessAlertMessage;

@FindBy(xpath="//button[@name='update']")
private WebElement updateButton;

@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
private WebElement searchButton;

@FindBy(xpath="//select[@id='um']")
private WebElement searchUsers;

@FindBy(xpath="//select[@id='uc']")
private WebElement searchCategory;

@FindBy(xpath="//select[@id='od']")
private WebElement searchOrderID;

@FindBy(xpath="//select[@id='ty']")
private WebElement searchExpenseType;

@FindBy(xpath="//select[@id='pi']")
private WebElement searchPurchaseID ;

@FindBy(xpath="//input[@id='ti']")
private WebElement searchTitle;

@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
private WebElement searchListButton;

@FindBy(xpath="//a[@class='btn btn-rounded btn-info']")
private WebElement reportButton;

@FindBy(xpath="//div[@class='col-sm-12']")
private WebElement newWindowExpenseReport;

@FindBy(xpath="//i[@class='fas fa-arrow-left']")
private WebElement backButton;

public ManageExpensePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnManageExpense()
{
	manageExpenseLink.click();
}
public void click_OnSubManageExpense()
{
	subManageExpense.click();
}
public void click_OnNewButton()
{
	newButton.click();
}
public void select_User()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(3,user);
}
public void select_Category()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByVisibleText("IceCreams",category);
}
public void select_OrderID()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByValue("8", orderID);
}
public void select_PurchseID()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(6,purchaseID);
}
public void select_ExpenseType()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByVisibleText("Debit Cash",expenseType);
}
public void enter_Amount(String Amount)
{
	amount.sendKeys(Amount);
}
public void enter_Remarks(String Remarks)
{
	remarks.sendKeys(Remarks);
}
public void scroll_DownPage()
{
	pageutility=new PageUtility(driver);
	pageutility.scroll_DownJSExecutor(0,6000);
}
public void click_ChooseFile()
{
	pageutility=new PageUtility(driver);
	pageutility.click_JSExceutor(chooseFile);
}
public void file_Upload(String filePath) 
{
	chooseFile.sendKeys(filePath);
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
public void click_OnBackButton()
{
	backButton.click();
}
public void add_Expense(String Amount,String Remarks)
{
	click_OnManageExpense();
	click_OnSubManageExpense();
	click_OnNewButton();
	select_User();
	select_Category();
	select_OrderID();
	select_PurchseID();
	select_ExpenseType();
	enter_Amount(Amount);
	enter_Remarks(Remarks);
	scroll_DownPage();
	//click_ChooseFile();
}
public String get_alertTextFontStyle()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(sucessAlertMessage,"font-style");
}
public boolean is_alertTextMessageDisplayed()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Displayed(sucessAlertMessage);
}
public String get_alertTextBackgroundColor()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(sucessAlertMessage,"background-color");
}
public void edit_ExpenseDetails(String titleName)
{
	List<String> titleNames=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	titleNames=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int i=0;
	for(i=0;i<titleNames.size();i++)
	{
		if(titleName.equals(titleNames.get(i)))
		{
			i++;
			break;
		}
	}
	WebElement editButton=driver.findElement(By.xpath("(//tbody//tr["+i+"]//td[9]//a)[1]"));
	editButton.click();
}
public void clear_Field()
{
	generalutility=new GeneralUtility(driver);
	generalutility.clear_Text(amount);
}
public void update_Field(String Amount)
{
	enter_Amount(Amount);
	click_OnUpdateButton();
}
public String get_alertTextFontWeight()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(sucessAlertMessage,"font-weight");
}
public void delete_Expense(String titleName)
{
	List<String> titleNames=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	titleNames=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int i=0;
	for(i=0;i<titleNames.size();i++)
	{
		if(titleName.equals(titleNames.get(i)))
		{
			i++;
			break;
		}
	}
	WebElement deleteButton=driver.findElement(By.xpath("(//tbody//tr["+i+"]//td[9]//a)[2]"));
	deleteButton.click();
	driver.switchTo().alert().accept();
}
public String get_FontFamilyAlertText()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_CssValue(sucessAlertMessage,"font-family");
}
public void search_ListExpense()
{
	searchUsers.click();
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(5,searchUsers);
	searchCategory.click();
	pageutility.select_ByVisibleText("IceCreams",searchCategory);
	searchExpenseType.click();
	pageutility.select_ByVisibleText("Credit Cash",searchExpenseType);
	searchOrderID.click();
	pageutility.select_ByValue("9", searchOrderID);
	searchPurchaseID.click();
	pageutility.select_ByIndex(3,searchPurchaseID);
}
public void click_OnSearchListExpenseButton()
{
	pageutility.scroll_andClick(searchListButton);
}
public void enter_SearchTitle(String title)
{
	searchTitle.sendKeys(title);
}
public boolean searchListExpenseButton_IsEnabled()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Enabled(searchListButton);
}
public void click_ReportButtonManageExpense()
{
	pageutility.scroll_andClick(reportButton);
	String parentWindow=driver.getWindowHandle();
	System.out.println(parentWindow);

	Set<String> windows=driver.getWindowHandles();
	System.out.println(windows.size());
	System.out.println(windows);
	for(String childWindow:windows)
	{
	if(parentWindow.equals(childWindow))
	{
		System.out.println("No need to switch");
		System.out.println(childWindow+""+parentWindow);
	}
	else
	{
		driver.switchTo().window(childWindow);
	}
	}
}
public String get_TextNewWindowExpenseReport()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.get_Text(newWindowExpenseReport);
} 
}
