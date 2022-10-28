package com.supermarket.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base
{
	LoginPage loginpage;
	ManageUsersPage manageuserspage;
	@Test
	public void verify_manageUserDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageuserspage=new ManageUsersPage(driver);
		manageuserspage.click_OnManageUsers();
		manageuserspage.deactivate_User("Subina S");
	}
	
}
