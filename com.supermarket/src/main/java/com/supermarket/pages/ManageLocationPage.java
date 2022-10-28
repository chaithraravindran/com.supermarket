package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageLocationPage 
{
WebDriver driver;
PageUtility pageutility;
GeneralUtility generalutility;

@FindBy(xpath="//i[@class='nav-icon fas fa-map-marker']")
private WebElement manageLocationLink;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
private WebElement newButton;
@FindBy(xpath="//select[@id='country_id']")
private WebElement country;
@FindBy(xpath="//select[@id='st_id']")
private WebElement state;
@FindBy(xpath="//input[@id='location']")
private WebElement location;
@FindBy(xpath="//input[@id='delivery']")
private WebElement deliveryCharge;
@FindBy(xpath="//button[text()='Save']")
private WebElement saveButton;
@FindBy(xpath="//a[@type='button']")
private WebElement cancelButton;

public ManageLocationPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void click_OnManageLocation()
{
	manageLocationLink.click();
}
public void click_OnNewButton()
{
	newButton.click();
}
public void choose_Country()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByVisibleText("United Kingdom",country);
}
public void choose_State()
{
	pageutility=new PageUtility(driver);
	pageutility.select_ByIndex(5,state);
}
public void enter_Location(String Location)
{
	location.sendKeys(Location);
}
public void enter_DeliveryCharge(String DeliveryCharge)
{
	deliveryCharge.sendKeys(DeliveryCharge);
}
public void click_OnSaveButton()
{
	saveButton.click();
}
public void click_OnCancelButton()
{
	cancelButton.click();
}
public void enterLocationDetails(String Location,String DeliveryCharge)
{
	click_OnManageLocation();
	click_OnNewButton();
	choose_Country();
	choose_State();
	enter_Location(Location);
	enter_DeliveryCharge(DeliveryCharge);
	click_OnSaveButton();
}
public void enterLocationDetails_ClickCancel(String Location,String DeliveryCharge)
{
	click_OnManageLocation();
	click_OnNewButton();
	choose_Country();
	choose_State();
	enter_Location(Location);
	enter_DeliveryCharge(DeliveryCharge);
	click_OnCancelButton();
}
public void deactivate_Location(String placeName)
{
	generalutility=new GeneralUtility(driver);
	List<String> placeNames=new ArrayList<String>();
	placeNames=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int j=0;
	for(j=0;j<placeNames.size();j++)
	{
		if(placeName.equals(placeNames.get(j)))
		{
			j++;
			break;
		}
	}
	WebElement statusButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[5]//a"));
	statusButton.click();
}

}
