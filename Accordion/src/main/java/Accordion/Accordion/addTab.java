package Accordion.Accordion;

import java.io.FileInputStream;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class addTab extends loginURL
{
	static HashMap<String , String> hashmap = new HashMap<String, String>();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	public static void addtab(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("tabAdd"))));
		parent.findElement(By.id("tabAdd")).click();
		System.out.println("Add Tab Clicked");
	}
	public static void addClosebtn(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnNoOfItemToAdd"))));
		parent.findElement(By.id("btnNoOfItemToAdd")).click();
		System.out.println("Add close button clicked");
	}
	public static void addNextbtn_TopicToAddBlank(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtNoOfItems"))));
		String inputTopic=parent.findElement(By.id("txtNoOfItems")).getText();
		if(inputTopic.isEmpty())
		{
			wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnItemsToAddNext"))));
			parent.findElement(By.id("btnItemsToAddNext")).click();
			String act_topicsBlank = parent.findElement(By.id("validator_txtNoOfItems")).getText();
			String exp_topicsblank = "Please enter valid number.";
			Assert.assertEquals(act_topicsBlank, exp_topicsblank);
			System.out.println("Verified the Validation message of TopicToAdd field on blank");
		}
	}
	public static void addNextbtn_TopicToAddZero(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtNoOfItems"))));
		parent.findElement(By.id("txtNoOfItems")).sendKeys("0");

		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnItemsToAddNext"))));
		parent.findElement(By.id("btnItemsToAddNext")).click();
		String act_topicsZero = parent.findElement(By.id("validator_txtNoOfItems")).getText();
		String exp_topicsZero = "Please enter valid number.";
		Assert.assertEquals(act_topicsZero, exp_topicsZero);
		System.out.println("Verified the Validation message of TopicToAdd field on Zero");
	}
	public static void addNextbtn_TopicToAddNumber(WebElement parent) throws Exception
	{

		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtNoOfItems"))));
		WebElement NoOfItemsEntered = parent.findElement(By.id("txtNoOfItems"));
		NoOfItemsEntered.sendKeys("11");
		hashmap.put("Key_NoOfItemsEntered","11");

		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnItemsToAddNext"))));
		parent.findElement(By.id("btnItemsToAddNext")).click();
		System.out.println("Next button clicked");
	}
	public static void addTopicTitleBlank(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtTopicTitle"))));
		String TopicTitle = parent.findElement(By.id("txtTopicTitle")).getText();
		if(TopicTitle.isEmpty())
		{
			addSaveContinue(parent);
			wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("validator_txtTopicTitle"))));
			String act_TopicTitleValdation = parent.findElement(By.id("validator_txtTopicTitle")).getText();
			String exp_TopicTitleValdation = "Please specify topic title.";
			Assert.assertEquals(act_TopicTitleValdation, exp_TopicTitleValdation);
			System.out.println("Verified Validation message of Topic Title");
		}
	}
	public static void addTopicDescriptionBlank(WebElement parent) throws Exception
	{
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div"))));
		String TopicDescription = parent.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).getText();
		if(TopicDescription.isEmpty())
		{
			addSaveContinue(parent);
			wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("validator_txtTopicDescription"))));
			String act_TopicDesValdation = parent.findElement(By.id("validator_txtTopicDescription")).getText();
			String exp_TopicDesValdation = "Please specify topic description.";
			Assert.assertEquals(act_TopicDesValdation, exp_TopicDesValdation);
			System.out.println("Verified Validation message of Topic Description");
		}
	}
	public static void addSaveContinue(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnCreateItem"))));
		parent.findElement(By.id("btnCreateItem")).click();
		System.out.println("Save Continue Button clicked");
	}
	public static void addCancelbtn(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnCloseAdd"))));
		parent.findElement(By.id("btnCloseAdd")).click();

		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("tabAdd"))));
		String act_addtab = parent.findElement(By.id("tabAdd")).getText();
		String exp_addtab = "Add";
		Assert.assertEquals(act_addtab, exp_addtab);
		System.out.println("Cancel Button Clicked");
	}
	public static void additem(WebElement parent) throws Exception
	{
		Thread.sleep(3000);
		String countvalue = hashmap.get("Key_NoOfItemsEntered");
		int count = Integer.parseInt(countvalue);
	
		FileInputStream fi=new FileInputStream(".\\DataSheet\\AccordionDataContent.xlsx");		//Access the Excel Sheet
		XSSFWorkbook wk=new XSSFWorkbook(fi);			//Open the Workbook of the Excel sheet
		XSSFSheet sh=wk.getSheet("addData");			//Access the Sheet from WorkBook
		XSSFRow rw=sh.getRow(0);
		XSSFCell title=null;
		XSSFCell description=null;
		int col_title=0;	
		int col_des=0;
		
		for(int j=1;j<=count;j++)	/* Calculate the Row count */ //sh.getLastRowNum()
		{	
			for(int k=1;k<rw.getLastCellNum();k++)	/* Calculate the column count */
			{
				if(rw.getCell(k).getStringCellValue().trim().equals("Topic Title"))
				{
					col_title=k;
				}
				if(rw.getCell(k).getStringCellValue().trim().equals("Topic Description"))
				{
					col_des=k;
				}
				rw=sh.getRow(j);
				Thread.sleep(3000);
				String checkTitle=parent.findElement(By.id("txtTopicTitle")).getText();
				if(checkTitle.isEmpty())
				{
					title=rw.getCell(col_title);
					String Title=String.valueOf(title.getStringCellValue());
					wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtTopicTitle"))));
					parent.findElement(By.id("txtTopicTitle")).sendKeys(Title);
					
					description=rw.getCell(col_des);
					String Description=String.valueOf(description.getStringCellValue());
					Thread.sleep(4000);
			//		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div"))));
					parent.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).sendKeys(Description);
					
					Thread.sleep(3000);
					if(j==count) //Checking last Item Save button 
					{
						Thread.sleep(2000);
						if(parent.findElement(By.id("btnCreateItem")).isDisplayed())
						{
							Assert.assertTrue(true);
						}
					}
					addSaveContinue(parent);
				}
			}
		}
		wk.close();
		
	}
	public static void addSaveCloseBtn() throws Exception
	{
		Thread.sleep(2000);
		String act_successMsg = driver.findElement(By.id("userMessage")).getText();
		String exp_successMsg = "New Topic(s) saved successfully.";
		Assert.assertEquals(act_successMsg, exp_successMsg);
		Thread.sleep(2000);
		driver.findElement(By.id("btnCloseUserMsg")).click();
	}
	public static void addAppPreview(WebElement parent) throws Exception
	{
		Thread.sleep(3000);
		if(parent.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).isDisplayed())
		{
			Thread.sleep(3000);
			int data=parent.findElements(By.xpath("//*[@id='cssmenu']/ul")).size();
			for(int j=1;j<=data;j++)
			{
				Thread.sleep(2000);
				WebElement preview = parent.findElement(By.xpath("//*[@id='cssmenu']/ul["+j+"]/li/a"));
				if(!preview.isSelected())
				{
					Thread.sleep(2000);
					parent.findElement(By.xpath("//*[@id='cssmenu']/ul["+j+"]/li/a")).click();
				}
			}	
		}
	}
	public static void addScreen(WebElement parent) throws Exception
	{
		if(parent.findElement(By.id("txtTopicTitle")).isDisplayed())
		{
			parent.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).isDisplayed();
			parent.findElement(By.id("btnCloseAdd")).isDisplayed();
			parent.findElement(By.id("btnCreateItem")).isDisplayed();
		}
		else
		{
			System.out.println("Fields not found");
		}
		System.out.println("Add Screen page is displayed");
	}
	public static void addScreenCount(WebElement parent) throws Exception
	{
	//	Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("totalItemsToAdd"))));
		String act_addScrrenCount = parent.findElement(By.id("totalItemsToAdd")).getText();
		String exp_addScreenCount = hashmap.get("Key_NoOfItemsEntered");
		Assert.assertEquals(act_addScrrenCount,exp_addScreenCount);
		System.out.println("Screen count verified");
	}
	public static void addAssignedTopic() throws Exception
	{
		Thread.sleep(2000);
		String act_assignedtopic = driver.findElement(By.id("lblAssignedSlots")).getText();
		System.out.println("Assigned Topic: "+act_assignedtopic);
		String exp_assignedtopic = hashmap.get("Key_NoOfItemsEntered");
		int assignedtopic = Integer.parseInt(exp_assignedtopic);
		System.out.println("Expected Topic found: "+assignedtopic);
		Assert.assertEquals(act_assignedtopic, assignedtopic);
	}
}
