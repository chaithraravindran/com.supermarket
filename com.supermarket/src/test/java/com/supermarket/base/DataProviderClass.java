package com.supermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider (name="LoginDetails")
	public Object[][] emailpass()
	{
		return new Object [][] {{"ravindranchaithra@gmail.com","Annu1234$$"},{"vaishak.mr@gmail.com","agfil184"},{"admin","admin"}};
	}
}
