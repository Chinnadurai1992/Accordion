package Accordion.Accordion;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class manageTitleTab extends loginURL
{
	static Map<String, String> addedtitle = new HashMap<String, String>();
	static Map<String, String> topictoshow = new HashMap<String, String>();
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	public static void managetitleTab(WebElement parent) throws Exception
	{
	//	Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("tabManageTitle"))));
		parent.findElement(By.id("tabManageTitle")).click();
		System.out.println("Manage Title Clicked");
	}
	public static void managetitleClosebtn(WebElement parent) throws Exception
	{
	//	Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnCloseMT"))));
		parent.findElement(By.id("btnCloseMT")).click();
		System.out.println("Manage Title Close Button Clicked");
	}
	public static void managetitleSavebtn(WebElement parent) throws Exception
	{
	//	Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnSaveTitle"))));
		parent.findElement(By.id("btnSaveTitle")).click();
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("userMessage"))));
		String act_managetitle = parent.findElement(By.id("userMessage")).getText();
		String exp_managetitle = "Title changes saved successfully.";
		Assert.assertEquals(act_managetitle, exp_managetitle);
		System.out.println("Save button Clicked");
	}
	public static void managetitleSaveClosebtn(WebElement parent) throws Exception
	{
	//	Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnCloseUserMsg"))));
		parent.findElement(By.id("btnCloseUserMsg")).click();
		System.out.println("Save Close button Clicked");
	}
	public static void managetitleAppTitleBlank(WebElement parent) throws Exception
	{
	//	Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtTitle"))));
		WebElement titleelement = parent.findElement(By.id("txtTitle"));
		String titleapp = titleelement.toString();
		if(!titleapp.isEmpty())
		{			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtTitle")));
			Thread.sleep(3000);
			parent.findElement(By.id("txtTitle")).clear();
			managetitleSavebtn(parent);
			managetitleSaveClosebtn(parent);
			managetitleClosebtn(parent);
			apptitleBlankPreview(parent);
		}
	}
	public static void apptitleBlankPreview(WebElement parent) throws Exception
	{
		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("appTitle")));
		String act_notitle = parent.findElement(By.id("appTitle")).getText();
		String exp_notitle = "No Title";
		Assert.assertEquals(act_notitle, exp_notitle);		
		System.out.println("App Title Verified in Preview");
	}
	public static void managetitleAppTitle(WebElement parent) throws Exception
	{
		FileInputStream fi=new FileInputStream(".\\DataSheet\\AccordionDataContent.xlsx");		//Access the Excel Sheet
		XSSFWorkbook wk=new XSSFWorkbook(fi);			//Open the Workbook of the Excel sheet
		XSSFSheet sh=wk.getSheet("manageTitleData1");			//Access the Sheet from WorkBook
		XSSFRow row=sh.getRow(0);
		int col_Apptitle=0;
		System.out.println("Last Row Number: "+sh.getLastRowNum());
		int a = sh.getLastRowNum();
		int b = row.getLastCellNum();
		for(int j=1;j<=a;j++)	/* Calculate the Row count */
		{	
			System.out.println("J value excution number is -: "+j);
			for(int i=0;i<b;i++)	/* Calculate the column count */
			{
				if(row.getCell(i).getStringCellValue().trim().equals("App Title"))
				{
					col_Apptitle=i;
				}
			}
			row=sh.getRow(j);
			XSSFCell cell=row.getCell(j);
			Thread.sleep(3000);
			String apptitle=parent.findElement(By.id("txtTitle")).getText();
			if(apptitle!=null)
			{
				cell=row.getCell(col_Apptitle);
				String Title=String.valueOf(cell.getStringCellValue());
				Thread.sleep(4000);
				parent.findElement(By.id("txtTitle")).clear();
				
				wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("txtTitle"))));
				parent.findElement(By.id("txtTitle")).sendKeys(Title.toString());
				System.out.println("New Title: "+Title.toString());
				addedtitle.put("key", Title);
				
				managetitleSavebtn(parent);
				managetitleSaveClosebtn(parent);
				managetitleClosebtn(parent);
			}	
			apptitlepreview(parent);
			System.out.println("\n ");
			if(j!= a)/* To open the wizard again */
			{
				webPart.menu(parent);		
				webPart.EditWizard(parent);
			}
			
		}
		wk.close();
	}
	public static void apptitlepreview(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("appTitle"))));
		String act_apptitle = parent.findElement(By.id("appTitle")).getText();
		String exp_Title = addedtitle.get("key");
		Assert.assertEquals(act_apptitle.toLowerCase().trim(), exp_Title.toLowerCase().trim());
		System.out.println("Changed App Title Vified in Preview");
	}
	public static void apptitleBankPreviewNormalUser() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("appTitle"))));
		int act_notitleNUser = driver.findElements(By.id("appTitle")).size();
		if(act_notitleNUser==1)
		{
			Assert.assertTrue(true);
		}
	}
	public static void managetitleTopicToShowDefault(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("drpTopicsToShow"))));
		
		Select select = new Select(parent.findElement(By.id("drpTopicsToShow")));
		WebElement topic =  select.getFirstSelectedOption();
		
		String act_TopicToShowDefault = topic.getText();
		topictoshow.put("Key_topictoshow", act_TopicToShowDefault);
		String exp_TopicToShowDefault = "5";
		Assert.assertEquals(act_TopicToShowDefault, exp_TopicToShowDefault);
	}
	public static void managetitleNoOfTopicToShow(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("drpTopicsToShow"))));
		String arr[] = {"5","10"};
		WebElement we = parent.findElement(By.id("drpTopicsToShow"));
		Select select = new Select(we);
		List<WebElement> list = select.getOptions();
		for(int i=0;i<list.size();i++)
		{
			Assert.assertEquals(arr[i], list.get(i).getText());
		}
		System.out.println("Verified the Topic to Show drop down");
	}
	public static void managetitleNoOfTopicToShow10(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("drpTopicsToShow"))));
		WebElement we = parent.findElement(By.id("drpTopicsToShow"));
		Select select = new Select(we);
		select.selectByValue("10");
	}
	public static void managetitleNoOfTopicToShow5(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("drpTopicsToShow"))));
		WebElement we = driver.findElement(By.id("drpTopicsToShow"));
		Select select = new Select(we);
		select.selectByValue("5");
	}
	public static void closeMarkOfWizard(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.elementToBeClickable(parent.findElement(By.id("btnClose"))));
		parent.findElement(By.id("btnClose")).click();
		System.out.println("Wizard got closed ");
	}
}
