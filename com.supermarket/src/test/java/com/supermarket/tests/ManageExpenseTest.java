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
		String amount;
		String remarks;
		excel.setExcelFile("ManageExpenseDetails", "AddExpense");
		amount=excel.getCellData(1,0);
		remarks=excel.getCellData(1,1);
		
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.add_Expense(amount,remarks);
		manageexpensepage.file_Upload(Constants.FILEUPLOAD_FILE_PATH + "\\File 1.doc");
		manageexpensepage.click_OnSaveButton();
		String expectedFontStyle=Constants.EXPECTED_FONT_STYLE_ALERT_TEXT5;
		String actualFontStyle=manageexpensepage.get_alertTextFontStyle();
		Assert.assertEquals(actualFontStyle, expectedFontStyle);
	}
	@Test
	public void verify_AddExpenseInTest()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.add_Expense("2000","Amount to be paid");
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
		manageexpensepage.add_Expense(Amount,Remarks);
		manageexpensepage.scroll_DownPage();
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
		manageexpensepage.scroll_DownPage();
		manageexpensepage.edit_ExpenseDetails("FruitNew (Staff-ST)");
		manageexpensepage.clear_Field();
		manageexpensepage.update_Field("3000");
		String expectedFontWeight=Constants.EXPECTED_FONT_WEIGHT_ALERT_TEXT7;
		String actualFontWeight=manageexpensepage.get_alertTextFontWeight();
		Assert.assertEquals(actualFontWeight, expectedFontWeight);
	}
	@Test
	public void verify_DeleteExpense()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		manageexpensepage.click_OnManageExpense();
		manageexpensepage.click_OnSubManageExpense();
		manageexpensepage.scroll_DownPage();
		manageexpensepage.delete_Expense("IceCreams (Sumesh-PT)");
		String expectedFontFamily=Constants.EXPECTED_FONT_Family_ALERT_TEXT8;
		String actualFontFamily=manageexpensepage.get_FontFamilyAlertText();
		Assert.assertEquals(actualFontFamily, expectedFontFamily);
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
		manageexpensepage.enter_SearchTitle("IceCreams (Admin2-AD)");
		manageexpensepage.search_ListExpense();
		manageexpensepage.click_OnSearchListExpenseButton();
		Assert.assertTrue(manageexpensepage.searchListExpenseButton_IsEnabled());
		manageexpensepage.click_ReportButtonManageExpense();
		manageexpensepage.get_TextNewWindowExpenseReport();
		manageexpensepage.click_OnBackButton();
	}
	
}
