package com.supermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider (name="pushNotification")
	public Object[][] pushNotificationDetails()
	{
		return new Object [][] {{"Fruits","Imported Fresh fruits arriving soon"},{"Ice Creams","Offers available"},{"Chocolates","Homemade chocolates availabe"}};
	}
}
