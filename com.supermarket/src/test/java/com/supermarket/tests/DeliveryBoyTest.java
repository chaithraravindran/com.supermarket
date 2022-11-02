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
	}
	@Test
	public void verify_addNewDeliveryBoyAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails("Paddy","paddy123@gmail","9366931523","Nest","paddy189","lis4686");
		String expectedResult=Constants.EXPECTED_ALERT_TEXT1;
		String actualResult=deliveryboypage.get_alertTextMessage();
		System.out.println("The actual text alert message:" +actualResult);
		Assert.assertEquals(actualResult, expectedResult,"This testcase failed");
	}
	@Test
	public void verify_existingDeliveryBoyAlertMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails("Anoop","anu123@gmail","9856987523","gdgsfsbytf","kdrcfd5987","whhfdd");
		String expectedResult=Constants.EXPECTED_ALERT_TEXT1;
		String actualResult=deliveryboypage.get_alertTextMessage();
		System.out.println("The actual text alert message:" +actualResult);
		Assert.assertEquals(actualResult, expectedResult,"This testcase failed");
	}
	@Test
	public void verify_alertMessageFontColor()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.create_DeliveryBoyDetails("Anoop","anu123@gmail","9856987523","gdgsfsbytf","kdrcfd5987","whhfdd");
		deliveryboypage.get_alertTextMessage();
		String actualColor=deliveryboypage.get_colorAlertText();
		String expectedColor="rgba(255, 255, 255, 1)";
		Assert.assertEquals(actualColor, expectedColor);
	}
	@Test
	public void verify_manageDeliveryBoyStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.deactivate_deliveryBoy("ann");
	}
	@Test
	public void verify_deleteDeliveryBoy()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.deleteDeliveryBoy("Aimy");
	}
	@Test(groups= {"smoke","sanity"})
	public void verify_UpdateDeliveryBoy()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		deliveryboypage=new DeliveryBoyPage(driver);
		deliveryboypage.click_OnDeliveryBoy();
		deliveryboypage.edit_DeliveryBoy("Paddy");
		deliveryboypage.clear_Field();
		deliveryboypage.update_Field("paddy123@gmail.com");
	}
	
	
}
