package com.supermarket.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviderClass;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.PdfReader;

public class PushNotificationTest extends Base
{
	LoginPage loginpage;
	Excel excel=new Excel();
	PushNotificationPage pushnotificationpage;
	
	@Test(dataProvider="PushNotificationExcelData",dataProviderClass=DataProviderClass.class)
	public void verify_AlertTextPushNotificationByDataProviderClass(String title, String description)
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_OnPushNotification();
		pushnotificationpage.enter_title(title);
		pushnotificationpage.enter_description(description);
		pushnotificationpage.click_onSendButton();
		String expectedAlertValue=Constants.EXPECTED_ALERT_TEXT_VALUE;
		String actualAlertValue=pushnotificationpage.visibilityOfSucessAlertMessage();
		Assert.assertEquals(actualAlertValue, expectedAlertValue);
		
	}
	@Test(priority=1)
	public void verify_PushNotificationAlertByList()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_OnPushNotification();
		pushnotificationpage.add_PushNotificationsInformations("New Product", "Products arriving shortly");
		pushnotificationpage.click_onSendButton();
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT14;
		String actualBackGroundColor=pushnotificationpage.get_sucessAlertTextBackgroundColor();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	
}
