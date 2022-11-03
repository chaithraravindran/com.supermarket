package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.DeliveryBoyPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.pages.ManageLocationPage;
import com.supermarket.utilities.Excel;

public class ManageLocationTest extends Base
{
	LoginPage loginpage;
	Excel excel=new Excel();
	ManageLocationPage managelocationpage;
	@Test
	public void add_Locations()
	{
		String location;
		String deliveryCharge;
		excel.setExcelFile("Manage Location Details", "EnterLocationInformations");
		location=excel.getCellData(0,0);
		deliveryCharge=excel.getCellData(0,1);
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.enterLocationDetails(location,deliveryCharge);
		String expectedColor=Constants.EXPECTED_COLOR_ALERT_TEXT9;
		String actualColor=managelocationpage.get_colorAlertText();
		Assert.assertEquals(actualColor, expectedColor);
	}
	@Test
	public void add_LocationsClickCancel()
	{
		String location;
		String deliveryCharge;
		excel.setExcelFile("Manage Location Details", "EnterLocationInformations");
		location=excel.getCellData(0,0);
		deliveryCharge=excel.getCellData(0,1);
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.enterLocationDetails_ClickCancel(location,deliveryCharge);
		String expectedText=Constants.EXPECTED_TEXT10;
		String actualText=managelocationpage.get_TextNewButton();
		Assert.assertEquals(actualText, expectedText);
	}
	@Test
	public void verify_LocationStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.click_OnManageLocation();
		managelocationpage.deactivate_Location("kerala");
		String expectedBackGroundColor=Constants.EXPECTED_BACKGROUND_COLOR_ALERT_TEXT11;
		String actualBackGroundColor=managelocationpage.get_sucessAlertTextBackgroundColor();
		Assert.assertEquals(actualBackGroundColor, expectedBackGroundColor);
	}
	@Test
	public void verify_UpdateLocationDetails()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.click_OnManageLocation();
		managelocationpage.edit_LocationDetails("Street7");
		managelocationpage.clear_Field();
		managelocationpage.update_Field("India");
		Assert.assertTrue(managelocationpage.is_alertTextMessageDisplayed());
	}
	@Test
	public void verify_DeleteLocation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.click_OnManageLocation();
		managelocationpage.delete_Location("kerala");
		String expectedFontSize=Constants.EXPECTED_FONT_SIZE_ALERT_TEXT12;
		String actualFontSize=managelocationpage.get_alertTextFontSize();
		Assert.assertEquals(actualFontSize, expectedFontSize);
	}
	@Test
	public void verify_searchLocation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.click_OnManageLocation();
		managelocationpage.click_OnSearchButton();
		managelocationpage.search_Location("India");
		Assert.assertTrue(managelocationpage.searchListLocationButton_IsEnabled());
		
	}
}
