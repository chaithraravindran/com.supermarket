package com.supermarket.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.DeliveryBoyPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;


public class DeliveryBoyTest extends Base
{
	LoginPage loginpage;
	DeliveryBoyPage deliveryboypage;
	Excel excel=new Excel();
	GeneralUtility generalutility;
	SoftAssert softassert;
	
	@Test(priority=2)
	public void verify_add_NewDeliveryBoy()
	{
		excel.setExcelFile("Delivery Boy Details","DeliveryBoyInformations");
		String name=excel.getCellData(0,0);
		String email=excel.getCellData(0,1);
		String phoneNumber=excel.getCellData(0,2);
		String address=excel.getCellData(0,3);
		String userName=excel.getCellData(0,4);
		String passWord=excel.getCellData(0,5);
		
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
		String timeStamp=generalutility.get_TimeStamp();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails("Paddy_"+timeStamp,"paddy123@gmail","9366931523","Nest","paddy189_"+timeStamp,"lis4686");
		Assert.assertTrue(deliveryboypage.is_SucessAlertTextMessageDisplayed());
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
		deliveryboypage.deactivate_deliveryBoy("Terry");
		String expectedAlertValue=Constants.EXPECTED_DEACTIVATION_STATUS_ALERT;
		String actualAlertValue=deliveryboypage.visibilityOfAlertMessage();
		Assert.assertEquals(actualAlertValue, expectedAlertValue);
	}
	@Test
	public void verify_deleteDeliveryBoy()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.deleteDeliveryBoy("ann");
		deliveryboypage.click_OnSearchButton();
		deliveryboypage.enter_NameSearchDeliveryBoy("ann");
		deliveryboypage.click_OnSearchButtonSearchDeliveryBoy();
		Assert.assertTrue(deliveryboypage.searchedDeliveryBoy_IsDisplayed());
	}
	@Test(groups= {"smoke","sanity"})
	public void verify_UpdateDeliveryBoy()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		softassert=new SoftAssert();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.edit_DeliveryBoy("Max08_11_2022_11_10_08");
		deliveryboypage.clear_Field();
		deliveryboypage.update_Field("max123@gmail.com");
		deliveryboypage.click_OnUpdateButton();
		String expectedAlertValue=Constants.EXPECTED_UPDATED_ALERT_TEXT;
		String actualAlertValue=deliveryboypage.visibilityOfAlertMessage();
		softassert.assertEquals(actualAlertValue, expectedAlertValue);
	}
	@Test(priority=1)
	public void verify_newDeliveryBoyCreation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		String timeStamp=generalutility.get_TimeStamp();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails("Paddy_"+timeStamp,"paddy123@gmail","9366931523","Nest","paddy189_"+timeStamp,"lis4686");
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT5;
		String actualBackGroundColor=deliveryboypage.get_sucessAlertTextBackgroundColor();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	
}
