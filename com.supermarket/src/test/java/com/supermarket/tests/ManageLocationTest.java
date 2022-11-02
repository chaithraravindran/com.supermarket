package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
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
	}
	@Test
	public void verify_LocationStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.click_OnManageLocation();
		managelocationpage.deactivate_Location("kerala");
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
	}
	@Test
	public void verify_DeleteLocation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.click_OnManageLocation();
		managelocationpage.delete_Location("kerala");
	}
	@Test
	public void verify_searchLocation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managelocationpage=new ManageLocationPage(driver);
		managelocationpage.click_OnManageLocation();
		managelocationpage.click_OnSearchButton();
		managelocationpage.search_Location("kerala");
		Assert.assertTrue(managelocationpage.searchListLocationButton_IsEnabled());
		
	}
}
