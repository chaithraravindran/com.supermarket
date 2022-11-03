package com.supermarket.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.DeliveryBoyPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;
import com.supermarket.utilities.Excel;


public class DeliveryBoyTest extends Base
{
	LoginPage loginpage;
	DeliveryBoyPage deliveryboypage;
	Excel excel=new Excel();
	@Test
	public void add_NewDeliveryBoy()
	{
		String name;
		String email;
		String phoneNumber;
		String address;
		String userName;
		String passWord;
		excel.setExcelFile("Delivery Boy Details","DeliveryBoyInformations");
		name=excel.getCellData(0,0);
		email=excel.getCellData(0,1);
		phoneNumber=excel.getCellData(0,2);
		address=excel.getCellData(0,3);
		userName=excel.getCellData(0,4);
		passWord=excel.getCellData(0,5);
		
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails(name,email,phoneNumber,address,userName,passWord);
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT1;
		String actualBackGroundColor=deliveryboypage.get_alertTextBackgroundColor();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	@Test
	public void verify_addNewDeliveryBoyAlertMessageIsDisplayed()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails("Paddy","paddy123@gmail","9366931523","Nest","paddy189","lis4686");
		Assert.assertTrue(deliveryboypage.is_alertTextMessageDisplayed());
	}
	@Test
	public void verify_alertMessageFontColor()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails("Anoop","anu123@gmail","9856987523","gdgsfsbytf","kdrcfd5987","whhfdd");
		String expectedColor=Constants.EXPECTED_COLOR_ALERT_TEXT2;
		String actualColor=deliveryboypage.get_colorAlertText();
		Assert.assertEquals(actualColor, expectedColor);
	}
	@Test
	public void verify_manageDeliveryBoyStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.deactivate_deliveryBoy("Suju");
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT3;
		String actualBackGroundColor=deliveryboypage.get_sucessAlertTextBackgroundColor();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	@Test
	public void verify_deleteDeliveryBoy()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.deleteDeliveryBoy("James");
		String expectedFontSize=Constants.EXPECTED_FONT_SIZE_ALERT_TEXT4;
		String actualFontSize=deliveryboypage.get_successAlertTextFontSize();
		Assert.assertEquals(actualFontSize, expectedFontSize);
	}
	@Test(groups= {"smoke","sanity"})
	public void verify_UpdateDeliveryBoy()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.edit_DeliveryBoy("Anoopa");
		deliveryboypage.clear_Field();
		deliveryboypage.update_Field("anoopa123@gmail.com");
		Assert.assertTrue(deliveryboypage.is_UpdateButtonEnabled());
		//deliveryboypage.click_OnUpdateButton();
	}
	
	
}
