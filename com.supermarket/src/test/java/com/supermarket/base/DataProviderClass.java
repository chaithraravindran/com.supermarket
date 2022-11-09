package com.supermarket.base;

import org.testng.annotations.DataProvider;

import com.supermarket.utilities.Excel;

public class DataProviderClass 
{
	Excel excel;
	/*@DataProvider (name="pushNotification")
	public Object[][] pushNotificationDetails()
	{
		return new Object [][] {{"Fruits","Imported Fresh fruits arriving soon"},{"Ice Creams","Offers available"},{"Chocolates","Homemade chocolates availabe"}};
	}*/
	@DataProvider (name="PushNotificationExcelData")
	public Object[][] push_Notification()
	{
		excel=new Excel();
		excel.setExcelFile("PushNotification","PushNotificationsInformations");
		return excel.get_MultiDimensionalObjectArray(3, 2);
	}
	@DataProvider (name="manageExpense")
	public Object[][] manageExpenseDetails()
	{
		return new Object [][] {{"1000","Amount paid"},{"3000","Amount to be paid"},{"5000","Amount paid"}};
	}
	@DataProvider (name="adminUsers")
	public Object[][] adminUsersDetails()
	{
		return new Object [][] {{"Ann","anna6489"},{"Kim","kim598@"}};
	}
	
}
