package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.DeliveryBoyPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.utilities.Excel;

public class AdminUsersTest extends Base
{
	LoginPage loginpage;
	Excel excel=new Excel();
	AdminUsersPage adminuserspage;
	
	@Test
	public void add_NewAdminUser()
	{
		String userName;
		String passWord;
		excel.setExcelFile("Admin Users Details", "AdminUsersInformations");
		userName=excel.getCellData(1,0);
		passWord=excel.getCellData(1,1);
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails(userName,passWord);
		Assert.assertTrue(adminuserspage.is_alertTextMessageDisplayed());
	}
	@Test
	public void verify_addNewAdminUserAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails("user1667460243206","password123");
		String expectedText=Constants.EXPECTED_ALERT_TEXT15;
		String actualText=adminuserspage.get_TextAlertMessage();
		System.out.println("The actual text alert message:" +actualText);
		Assert.assertEquals(actualText, expectedText,"This testcase failed");
	}
	@Test(dataProvider="adminUsers",dataProviderClass=DataProviderClass.class)
	public void verify_AddAdminUsersByDataProviderClass(String UserName,String PassWord)
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails(UserName,PassWord);
		adminuserspage.get_BackGroundColorAlertText();
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT16;
		String actualBackGroundColor=adminuserspage.get_BackGroundColorAlertText();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	@Test
	public void verify_backgroundColorofExistingAdminUsersAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails("user1667460243206","password123");
		adminuserspage.get_TextAlertMessage();
		String expectedBackgroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT17;
		String actualBackgroundColor=adminuserspage.get_BackGroundColorAlertText();
		Assert.assertEquals(actualBackgroundColor, expectedBackgroundColor);
	}
	@Test
	public void verify_adminUserStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deactivate_statusAdminUser("Kim");
		Assert.assertTrue(adminuserspage.is_SucessAlertTextMessageDisplayed());
	}
	@Test
	public void verify_adminUserActionButtonDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deactivate_actionButtonAdminUser("sji1990");
		String expectedFontSize=Constants.EXPECTED_FONT_SIZE_ALERT_TEXT18;
		String actualFontSize=adminuserspage.get_successAlertTextFontSize();
		Assert.assertEquals(actualFontSize, expectedFontSize);
	}
	@Test
	public void verify_deleteAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deleteAdminUser("user19971667460509876");
		String expectedFontWeight=Constants.EXPECTED_FONT_WEIGHT_ALERT_TEXT19;
		String actualFontWeight=adminuserspage.get_alertTextFontWeight();
		Assert.assertEquals(actualFontWeight, expectedFontWeight);
	}
	@Test
	public void verify_UpdateAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.edit_AdminUser("Jack");
		adminuserspage.clear_Field();
		adminuserspage.update_Field("Jackson");
		Assert.assertTrue(adminuserspage.is_UpdateButtonEnabled());
	}
	@Test
	public void verify_search()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.click_OnSearchButton();
		adminuserspage.enter_UserNameSearch("Kim");
		adminuserspage.click_OnSearchAdminUsersButton();
		Assert.assertTrue(adminuserspage.searchAdminUsersButton_IsDisplayed());
	}
}
