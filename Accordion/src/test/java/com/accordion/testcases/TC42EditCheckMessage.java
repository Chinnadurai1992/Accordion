package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC42EditCheckMessage extends loginURL 
{
	int a;
	@Test(priority = 7 )
	public void EditCheckMessageTC42() throws Exception
	{
//		editTab.edittab();
//		editTab.editNoitemPresent();
		
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		System.out.println("Webpart found: "+noOfWebpart);
		for(int i=1;i<=noOfWebpart;)
		{	
			a = i + 1;	
			WebElement myelement = driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ"+a+"')]"));
			webPart.menu(myelement);
			webPart.EditWizard(myelement);
			editTab.edittab(myelement);
			editTab.editNoitemPresent(myelement);
			webPart.closeWizard(myelement);
			i++;
		}
	}	

}
