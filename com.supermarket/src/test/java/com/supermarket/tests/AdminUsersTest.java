package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.DeliveryBoyPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base
{
	LoginPage loginpage;
	Excel excel=new Excel();
	GeneralUtility generalutility;
	AdminUsersPage adminuserspage;
	SoftAssert softassert;
	
	@Test(priority=2)
	public void verify_AddNewAdminUser()
	{
		excel.setExcelFile("Admin Users Details", "AdminUsersInformations");
		String userName=excel.getCellData(1,0);
		String passWord=excel.getCellData(1,1);
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.create_AdminUserDetails(userName,passWord);
		adminuserspage.choose_UserType(2);
		adminuserspage.click_OnSaveButton();
		Assert.assertTrue(adminuserspage.is_alertTextMessageDisplayed());
	}
	@Test(priority=6)
	public void verify_AddNewAdminUserAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		String timeStamp=generalutility.get_TimeStamp();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.create_AdminUserDetails("user1667460243232_"+timeStamp,"password13");
		adminuserspage.choose_UserType(3);
		adminuserspage.click_OnSaveButton();
		String expectedAlertValue=Constants.EXPECTED_ALERT_TEXT_VALUE15;
		String actualAlertValue=adminuserspage.visibilityOfSucessAlertMessage();
		Assert.assertEquals(actualAlertValue, expectedAlertValue);
	}
	@Test(dataProvider="adminUsers",dataProviderClass=DataProviderClass.class)
	public void verify_AddAdminUsersByDataProviderClass(String UserName,String PassWord)
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.create_AdminUserDetails(UserName,PassWord);
		adminuserspage.choose_UserType(4);
		adminuserspage.click_OnSaveButton();
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT16;
		String actualBackGroundColor=adminuserspage.get_BackGroundColorAlertText();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	@Test(priority=7)
	public void verify_adminUserStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deactivate_statusAdminUser("Bin");
		Assert.assertTrue(adminuserspage.is_SucessAlertTextMessageDisplayed());
	}
	@Test(priority=4)
	public void verify_adminUserActionButtonDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		softassert=new SoftAssert();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deactivate_actionButtonAdminUser("paddy189_09_11-2022_09_59_49");
		String expectedAlertValue=Constants.EXPECTED_ALERT_TEXT_VALUE17;
		String actualAlertValue=adminuserspage.visibilityOfSucessAlertMessage();
		softassert.assertEquals(actualAlertValue, expectedAlertValue);
	}
	@Test
	public void verify_deleteAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deleteAdminUser("Kevin S");
		adminuserspage.click_OnSearchButton();
		adminuserspage.enter_UserNameSearchField("Kevin S");
		adminuserspage.click_OnSearchAdminUsersButton();
		Assert.assertTrue(adminuserspage.searchedAdminUser_IsDisplayed());
	}
	@Test(priority=3)
	public void verify_UpdateAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.edit_AdminUser("Teddy");
		adminuserspage.clear_Field();
		adminuserspage.update_Field("Ted");
		adminuserspage.click_OnUpdateButton();
		String expectedAlertValue=Constants.EXPECTED_ALERT_TEXT19;
		String actualAlertValue=adminuserspage.visibilityOfSucessAlertMessage();
		Assert.assertEquals(actualAlertValue, expectedAlertValue);
	}
	@Test
	public void verify_searchAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.click_OnSearchButton();
		adminuserspage.enter_UserNameSearchField("binn");
		adminuserspage.click_OnSearchAdminUsersButton();
		Assert.assertTrue(adminuserspage.searchedAdminUser_IsDisplayed());
	}
	@Test(priority=5)
	public void verify_NewAdminUserCreation_Search()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		String timeStamp=generalutility.get_TimeStamp();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.create_AdminUserDetails("Bin_"+timeStamp,"bin123");
		adminuserspage.choose_UserType(2);
		adminuserspage.click_OnSaveButton();
		adminuserspage.click_OnSearchButton();
		adminuserspage.enter_UserNameSearchField("Bin_"+timeStamp);
		adminuserspage.click_OnSearchAdminUsersButton();
		String expectedsearchName=Constants.EXPECTED_SEARCH_Name20+timeStamp;
		String actualSearchName=adminuserspage.get_TextSearchName();
		Assert.assertEquals(actualSearchName, expectedsearchName);
	}
	@Test(priority=1)
	public void verify_CreateNewAdminUser_LogOut_LogIn()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.create_AdminUserDetails("Ted","Ted123");
		adminuserspage.choose_UserType(3);
		adminuserspage.click_OnSaveButton();
		adminuserspage.click_OnLogOutButton();
		loginpage.login("Ted","Ted123");
		Assert.assertTrue(loginpage.is_ProfileImageDisplayed());
	}
}
