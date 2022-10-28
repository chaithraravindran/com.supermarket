package com.supermarket.tests;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManagePaymentMethodsPage;

public class ManagePaymentMethodsTest extends Base
{
	LoginPage loginpage;
	ManagePaymentMethodsPage managepaymentmethodspage;
	@Test
	public void update_ManagePaymentMethods()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.updatePaymentMethods();
	}
}
