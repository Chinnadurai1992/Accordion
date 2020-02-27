package Accordion.Accordion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class reorderTab extends loginURL
{
	static WebDriverWait wait = new WebDriverWait(driver, 50);
	public static void reordertab(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("tabReOrder"))));
		parent.findElement(By.id("tabReOrder")).click();
	}
	public static void reorderNoItemPresent(WebElement parent) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(parent.findElement(By.id("itemsForReorder"))));
		String act_DefaultMessage = parent.findElement(By.id("itemsForReorder")).getText();
		String exp_Message = "No topic configured.";
		Assert.assertEquals(act_DefaultMessage, exp_Message);
	}
	public static void reorderClosebtn() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseReOrder")));
		driver.findElement(By.id("btnCloseReOrder")).click();
	}
	public static void reorderItemCount(WebElement parent) throws Exception
	{
		Thread.sleep(3000);
		int act_reorderitemcount = parent.findElements(By.xpath("//*[@id='itemsForReorder']/tbody")).size(); 
		String exp_reorderItemCount = addTab.hashmap.get("Key_NoOfItemsEntered");
		int reorderItemCount = Integer.parseInt(exp_reorderItemCount);
		Assert.assertEquals(act_reorderitemcount, reorderItemCount);
		System.out.println("Item count verified for Re-Order tab");
	}
	public static void reorderitem() throws Exception
	{
		Thread.sleep(2000);
		WebElement we = driver.findElement(By.id("FormPosition0"));
		Select s = new Select(we);
		s.selectByValue("2");
	}
	public static void reorderSavebtn() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("btnSaveReorder")).click();
		Thread.sleep(2000);
		String act_reordermessage = driver.findElement(By.id("userMessage")).getText();
		String exp_rordermessage = "Reorder changes saved successfully.";
		Assert.assertEquals(act_reordermessage, exp_rordermessage);
	}
	public static void reorderSaveClosebtn() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("btnCloseUserMsg")).click();
	}
}
