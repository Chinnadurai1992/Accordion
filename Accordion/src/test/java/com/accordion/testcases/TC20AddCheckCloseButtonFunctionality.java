package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Accordion.Accordion.addTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC20AddCheckCloseButtonFunctionality extends loginURL
{
	int a;
	@Test(priority = 18)
	public void AddCheckCloseButtonFunctionalityTC20() throws Exception
	{
//		webPart.webpartAdded();
//		webPart.menu();
//		webPart.EditWizard();
//		addTab.addtab();
//		addTab.addClosebtn();
		
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		System.out.println("Webpart found: "+noOfWebpart);
		for(int i=1;i<=noOfWebpart;)
		{	
			a = i + 1;	
			WebElement myelement = driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ"+a+"')]"));
			webPart.menu(myelement);
			webPart.EditWizard(myelement);
			addTab.addtab(myelement);
			addTab.addClosebtn(myelement);
			i++;
		}
	}	
}
