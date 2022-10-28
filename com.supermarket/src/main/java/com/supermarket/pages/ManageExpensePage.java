package com.supermarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.PageUtility;

public class ManageExpensePage 
{
WebDriver driver;
PageUtility pageutility;
@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
private WebElement manageExpenseLink;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
private WebElement manageExpenseCheckBox;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;
@FindBy(xpath="//select[@id='user_id']")
private WebElement user;
@FindBy(xpath="//input[@id='ex_date']")
private WebElement date;
@FindBy(xpath="//td[@data-date='1665964800000']")
private WebElement selectedDate;
public ManageExpensePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnManageExpense()
{
	manageExpenseLink.click();
}
public void click_OnManageExpenseCheckBox()
{
	manageExpenseCheckBox.click();
}
public void click_OnNewButton()
{
	newButton.click();
}
public void selectUser()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(3,user);
}
public void click_OnDateField()
{
	date.click();
}
public void selectedDate()
{
	selectedDate.click();
}
/*public void selectDate(String Date)
{
	click_OnDateField();
	String splitArray[]=Date.split("/");
	String year=splitArray[2];
	String day=splitArray[0];
	int n=Integer.parseInt(splitArray[1]);  
	String month="";
	switch(n)
	{
	case 1: month="January";
	break;
	case 2: month="February";
	break;
	case 3: month="March";
	break;
	case 4: month="April";
	break;
	case 5: month="May";
	break;
	case 6: month="June";
	break;
	case 7: month="July";
	break;
	case 8: month="August";
	break;
	case 9: month="September";
	break;
	case 10: month="October";
	break;
	case 11: month="November";
	break;
	case 12: month="December";
	break;
	}
	System.out.println(day);
	System.out.println(month);
	System.out.println(year);
	WebElement prevButton=driver.findElement(By.xpath("//th[@class='prev']"));
	WebElement nextButton=driver.findElement(By.xpath("//th[@class='next']"));
	String month_year=month+" "+year;
	while(true)
	{
		String actualMonthYear=driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")).getText();//current month year displayed 
		if(actualMonthYear.equals(month_year))
		{
			break;
		}
		else if(n>10)//Here the current month is October ie., 10
		{
				nextButton.click();
		}
		else
		{
			prevButton.click();
		}
	}
	driver.findElement(By.xpath("//td[text()='"+day+"' and @class='day']")).click();//xpath of same days in a month
			 //(ie.,1st of every month, one is enabled and other is disabled b'coz it is the 1st of next month.

	}*/

}
