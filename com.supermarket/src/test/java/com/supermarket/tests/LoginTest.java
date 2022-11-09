package com.supermarket.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;

public class LoginTest extends Base 
{
	LoginPage loginpage;

	@Test(groups="smoke")
	public void verify_Login() 
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		Assert.assertTrue(loginpage.is_LogoEnabled());
	}
	@Test(groups="sanity")
	public void verify_ProfileImageisDisplayed()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		Assert.assertTrue(loginpage.is_ProfileImageDisplayed());
	}
	@Test(priority=1)
	public void verify_InvalidLoginCredentialAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("admin","123");
		String expectedText=Constants.EXPECTED_ALERT_TEXT;
		String actualText=loginpage.get_TextInvalidLoginAlert();
		Assert.assertEquals(actualText, expectedText,"This testcase failed");
	}
	
	
}
