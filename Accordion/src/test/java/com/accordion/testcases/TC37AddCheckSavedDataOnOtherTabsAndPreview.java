package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Accordion.Accordion.addTab;
import Accordion.Accordion.deleteTab;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.reorderTab;
import Accordion.Accordion.webPart;

public class TC37AddCheckSavedDataOnOtherTabsAndPreview extends loginURL
{
	int a;
	@Test(priority = 27)
	public void AddCheckSavedDataOnOtherTabsAndPreviewTC37() throws Exception
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
			addTab.addtab(myelement);
			addTab.addNextbtn_TopicToAddNumber(myelement);
			addTab.additem(myelement);
			editTab.edittab(myelement);
			editTab.editItemCount(myelement);
			deleteTab.deletetab(myelement);
			deleteTab.deleteItemCount(myelement);
			reorderTab.reordertab(myelement);
			reorderTab.reorderItemCount(myelement);
			webPart.closeWizard(myelement);
			addTab.addAppPreview(myelement);
			i++;
		}
	}	
}
