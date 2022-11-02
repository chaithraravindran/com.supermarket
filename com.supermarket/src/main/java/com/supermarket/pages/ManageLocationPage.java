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
@FindBy(xpath="//button[@name='update']")
private WebElement updateButton;

@FindBy(xpath="//i[@class=' fa fa-search']")
private WebElement searchButton;
@FindBy(xpath="//button[@name='Search']")
private WebElement searchLocationButton;

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
public void click_OnUpdateButton()
{
	updateButton.click();
}
public void click_OnSearchButton()
{
	searchButton.click();
}
public void click_OnSearchListLocationsButton()
{
	pageutility.scroll_andClick(searchLocationButton);
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
public void deactivate_Location(String locationName)
{
	generalutility=new GeneralUtility(driver);
	List<String> locationNames=new ArrayList<String>();
	locationNames=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int j=0;
	for(j=0;j<locationNames.size();j++)
	{
		if(locationName.equals(locationNames.get(j)))
		{
			j++;
			break;
		}
	}
	WebElement statusButton=driver.findElement(By.xpath("//tbody//tr["+j+"]//td[5]//a"));
	statusButton.click();
}
public void edit_LocationDetails(String locationName)
{
	generalutility=new GeneralUtility(driver);
	List<String> locationNames=new ArrayList<String>();
	locationNames=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int j=0;
	for(j=0;j<locationNames.size();j++)
	{
		if(locationName.equals(locationNames.get(j)))
		{
			j++;
			break;
		}
	}
	WebElement editButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[6]//a)[1]"));
	editButton.click();
}
public void clear_Field()
{
	generalutility=new GeneralUtility(driver);
	generalutility.clear_Text(location);
}
public void update_Field(String Location)
{
	enter_Location(Location);
	click_OnUpdateButton();
}
public void delete_Location(String locationName)
{
	List<String> locationNames=new ArrayList<String>();
	generalutility=new GeneralUtility(driver);
	locationNames=generalutility.get_TextOfElements("//tbody//tr//td[1]");
	int j=0;
	for(j=0;j<locationNames.size();j++)
	{
		if(locationName.equals(locationNames.get(j)))
		{
			j++;
			break;
		}
	}
	WebElement deleteButton=driver.findElement(By.xpath("(//tbody//tr["+j+"]//td[6]//a)[2]"));
	deleteButton.click();
	driver.switchTo().alert().accept();
}
public void search_Location(String Location)
{
	choose_Country();
	choose_State();
	enter_Location(Location);
	click_OnSearchListLocationsButton();
}


public boolean searchListLocationButton_IsEnabled()
{
	generalutility=new GeneralUtility(driver);
	return generalutility.is_Enabled(searchLocationButton);
}

}
