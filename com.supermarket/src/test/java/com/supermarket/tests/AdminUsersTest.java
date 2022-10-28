package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.DeliveryBoyPage;
import com.supermarket.pages.LoginPage;
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
		adminuserspage.AdminUserDetails("Mike","mike@gmail");
		String expectedResult=Constants.EXPECTED_ALERT_TEXT2;
		String actualResult=adminuserspage.get_alertTextMessage();
		System.out.println("The actual text alert message:" +actualResult);
		Assert.assertEquals(actualResult, expectedResult,"This testcase failed");
	}
	@Test
	public void verify_existingAdminUsersAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.AdminUserDetails("Nike","nike@gmail");
		String expectedResult=Constants.EXPECTED_ALERT_TEXT2;
		String actualResult=adminuserspage.get_alertTextMessage();
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
		adminuserspage.get_alertTextMessage();
		String actualBackgroundColor=adminuserspage.get_backgroundColorAlertText();
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
		adminuserspage.deactivate_statusAdminUser("Nike");
	}
	@Test
	public void verify_adminUserActionButtonDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deactivate_actionButtonAdminUser("max@");
	}
	@Test
	public void verify_deleteAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		adminuserspage=new AdminUsersPage(driver);
		adminuserspage.click_OnAdminUsers();
		adminuserspage.deleteAdminUser("mahi");
	}
}
