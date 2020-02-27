package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Accordion.Accordion.deleteTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC54DeleteCheckMessage extends loginURL
{
	int a;
	@Test(priority = 8)
	public void DeleteCheckMessageTC54() throws Exception
	{
//		deleteTab.deletetab();
//		deleteTab.deleteNoItemPresent();
		
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		System.out.println("Webpart found: "+noOfWebpart);
		for(int i=1;i<=noOfWebpart;)
		{	
			a = i + 1;	
			WebElement myelement = driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ"+a+"')]"));
			webPart.menu(myelement);
			webPart.EditWizard(myelement);
			deleteTab.deletetab(myelement);
			deleteTab.deleteNoItemPresent(myelement);
			webPart.closeWizard(myelement);
			i++;
		}
	}	
}
