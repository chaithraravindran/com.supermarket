package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.Excel;

public class ManageExpenseTest extends Base
{
	LoginPage loginpage;
	ManageExpensePage manageexpensepage;
	Excel excel=new Excel();
	
	@Test(groups= {"smoke","sanity"})
	public void verify_AddExpense()
	{
		excel.setExcelFile("ManageExpenseDetails", "AddExpense");
		String amount=excel.getCellData(1,0);
		String remarks=excel.getCellData(1,1);
		
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.add_Expense(3,"FruitNew","7",8,"Debit Cash",amount,remarks);
		manageexpensepage.file_Upload(Constants.FILEUPLOAD_FILE_PATH + "\\File 1.doc");
		manageexpensepage.click_OnSaveButton();
		String expectedAlertValue=Constants.EXPECTED_ALERT_TEXT_VALUE5;
		String actualAlertValue=manageexpensepage.visibilityOfSucessAlertMessage();
		Assert.assertEquals(actualAlertValue, expectedAlertValue);
	}
	@Test
	public void verify_AddNewExpense()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.add_Expense(4,"IceCreams","8",3,"Credit Cash","2000","Amount to be paid");
		manageexpensepage.file_Upload(Constants.FILEUPLOAD_FILE_PATH + "\\IceCream.jpg");
		manageexpensepage.click_OnSaveButton();
		Assert.assertTrue(manageexpensepage.is_alertTextMessageDisplayed());
	}
	@Test(dataProvider="manageExpense",dataProviderClass=DataProviderClass.class)
	public void verify_AddExpenseByDataProviderClass(String Amount,String Remarks)
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.add_Expense(3,"NewFruit","6",11,"Debit Cash",Amount,Remarks);
		manageexpensepage.scroll_DownPage(0,6000);
		manageexpensepage.file_Upload(Constants.FILEUPLOAD_FILE_PATH + "\\File 1.doc");
		manageexpensepage.click_OnSaveButton();
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT6;
		String actualBackGroundColor=manageexpensepage.get_alertTextBackgroundColor();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	@Test
	public void verify_UpdateExpense()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.click_OnSubManageExpense();
		manageexpensepage.scroll_DownPage(0,5000);
		manageexpensepage.edit_ExpenseDetails("NewFruit (Admin2-AD)");
		manageexpensepage.clear_Field();
		manageexpensepage.update_Field("3000");
		String expectedAlertValue=Constants.EXPECTED_ALERT_TEXT7;
		String actualAlertValue=manageexpensepage.visibilityOfSucessAlertMessage();
		Assert.assertEquals(actualAlertValue, expectedAlertValue);
	}
	@Test
	public void verify_DeleteExpense()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.click_OnSubManageExpense();
		manageexpensepage.scroll_DownPage(0,5000);
		manageexpensepage.delete_Expense("IceCreams (232-ST)");
		manageexpensepage.click_OnSearchButton();
		manageexpensepage.enter_SearchTitleField("IceCreams (232-ST)");
		manageexpensepage.click_OnSearchListExpenseButton();
		manageexpensepage.scroll_DownPage(0,5000);
		Assert.assertTrue(manageexpensepage.searchedTitleInListExpense_IsDisplayed());
	}
	@Test
	public void verify_searchListExpense()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.click_OnSubManageExpense();
		manageexpensepage.click_OnSearchButton();
		manageexpensepage.enter_SearchListExpenseDetails("IceCreams");
		manageexpensepage.click_OnSearchListExpenseButton();
		manageexpensepage.click_ReportButtonManageExpense();
		String expectedText=Constants.EXPECTED_ALERT_TEXT8;
		String actualText=manageexpensepage.get_TextNewWindowExpenseReport();
		Assert.assertEquals(actualText, expectedText);
	}
	
}
