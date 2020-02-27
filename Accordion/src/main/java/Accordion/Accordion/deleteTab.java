package Accordion.Accordion;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class deleteTab extends loginURL
{
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	public static void deletetab(WebElement parent) throws Exception
	{
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("tabDelete"))));
		parent.findElement(By.id("tabDelete")).click();
	}
	public static void deleteClosebtn() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseDelete")));
		driver.findElement(By.id("btnCloseDelete")).click();
	}
	public static void deleteNoItemPresent(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("itemsForDelete"))));
		String act_DefaultMessage = parent.findElement(By.id("itemsForDelete")).getText();
		String exp_Message = "No topic configured.";
		Assert.assertEquals(act_DefaultMessage, exp_Message);
	}
	public static void deleteItemPresent() throws Exception
	{
		Thread.sleep(3000);
		int deletelist=driver.findElements(By.xpath("//*[@id='itemsForDelete']/tbody/tr")).size(); //Total item present in Delete tab
		for(int i=1;i<=deletelist;) //Deleting all the item Present
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='itemsForDelete']/tbody/tr["+i+"]/td[1]")).click(); //Click on Delete Hyper link
		
			Thread.sleep(2000);
			Alert a=driver.switchTo().alert(); //Switching to Alert Window
			Thread.sleep(2000);
			a.accept(); //Click on Alert Okay button
		
			Thread.sleep(2000);
			deletelist=driver.findElements(By.xpath("//*[@id='itemsForDelete']/tbody/tr")).size(); //Again Calculating Item from Delete tab 
		}
	}
	public static void deleteAlertCancel() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("Delete0")).click(); //Click on Delete Hyper link
		Thread.sleep(3000);
		Alert a=driver.switchTo().alert(); //Switching to Alert Window
		Thread.sleep(4000);
		a.dismiss(); //Click on Alert Cancel button
	}
	public static void deleteItemCount(WebElement parent) throws Exception
	{
		Thread.sleep(3000);
		int deletelist=parent.findElements(By.xpath("//*[@id='itemsForDelete']/tbody/tr")).size();
		String exp_deleteItemCount = addTab.hashmap.get("Key_NoOfItemsEntered");
		int deletecount = Integer.parseInt(exp_deleteItemCount);
		Assert.assertEquals(deletelist, deletecount);
		System.out.println("Item Count verified for Delete Tab");
	}
}
