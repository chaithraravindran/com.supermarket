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
	}
	@Test
	public void verify_addNewAdminUserAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails("Michael","mike@gmail");
		String expectedResult=Constants.EXPECTED_ALERT_TEXT2;
		String actualResult=adminuserspage.get_SucessAlertTextMessage();
		System.out.println("The actual text alert message:" +actualResult);
		Assert.assertEquals(actualResult, expectedResult,"This testcase failed");
	}
	@Test(dataProvider="adminUsers",dataProviderClass=DataProviderClass.class)
	public void verify_AddAdminUsersByDataProviderClass(String UserName,String PassWord)
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails(UserName,PassWord);
	}
	@Test
	public void verify_existingAdminUsersAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails("Nike","nike@gmail");
		String expectedResult=Constants.EXPECTED_ALERT_TEXT2;
		String actualResult=adminuserspage.get_AlertTextMessage();
		System.out.println("The actual text alert message:" +actualResult);
		Assert.assertEquals(actualResult, expectedResult,"This testcase failed");
	}
	@Test
	public void verify_backgroundColorofExistingAdminUsersAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails("Nike","nike@gmail");
		adminuserspage.get_AlertTextMessage();
		String actualBackgroundColor=adminuserspage.get_BackGroundColorAlertText();
		String expectedBackgroundColor="rgba(220, 53, 69, 1)";
		Assert.assertEquals(actualBackgroundColor, expectedBackgroundColor);
	}
	@Test
	public void verify_adminUserStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deactivate_statusAdminUser("Ann");
	}
	@Test
	public void verify_adminUserActionButtonDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deactivate_actionButtonAdminUser("Mike");
	}
	@Test
	public void verify_deleteAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deleteAdminUser("user100");
	}
	@Test
	public void verify_UpdateAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.edit_AdminUser("Ian");
		adminuserspage.clear_Field();
		adminuserspage.update_Field("Ian Jackson");
	}
	@Test
	public void verify_search()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.click_OnSearchButton();
		adminuserspage.enter_UserNameSearch("Kevin");
		adminuserspage.click_OnSearchAdminUsersButton();
		Assert.assertTrue(adminuserspage.searchAdminUsersButton_IsDisplayed());
		
	}
}
