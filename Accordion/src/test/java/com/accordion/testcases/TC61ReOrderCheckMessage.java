package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Accordion.Accordion.deleteTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.reorderTab;
import Accordion.Accordion.webPart;

public class TC61ReOrderCheckMessage extends loginURL
{
	int a;
	@Test(priority = 9)
	public void ReOrderCheckMessageTC61() throws Exception
	{
//		reorderTab.reordertab();
//		reorderTab.reorderNoItemPresent();
		
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		System.out.println("Webpart found: "+noOfWebpart);
		for(int i=1;i<=noOfWebpart;)
		{	
			a = i + 1;	
			WebElement myelement = driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ"+a+"')]"));
			webPart.menu(myelement);
			webPart.EditWizard(myelement);
			reorderTab.reordertab(myelement);
			reorderTab.reorderNoItemPresent(myelement);
			webPart.closeWizard(myelement);
			i++;
		}
	}	
}
