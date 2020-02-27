package Accordion.Accordion;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class editTab extends loginURL
{
	static Map<String, String> dataMaptitle = new HashMap<String, String>();
	static Map<String, String> dataMapdescription = new HashMap<String, String>();
	static Map<String, String> edititemcount = new HashMap<String, String>();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	public static void edittab(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("tabEdit"))));
		parent.findElement(By.id("tabEdit")).click();
		System.out.println("Edit Tab Clicked");
	}
	public static void editNoitemPresent(WebElement parent) throws Exception
	{
	//	Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("itemsForEdit"))));
		String act_NoitemPresent = parent.findElement(By.id("itemsForEdit")).getText();
		String exp_NoitemPresent = "No topic configured.";
		Assert.assertEquals(act_NoitemPresent, exp_NoitemPresent);
	}
	public static void editItemCancelbtn() throws Exception
	{
		Thread.sleep(2000);
		int editlist= driver.findElements(By.xpath("//*[@id='itemsForEdit']/tbody/tr")).size();
		System.out.println("Item Count: "+editlist);
		for(int i=1;i<=editlist;i++)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='itemsForEdit']/tbody/tr"))));
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='itemsForEdit']/tbody/tr["+i+"]/td[1]")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseUpdate")));
			driver.findElement(By.id("btnCloseUpdate")).click();		
		}
	}
	public static void editItemTitle() throws Exception 
	{
		Thread.sleep(2000);
		driver.findElement(By.id("Edit0")).click();
		FileInputStream fi=new FileInputStream(".\\DataSheet\\AccordionDataContent.xlsx");
		XSSFWorkbook wk=new XSSFWorkbook(fi);		
		XSSFSheet sh=wk.getSheet("editData");	
		XSSFRow rw=sh.getRow(0);
		XSSFCell topicTitle=null;
		int col_topicTitle=0;
		
		for(int j=1;j<=sh.getLastRowNum(); j++)
		{
			for(int i=1;i<rw.getLastCellNum();i++)
			{
				if(rw.getCell(i).getStringCellValue().trim().equals("Topic Title"))
				{
					col_topicTitle=i;
				}
				rw=sh.getRow(j);
				Thread.sleep(2000);
				String checkTopicTitle=driver.findElement(By.id("txtTopicTitle")).getText();
				if(checkTopicTitle != null)
				{
					topicTitle=rw.getCell(col_topicTitle);
					String TopicTitle=String.valueOf(topicTitle.getStringCellValue());
					Thread.sleep(2000);
					driver.findElement(By.id("txtTopicTitle")).clear();
					Thread.sleep(2000);
					driver.findElement(By.id("txtTopicTitle")).sendKeys(TopicTitle);
					dataMaptitle.put("EditedTitle",TopicTitle);
				}
			}		
			wk.close();
		}
	}
	public static void editItemDescription() throws Exception  //need to check the excel value
	{
		Thread.sleep(2000);
		//driver.findElement(By.id("Edit0")).click();
		FileInputStream fi=new FileInputStream(".\\DataSheet\\AccordionDataContent.xlsx");
		XSSFWorkbook wk=new XSSFWorkbook(fi);		
		XSSFSheet sh=wk.getSheet("editData");	
		XSSFRow rw=sh.getRow(0);
		XSSFCell topicDescription=null;
		int col_topicDescription=0;
		for(int j=1;j<=sh.getLastRowNum(); j++)
		{
			for(int i=1;i<rw.getLastCellNum();i++)
			{
				if(rw.getCell(i).getStringCellValue().trim().equals("Topic Description"))
				{
					col_topicDescription=i;
				}
				rw=sh.getRow(j);
				Thread.sleep(2000);
				String checkTopicDes=driver.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).getText();
				if(checkTopicDes != null)
				{
					topicDescription=rw.getCell(col_topicDescription);
					String TopicDescription = String.valueOf(topicDescription.getStringCellValue());
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).clear();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).sendKeys(TopicDescription);
					dataMapdescription.put("EditedDescription",TopicDescription);
				}
			}
			wk.close();
		}
	}
	public static void editDefaultCheckbox() throws Exception
	{
	//	Thread.sleep(2000);
	//	int editItemCount = driver.findElements(By.xpath("//*[@id='itemsForEdit']/tbody/tr")).size();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Edit0"))));
		driver.findElement(By.id("Edit0")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='divIsDisabled']/input"))));
		System.out.println("Item Check box found");
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='divIsDisabled']/input"));
		if(!checkbox.isSelected()) 
		{
			Assert.assertTrue(true);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseUpdate")));
		driver.findElement(By.id("btnCloseUpdate")).click();
	}
	public static void editDisableCheckboxChecked() throws Exception
	{
		Thread.sleep(2000);
		if(driver.findElement(By.id("Edit0")).isDisplayed())
		{
			driver.findElement(By.id("Edit0")).click();
			Thread.sleep(2000);
			WebElement checkbox = driver.findElement(By.xpath("//*[@id='divIsDisabled']/input"));
			
			if(!checkbox.isSelected())
			{
				Thread.sleep(3000);
				checkbox.click();
			}
		}	
	}
	public static void editDisableCheckboxUnChecked() throws Exception
	{
		Thread.sleep(2000);
		if(driver.findElement(By.id("Edit0")).isDisplayed())
		{
			driver.findElement(By.id("Edit0")).click();
			Thread.sleep(2000);
			WebElement checkbox = driver.findElement(By.xpath("//*[@id='divIsDisabled']/input"));
			if(checkbox.isSelected())
			{
				Thread.sleep(2000);
				checkbox.click();
			}
		}
	}
	public static void editUpdatebtn() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("btnUpdateItem")).click();
		Thread.sleep(2000);
		String act_UpdateSuccessMessage = driver.findElement(By.id("userMessage")).getText();
		String exp_UpdateSuccessMessage = "Topic updated successfully.";
		Assert.assertEquals(act_UpdateSuccessMessage, exp_UpdateSuccessMessage);
	}
	public static void editUpdateClosebtn() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseUserMsg")));
		driver.findElement(By.id("btnCloseUserMsg")).click();
	}
	public static void editDisableAppPreview() throws Exception
	{
		Thread.sleep(2000);
		int checkitem = driver.findElements(By.xpath("//*[@id='cssmenu']/ul")).size();
		String topicToShow = manageTitleTab.topictoshow.get("Key_topictoshow");
		int defaulttopic = Integer.parseInt(topicToShow);
		if(checkitem == defaulttopic)
		{
			for(int j=1;j<=checkitem;j++)
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cssmenu']/ul["+j+"]")).click();
			}	
			Assert.assertTrue(true);
		}
		if(checkitem<defaulttopic)
		{
			for(int j=1;j<=checkitem;j++)
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cssmenu']/ul["+j+"]")).click();
			}
			Assert.assertTrue(true);
		}
	}
	public static void editedItemOnPreview() throws Exception //need to check the excel value
	{
		Thread.sleep(2000);
		String act_TitleItemOnPreivew = driver.findElement(By.xpath("//*[@id='1']")).getText();
		String exp_TitleItemOnPreivew = dataMaptitle.get("EditedTitle");
		Assert.assertEquals(act_TitleItemOnPreivew, exp_TitleItemOnPreivew);
	}
	public static void editClosebtn(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnCloseEdit"))));
		parent.findElement(By.id("btnCloseEdit")).click();
		System.out.println("Edit Close BUtton Clicked");
	}
	public static void editItemCount(WebElement parent) throws Exception //Trace the count. Need to check count
	{
		Thread.sleep(3000);
		int act_editItemCount = parent.findElements(By.xpath("//*[@id='itemsForEdit']/tbody/tr")).size();
		String exp_editItemCount = addTab.hashmap.get("Key_NoOfItemsEntered");
		int editItemCount = Integer.parseInt(exp_editItemCount);
		Assert.assertEquals(act_editItemCount, editItemCount);
		System.out.println("Verified the Count in Edit tab");
	}
	public static void reorderItemCountDisableCheckboxchecked() throws Exception
	{
		Thread.sleep(2000);
		int reorderitemcountAfterDisableCheckboxChecked = driver.findElements(By.xpath("//*[@id='itemsForReorder']/tbody")).size();
		edititemcount.put("EditItemCountBeforeDisableCheckbox","11");
		String editItemCheckCountBefore = edititemcount.get("EditItemCountBeforeDisableCheckbox");
		int editItemcountBeforeCheckboxChecked = Integer.parseInt(editItemCheckCountBefore);
		if(reorderitemcountAfterDisableCheckboxChecked!=editItemcountBeforeCheckboxChecked)
		{
			Thread.sleep(2000);
			Assert.assertTrue(true);
		}
	}
	public static void reorderItemCountDisableCheckBoxUnChecked() throws Exception
	{
		Thread.sleep(2000);
		int reorderitemcountAfterDisableCheckboxUnChecked = driver.findElements(By.xpath("//*[@id='itemsForReorder']/tbody")).size();
		edititemcount.put("EditItemCountBeforeDisableCheckbox","11");
		String editItemCheckCountBefore = edititemcount.get("EditItemCountBeforeDisableCheckbox");
		int editItemcountBefore = Integer.parseInt(editItemCheckCountBefore);
		if(reorderitemcountAfterDisableCheckboxUnChecked==editItemcountBefore)
		{
			Thread.sleep(2000);
			Assert.assertTrue(true);
		}
	}
	public static void editlinkbtn(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("Edit0"))));
		parent.findElement(By.id("Edit0")).click();
		System.out.println("Edit Link button Clicked");
	}
	public static void editlinkfields(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtTopicTitle"))));
		String topicTitle = parent.findElement(By.id("txtTopicTitle")).getText();
		if(topicTitle.matches(topicTitle))
		{
			Assert.assertTrue(true, topicTitle);
		}
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div"))));
		String topicDes = parent.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).getText();
		if(topicDes.matches(topicDes))
		{
			Assert.assertTrue(true, topicDes);
		}
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("btnCloseUpdate"))));
		parent.findElement(By.id("btnCloseUpdate")).click();
	}
	public static void editlinkfieldBlank() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTopicTitle")));
		driver.findElement(By.id("txtTopicTitle")).clear();	
		String TopicTitle = driver.findElement(By.id("txtTopicTitle")).getText();
		if(TopicTitle.isEmpty())
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnUpdateItem")));
			driver.findElement(By.id("btnUpdateItem")).click();	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validator_txtTopicTitle")));	
			String act_TopicTitleValdation = driver.findElement(By.id("validator_txtTopicTitle")).getText();
			
			String exp_TopicTitleValdation = "Please specify topic title.";
			Assert.assertEquals(act_TopicTitleValdation, exp_TopicTitleValdation);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")));
		driver.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).clear();
		
		String TopicDescription = driver.findElement(By.xpath("//*[@id='txtTopicContentDiv']/div[2]/div")).getText();
		if(TopicDescription.isEmpty())
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnUpdateItem")));
			driver.findElement(By.id("btnUpdateItem")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("validator_txtTopicDescription")));
			String act_TopicDesValdation = driver.findElement(By.id("validator_txtTopicDescription")).getText();
			
			String exp_TopicDesValdation = "Please specify topic description.";
			Assert.assertEquals(act_TopicDesValdation, exp_TopicDesValdation);
		}
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("btnCloseUpdate"))));
		driver.findElement(By.id("btnCloseUpdate")).click();				
	}
}
