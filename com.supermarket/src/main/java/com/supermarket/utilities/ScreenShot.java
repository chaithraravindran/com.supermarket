package com.supermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot 
{
TakesScreenshot takesscreenshot;
public void take_screen_Shot(WebDriver driver, String imageName)
{
	try
	{
		takesscreenshot=  (TakesScreenshot) driver;
		File screenshotfile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp=new SimpleDateFormat("dd_MM-yyyy_hh_mm_ss").format(new Date());
		String destination=System.getProperty("user.dir")+"\\Screenshots\\"+imageName+timeStamp+".png";
		File finalDestination=new File(destination);
		FileHandler.copy(screenshotfile,finalDestination);
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
}
}
