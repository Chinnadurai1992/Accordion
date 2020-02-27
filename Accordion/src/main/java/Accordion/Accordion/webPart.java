package Accordion.Accordion;

import javax.swing.plaf.synth.SynthStyle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class webPart extends loginURL
{
	static int a=0;
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	public static void webpartAdded() throws Exception
	{
		Thread.sleep(3000);
		int noOfWebpart=driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).size(); // FIND THE NUMBER OF WEBPART PRESENT IN A PAGE 
		for(int i=0;(i<=noOfWebpart-1 && a <=noOfWebpart - 1);)
		{	
			driver.findElements(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).get(a);
			a = i + 1;
			i++;
			break;
		}
	}	
	public static void webpartDefaultMsgContentAdmin(WebElement parent) throws Exception
	{
		System.out.println("Webpart: "+a);		
		
		String actualURL = parent.findElement(By.id("appPreview")).getText();
		String expected = "Please configure app. Click on \"Edit\" to configure.\nNo content exist to display.";
		Assert.assertEquals(actualURL, expected);
		System.out.println("Verified Default Message "+a);
	}
	public static void webpartDefaultMsgNormalUser() throws Exception
	{
	//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("appPreview"))));
		Thread.sleep(4000);
		String actualURL = driver.findElement(By.id("appPreview")).getText();
		String expected = "No content exist to display.";
		Assert.assertEquals(actualURL, expected);
	}
	public static void menu(WebElement parent) throws Exception
	{
	//	Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("showEditMenu"))));
		parent.findElement(By.id("showEditMenu")).click();
		System.out.println("Menu Clicked");
		
		Thread.sleep(3000);
		String actualEdit = parent.findElement(By.id("editPopUp")).getText(); 
		String expectedEdit = "Edit";
		Assert.assertEquals(actualEdit, expectedEdit); 
//		System.out.println("Verfied Edit text");
		
		String actualHelp = parent.findElement(By.id("helpPopUp")).getText();
		String expectedHelp = "Help";
		Assert.assertEquals(actualHelp, expectedHelp);
//		System.out.println("Verfied Help text");
	}
	public static void closeMenu(WebElement parent) throws Exception
	{
		System.out.println( "values of a in Menu - " + a);
		parent.findElement(By.id("showEditMenu")).click();
		System.out.println("Menu Closed");
	}
	public static void EditWizard(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("editPopUp"))));
		parent.findElement(By.id("editPopUp")).click();
		System.out.println("Edit Wizard Opened");
	}
	public static void helpWizard(WebElement parent ) throws Exception
	{
		Thread.sleep(2000);
		parent.findElement(By.id("showEditMenu")).click();
		
		Thread.sleep(2000);
		parent.findElement(By.id("helpPopUp")).click();
		closeHelpWizard(parent);
	}
	public static void closeWizard(WebElement parent) throws Exception
	{
		Thread.sleep(2000);
		parent.findElement(By.id("btnClose")).click();
		System.out.println("Edit Wizard Closed");
	}
	public static void defaultTab(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("tabManageTitle"))));
		System.out.println("Default Tab found");
		String actualManageTitle = parent.findElement(By.id("tabManageTitle")).getText();
		String expectedManageTitle = "Manage Title";
	
		Assert.assertEquals(actualManageTitle, expectedManageTitle);
		System.out.println("Default tab verified");
	}
	public static void tabscount(WebElement parent) throws Exception
	{
		int nooftabs = parent.findElements(By.className("listGrpItem_edbd4f93")).size();		
		System.out.println("Tabcount: "+nooftabs);
		for(int j=1;j<nooftabs;j++)
		{
			Thread.sleep(3000);
			//parent.findElements(By.xpath("//*[starts-with(@class,'listGrpItem_edbd4f93')]")).get(j).click();
			parent.findElements(By.className("listGrpItem_edbd4f93")).get(j).click();
			System.out.println("Tabs verified: "+j);
		}
	}
	public static void closeHelpWizard(WebElement parent) throws Exception
	{
		Thread.sleep(3000);
		
		parent.findElement(By.id("btnHelpClose")).click();
		System.out.println("Help Wizard closed");
	}

}
