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
	
	@Test
	public void verify_SuccessAlertPushNotification()
	{
		String titleField;
		String descriptionField;
		excel.setExcelFile("PushNotifications", "PushNotificationsInformations");
		titleField=excel.getCellData(0,1);
		descriptionField=excel.getCellData(1,1);
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.add_PushNotificationsInformations(titleField,descriptionField);
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT14;
		String actualBackGroundColor=pushnotificationpage.get_sucessAlertTextBackgroundColor();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	
	@Test(dataProvider="pushNotification",dataProviderClass=DataProviderClass.class)
	public void verify_AlertTextPushNotificationByDataProviderClass(String title, String description)
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.click_OnPushNotification();
		pushnotificationpage.enter_title(title);
		pushnotificationpage.enter_description(description);
		pushnotificationpage.click_onSendButton();
		pushnotificationpage.getText_SuccessAlertPushNotificationMessage();
	}
	
}
