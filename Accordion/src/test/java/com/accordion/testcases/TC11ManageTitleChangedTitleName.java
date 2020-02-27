package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.manageTitleTab;
import Accordion.Accordion.webPart;

public class TC11ManageTitleChangedTitleName extends loginURL
{
	int a;
	@Test(priority = 14)
	public void ManageTitleChangedTitleNameTC11() throws Exception
	{	
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		System.out.println("Webpart found: "+noOfWebpart);
		for(int i=1;i<=noOfWebpart;)
		{	
			a = i + 1;	
			WebElement myelement = driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ"+a+"')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", myelement);
			webPart.menu(myelement);
			webPart.EditWizard(myelement);
			manageTitleTab.managetitleTab(myelement);
			manageTitleTab.managetitleAppTitle(myelement);
			i++;
		}
	}	

}
