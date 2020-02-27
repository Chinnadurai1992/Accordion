package com.accordion.pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Accordion.Accordion.loginURL;

public class BaseClass extends loginURL
{
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeTest
	@Parameters("browser")
	public static void setApplication() throws Exception
	{
//		if(browser.equalsIgnoreCase("Chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", ".\\SeleniumDriver\\chromedriver.exe");
//			driver=new ChromeDriver();	
//			driver.manage().window().maximize();
//			driver.get("https://ngenioussolutions.sharepoint.com/sites/365AppzQA/QA1/Pages/AutomationTesting.aspx");
//		}
//		if(browser.equalsIgnoreCase("Edge"))
//		{
//			System.setProperty("webdriver.edge.driver", ".\\SeleniumDriver\\MicrosoftWebDriver.exe");
//			driver=new EdgeDriver();	
//			driver.get("https://ngenioussolutions.sharepoint.com/sites/365AppzQA/QA1/Pages/AutomationTesting.aspx");
//		}
//		if(browser.equalsIgnoreCase("IE"))
//		{
//			System.setProperty("webdriver.ie.driver", ".\\SeleniumDriver\\IEDriverServer.exe");
//			driver=new InternetExplorerDriver();	
//			driver.get("https://ngenioussolutions.sharepoint.com/sites/365AppzQA/QA1/Pages/AutomationTesting.aspx");
//		}
		
		loginURL.openChromeBrowser();
		loginURL.loginContentAdmin();
	}
	@AfterTest
	public void closetest() throws Exception
	{
		loginURL.closeChromeBrowser();
	}
}	
