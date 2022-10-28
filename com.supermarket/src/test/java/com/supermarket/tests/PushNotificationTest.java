package com.supermarket.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.PdfReader;

public class PushNotificationTest extends Base
{
	LoginPage loginpage;
	Excel excel=new Excel();
	//PdfReader pdfreader;
	PushNotificationPage pushnotificationpage;
	@Test
	public void verify_SuccessAlertPushNotification()
	{
		String titleField;
		String descriptionField;
		excel.setExcelFile("PushNotifications", "PushNotificationsInformations");
		titleField=excel.getCellData(0,1);
		descriptionField=excel.getCellData(1,1);
		//HashMap<String, String> map=new HashMap<String, String>();
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage=new PushNotificationPage(driver);
		
		//pushnotificationpage.getText_SucessAlertPushNotification("Anu","Software Testing");
		//System.out.println(pushnotificationpage.getText_SucessAlertPushNotification("Anu","Software Testing"));
		
		//pdfreader=new PdfReader();
		//map=pdfreader.read_PdfData("calendar");
		//System.out.println(map.get("title1"));
		//System.out.println(map);
		pushnotificationpage.add_PushNotificationsInformations(titleField,descriptionField);
		
		//String actualAlertMessage=pushnotificationpage.getText_SucessAlertPushNotificationMessage();
		//System.out.println("The actual alert message is:" +actualAlertMessage);
		//String expectedAlertMessage=Constants.EXPECTED_ALERT_TEXT;
		//Assert.assertEquals(actualAlertMessage, expectedAlertMessage,"This testcase failed");	
	}
	//@Test(dataProvider="")
}
