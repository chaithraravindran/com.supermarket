package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	WebDriver driver;
	WebDriverWait webdriverwait;
	
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public static final long IMPLICIT_WAIT=10;
	public static final long PAGE_LOAD_WAIT=20;
public void element_ToBeClickable(long seconds,String xpath)
{
	webdriverwait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
	webdriverwait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
}
public void visibility_OfElementLocated(long seconds,String xpath)
{
	webdriverwait=new WebDriverWait(driver,Duration.ofSeconds(seconds));
	webdriverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
}

}

