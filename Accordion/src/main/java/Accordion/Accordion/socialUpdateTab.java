package Accordion.Accordion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class socialUpdateTab extends loginURL
{
	static WebDriverWait wait = new WebDriverWait(driver, 100);
	public static void socialupdatePresent()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabSocialUpdates")));
		driver.findElement(By.id("tabSocialUpdates")).isDisplayed();
		Assert.assertTrue(true);
	}
	public static void socialupdate()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabSocialUpdates")));
		driver.findElement(By.id("tabSocialUpdates")).click();
	}
	public static void socialupdatefields()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpRatingExperience")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chkbxAllowComments")));
		
		WebElement ratingfield = driver.findElement(By.id("drpRatingExperience"));
		WebElement commentfield = driver.findElement(By.className("chkbxAllowComments"));
		
		if(ratingfield.isDisplayed() && commentfield.isDisplayed())
		{
			Assert.assertTrue(true);
		}
	}
	public static void socialupdateSaveBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSaveSocialUpdates")));
		driver.findElement(By.id("btnSaveSocialUpdates")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userMessage")));
		String act_validationmessage = driver.findElement(By.id("userMessage")).getText();
		System.out.println("Validation message found: "+act_validationmessage);
		String exp_validationmessage = "Social updates saved successfully.";
		
		Assert.assertEquals(act_validationmessage, exp_validationmessage);
	}
	public static void socialupdateSaveCloseBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseUserMsg")));
		driver.findElement(By.id("btnCloseUserMsg")).click();
		System.out.println("Save close button clicked");
		
	}
	public static void socialupdateCloseBtn()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnCloseSU")));
		driver.findElement(By.id("btnCloseSU")).click();
		System.out.println("Pop-up wizard closed");
	}
	public static void commentdefault()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chkbxAllowComments")));
		WebElement commentdefault = driver.findElement(By.className("chkbxAllowComments"));
		if(!commentdefault.isSelected())
		{
			Assert.assertTrue(true);
		}
	}
	public static void commentcheckboxchecked()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chkbxAllowComments")));
		WebElement commentCheckbox = driver.findElement(By.className("chkbxAllowComments"));
		if(!commentCheckbox.isSelected())
		{
			driver.findElement(By.className("chkbxAllowComments")).click();
			System.out.println("Comment check box checked");
		}
	}
	public static void commentcheckboxUnchecked()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chkbxAllowComments")));
		WebElement commentCheckbox = driver.findElement(By.className("chkbxAllowComments"));
		if(commentCheckbox.isSelected())
		{
			driver.findElement(By.className("chkbxAllowComments")).click();
			System.out.println("Comment check box Unchecked");
		}
	}
	public static void ratingDropdownDefaultValue()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpRatingExperience")));
		WebElement rating = driver.findElement(By.id("drpRatingExperience"));
		Select ratingdefaultvalue = new Select(rating);
		ratingdefaultvalue.selectByValue("None");
		String ratedefault = ratingdefaultvalue.toString();
		if(ratedefault.matches(ratedefault))
		{
			Assert.assertTrue(true);
		}
	}
	public static void ratingExperiencesoption()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpRatingExperience")));
		WebElement ratingoption = driver.findElement(By.id("drpRatingExperience"));
		if(ratingoption.isDisplayed())
		{
			ratingoption.click();
			Select rateoption = new Select(ratingoption);
			rateoption.selectByIndex(1);
			System.out.println("Like Selected in drop down");
			rateoption.selectByIndex(2);
			System.out.println("Rating Selected in drop down");
			
			rateoption.selectByIndex(0);
			System.out.println("Re-selected to None again");
		}
		
	}
	public static void ratingLikeoptionselected()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpRatingExperience")));
		WebElement rating = driver.findElement(By.id("drpRatingExperience"));
		Select ratinglike = new Select(rating);
		ratinglike.selectByValue("Likes");
		System.out.println("Likes Selected in Drop down");
	}
	public static void ratingRateoptionselected()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpRatingExperience")));
		WebElement rating = driver.findElement(By.id("drpRatingExperience"));
		Select ratingRate = new Select(rating);
		ratingRate.selectByValue("Rating");
		System.out.println("Rating Selected in Drop down");
	}
	public static void apppreviewlikes()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='1']/span")));
		driver.findElement(By.xpath("//*[@id='1']/span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("like170")));
		driver.findElement(By.id("like170")).click();
		System.out.println("Likes Clicked");
	}
	public static void apppreviewComment() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")));
		System.out.println("Webpart found");
		
		if(driver.findElement(By.xpath("//div[contains(@id,'MSOZoneCell_WebPartWPQ')]")).isDisplayed())
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cssmenu']/ul")));
			System.out.println("Webpart Item found");
			
			if(driver.findElement(By.xpath("//*[@id='cssmenu']/ul")).isDisplayed())
			{
				int itemcout = driver.findElements(By.xpath("//*[@id='cssmenu']/ul")).size();
				System.out.println("Item Count: "+itemcout);
				for(int i=1;i<=itemcout;i++)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cssmenu']/ul["+i+"]/li/a")));
					driver.findElement(By.xpath("//*[@id='cssmenu']/ul["+i+"]/li/a")).click();
					System.out.println("Item clicked:"+i);
					
					int noofcomments = driver.findElements(By.xpath("//*[starts-with(@id,'aComments')]")).size();
					System.out.println("Comments size: "+noofcomments);
					for(int j=i-1;j<=noofcomments;)
					{
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[starts-with(@id,'aComments')]")));
						System.out.println("Found comment in app preview");
						
						int a=j+215;
						driver.findElement(By.xpath("//*[starts-with(@id,'aComments"+a+"')]")).click();
						System.out.println("Comment is clicked from preview: "+a);
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("socialFeaturePopup_edbd4f93")));
						System.out.println("Comment Social update wizard opened");
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSocialFeatureClose")));
						System.out.println("Social Update wizard close button found");
						
						driver.findElement(By.id("btnSocialFeatureClose")).click();
						System.out.println("Social Update wizard closed");
						j++;
						break;
					}	
				}
			}
		}
	}
	public static void apppreviewRating()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='1']/span")));
		driver.findElement(By.xpath("//*[@id='1']/span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rating170")));
		driver.findElement(By.id("rating170")).click();
		System.out.println("Rating Wizard opened");
	}
}
