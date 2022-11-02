package com.supermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider (name="pushNotification")
	public Object[][] pushNotificationDetails()
	{
		return new Object [][] {{"Fruits","Imported Fresh fruits arriving soon"},{"Ice Creams","Offers available"},{"Chocolates","Homemade chocolates availabe"}};
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
