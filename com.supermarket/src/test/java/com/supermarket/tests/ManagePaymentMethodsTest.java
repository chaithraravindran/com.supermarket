package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManagePaymentMethodsPage;

public class ManagePaymentMethodsTest extends Base
{
	LoginPage loginpage;
	ManagePaymentMethodsPage managepaymentmethodspage;
	@Test
	public void verify_ManagePaymentStatusDeactivation()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.click_OnDeactivate_StatusManagePaymentButton("debit card");
		Assert.assertTrue(managepaymentmethodspage.is_StatusAlertTextMessageDisplayed());
	}
	@Test
	public void verify_UpdateAdminUser()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		managepaymentmethodspage=new ManagePaymentMethodsPage(driver);
		managepaymentmethodspage.click_OnManagePaymentMethods();
		managepaymentmethodspage.edit_ActionManagePayment("debit card");
		managepaymentmethodspage.clear_Field();
		managepaymentmethodspage.update_Field("700");
		String expectedColor=Constants.EXPECTED_COLOR_ALERT_TEXT13;
		String actualColor=managepaymentmethodspage.get_colorAlertText();
		Assert.assertEquals(actualColor, expectedColor);
	}
}
