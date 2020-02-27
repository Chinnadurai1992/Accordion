package com.accordion.utility;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.accordion.pages.BaseClass;

import Accordion.Accordion.loginURL;


public class Library extends BaseClass
{
	public static String captureScreenshot()
	{
		WebDriver driver = loginURL.driver;
		TakesScreenshot ts =(TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"\\Screenshot\\"+System.currentTimeMillis()+".png";
		File dest = new File(path);
		try
		{
			FileHandler.copy(srcfile,dest);
			System.out.println("Screenshot Captured");
		}
		catch (Exception e) 
		{
			System.out.println("Exception Occured while Taking Screenshot"+e.getMessage());
		}
		return path;
	}
}

