package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC05VerfiyWizard extends loginURL
{
	static int a;
	@Test(priority = 4)
	public void verifyWizardTC05() throws Exception
	{
//		webPart.webpartAdded();
//		webPart.menu();
//		webPart.EditWizard();
//		webPart.defaultTab();
//		webPart.closeWizard();
		
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		System.out.println("Webpart found: "+noOfWebpart);
		for(int i=1;i<=noOfWebpart;)
		{	
			a = i + 1;	
			WebElement myelement = driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ"+a+"')]"));
			webPart.menu(myelement);
			webPart.EditWizard(myelement);	
			webPart.defaultTab(myelement);
			webPart.closeWizard(myelement);
			i++;
		}
	}
}
