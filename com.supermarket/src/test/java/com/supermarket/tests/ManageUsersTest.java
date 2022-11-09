package com.supermarket.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.pages.ManageUsersPage;
import com.supermarket.utilities.Excel;

public class ManageUsersTest extends Base
{
	LoginPage loginpage;
	ManageUsersPage manageuserspage;
	Excel excel=new Excel();
	
	@Test
	public void verify_manageUserDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuserspage=new ManageUsersPage(driver);
		manageuserspage.click_OnManageUsers();
		manageuserspage.deactivate_User("jothish thachamoochikkal");
		Assert.assertTrue(manageuserspage.is_SucessAlertTextMessageDisplayed());
	}
	
	@Test(priority=1)
	public void verify_SearchUsers()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuserspage=new ManageUsersPage(driver);
		manageuserspage.searchUser("Subina");
		manageuserspage.scroll_DownPage(0,6000);
		String expectedText=Constants.EXPECTED_TEXT21;
		String actualText=manageuserspage.get_TextListUsersTable();
		Assert.assertEquals(actualText,expectedText);
	}
}