package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.accordion.pages.BaseClass;
import Accordion.Accordion.webPart;

public class TC01verifyDefaultMessageOnContentAdmin extends BaseClass 
{
	static int a;
	@Test(priority = 1)
	public void verifyDefualtMsgOnContentAdminTC01() throws Exception
	{
//		webPart.webpartAdded();
//		webPart.webpartDefaultMsgContentAdmin();
		
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		for(int i=1;i<=noOfWebpart;)
		{	
			a = i + 1;
			WebElement myelement = driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ"+a+"')]"));
			webPart.webpartDefaultMsgContentAdmin(myelement);
			i++;
		}
	}	
}
