package com.accordion.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Accordion.Accordion.addTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.manageTitleTab;
import Accordion.Accordion.webPart;

public class TC16ManageTitleCheckValueOnPreviewWhen10SelectedInNumberOfTopicToShow extends loginURL
{
	int a;
	@Test(priority = 28)
	public void ManageTitleCheckValueOnPreviewWhen10SelectedInNoOfTopicToShowTC16() throws Exception
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
			manageTitleTab.managetitleNoOfTopicToShow10(myelement);
			manageTitleTab.managetitleSavebtn(myelement);
			manageTitleTab.managetitleSaveClosebtn(myelement);
			manageTitleTab.managetitleClosebtn(myelement);
			addTab.addAppPreview(myelement);
			i++;
		}
	}	
	@Test(priority = 29)
	public void ManageTitleCheckValueOnPreviewWhen05SelectedInNoOfTopicToShow() throws Exception
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
			manageTitleTab.managetitleNoOfTopicToShow5(myelement);
			manageTitleTab.managetitleSavebtn(myelement);
			manageTitleTab.managetitleSaveClosebtn(myelement);
			manageTitleTab.managetitleClosebtn(myelement);
			addTab.addAppPreview(myelement);
			i++;
		}
	}	
}
