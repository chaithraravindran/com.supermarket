package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.ExpenseCategoryPage;
import com.supermarket.pages.LoginPage;

public class ExpenseCategoryTest extends Base
{
	LoginPage loginpage;
	ExpenseCategoryPage expensecategorypage;
	
	@Test
	public void verify_AddTitle()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		expensecategorypage=new ExpenseCategoryPage(driver);
		expensecategorypage.click_OnManageExpense();
		expensecategorypage.click_OnExpenseCategory();
		expensecategorypage.click_OnNewButton();
		expensecategorypage.add_ExpenseCategoryInformations("Fruits12348");
		expensecategorypage.click_OnSaveButton();
		Assert.assertTrue(expensecategorypage.is_SucessAlertTextMessageDisplayed());
	}

}
