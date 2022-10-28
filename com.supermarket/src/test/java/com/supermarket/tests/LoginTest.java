package com.supermarket.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginpage;

	@Test
	public void verify_Login() 
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
	}
	@Test
	public void verify_ProfileImageisDisplayed()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		Assert.assertTrue(loginpage.is_ProfileImageDisplayed());
	}
	@Test
	public void verify_InvalidLoginCredentialAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("admin","123");
		
		//String expectedResult=Constants.EXPECTED_ALERT_TEXT0;
		String expectedResult=Constants.EXPECTED_ALERT_TEXT;
		/*String expectedResult="×\r\n" + 
			"Alert!\r\n" + 
			"Invalid Username/Password";*/
		String actualResult=loginpage.get_InvalidLoginAlertMessage();
		System.out.println("The actual text alert message:" +actualResult);
		Assert.assertEquals(actualResult, expectedResult,"This testcase failed");
	}
	
	
}
