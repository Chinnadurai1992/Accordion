package Accordion.Accordion;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class changeColorTab extends loginURL
{
	static WebDriverWait wait = new WebDriverWait(driver, 100);
	public static void changecolorTab() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("tabChangeColor")).click();
	}
	public static void titleFontChangecolor() throws Exception
	{
		Thread.sleep(4000);
		System.out.println("Title Font Color Palette found");
		driver.findElement(By.xpath("//*[@id='wzrdChangeColor']/div/table/tbody/tr[1]/td[2]/div")).click();
		System.out.println("Color Palette Clicked");
		
		Thread.sleep(7000);
		System.out.println("Color Input found");
		driver.findElement(By.className("sp-input")).clear();
		System.out.println("Color Input cleared");
		
		Thread.sleep(3000);
		driver.findElement(By.className("sp-input")).sendKeys("#cc0000");
		System.out.println("New color entered");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sp-choose")));
		System.out.println("Choose button found");
		driver.findElement(By.className("sp-choose")).click();
		System.out.println("Choose button clicked");
	}
	public static void headerBGChangecolor() throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='wzrdChangeColor']/div/table/tbody/tr[2]/td[2]/div")).click();
		System.out.println("Color Palette Header BG Color Clicked");
		
	//	Thread.sleep(7000);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.className("sp-input"))));
		driver.findElement(By.className("sp-input")).clear();
		System.out.println("color input found");
		
		Thread.sleep(4000);
		driver.findElement(By.className("sp-input")).sendKeys("#6aa84f");
		System.out.println("color input entered");
		
//		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sp-choose")));
		driver.findElement(By.className("sp-choose")).click();
		System.out.println("chose button clicked");
		
	}
	public static void headerFontChangecolor() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wzrdChangeColor']/div/table/tbody/tr[3]/td[2]/div")).click();
		
		Thread.sleep(4000);
	//	driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/input")).clear();
		driver.findElement(By.className("sp-input")).clear();
		
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/input")).sendKeys("#000000");
		driver.findElement(By.className("sp-input")).sendKeys("#000000");
		
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[4]/button")).click();
		driver.findElement(By.className("sp-choose")).click();
	}
	public static void contentBGChangecolor() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wzrdChangeColor']/div/table/tbody/tr[4]/td[2]/div")).click();
		
		Thread.sleep(4000);
	//	driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/input")).clear();
		driver.findElement(By.className("sp-input")).clear();
		
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/input")).sendKeys("#6d9eeb");
		driver.findElement(By.className("sp-input")).sendKeys("#6d9eeb");
		
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[4]/button")).click();
		driver.findElement(By.className("sp-choose")).click();
	}
	public static void contentFontChangecolor() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wzrdChangeColor']/div/table/tbody/tr[5]/td[2]/div")).click();
		
		Thread.sleep(4000);
	//	driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[2]/input")).clear();
		driver.findElement(By.className("sp-input")).clear();
		
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[2]/input")).sendKeys("#000000");
		driver.findElement(By.className("sp-input")).sendKeys("#000000");
		
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[4]/button")).click();
		driver.findElement(By.className("sp-choose")).click();
	}
	public static void changecolorSavebtn() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("btnSaveColor")).click();
		
		Thread.sleep(5000);
		String act_successMessageChangeColor = driver.findElement(By.id("userMessage")).getText();
		String exp_successMessageChangeColor = "Color changes saved successfully.";
		Assert.assertEquals(act_successMessageChangeColor, exp_successMessageChangeColor);
	}
	public static void changecolorSaveClosebtn() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("btnCloseUserMsg")).click();
	}
	public static void closeWebpartWizard() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("btnClose")).click();
	}
	public static void titleFontColorPreview() throws Exception
	{
		Thread.sleep(2000);
		String act_titlecolor = driver.findElement(By.id("appTitle")).getCssValue("color");
		String exp_titlecolor = "rgba(204, 0, 0, 1)";
		Assert.assertEquals(act_titlecolor, exp_titlecolor);
	}
	public static void headerBGColorPreview() throws Exception
	{
		Thread.sleep(2000);
		String act_headerBGcolor = driver.findElement(By.id("appPreview")).getCssValue("background-color");
		System.out.println(act_headerBGcolor);
		String exp_headerBGColor = "rgba(106, 168, 79, 1)";
		Assert.assertEquals(act_headerBGcolor, exp_headerBGColor);
	}
	public static void headerFontColorPreview() throws Exception
	{
		Thread.sleep(2000);
		int itemsize = driver.findElements(By.xpath("//*[@id='cssmenu']/ul")).size();
		for(int i=1;i<=itemsize;i++)
		{
			Thread.sleep(2000);
			String act_headerFontColor = driver.findElement(By.xpath("//*[@id='cssmenu']/ul["+i+"]")).getCssValue("color");
			String exp_headerFontColor = "rgba(51, 51, 51, 1)";
			Assert.assertEquals(act_headerFontColor, exp_headerFontColor);
		}
	}
	public static void contentBGColorPreview() throws Exception
	{
		Thread.sleep(2000);
		int itemsize = driver.findElements(By.xpath("//*[@id='cssmenu']/ul")).size();
		for(int i=1;i<=itemsize;i++)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cssmenu']/ul["+i+"]")).click();
			
			String contentBGColor = driver.findElement(By.xpath("//*[@id='cssmenu']/ul[1]/li/ul/li")).getCssValue("background");
			String act_contentBGColor[] = contentBGColor.split(" none repeat scroll 0% 0% / auto padding-box border-box");
			for(int j=0; j<act_contentBGColor.length;j++)
			{
				System.out.println("Content BG color "+i +":" +act_contentBGColor[j]);
				String exp_contentBGColor = "rgb(109, 158, 235)";
				Assert.assertEquals(act_contentBGColor[j], exp_contentBGColor);
			}
		}	
	}
	public static void contentFontColorPreview() throws Exception
	{
		Thread.sleep(2000);
		int itemsize = driver.findElements(By.xpath("//*[@id='cssmenu']/ul")).size();
		for(int i=1;i<=itemsize;i++)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cssmenu']/ul["+i+"]")).click();
			
			String act_contentFontColor = driver.findElement(By.xpath("//*[@id='cssmenu']/ul[1]/li/ul/li/span")).getCssValue("color");
			String exp_contentFontColor = "rgba(0, 0, 0, 1)";
			Assert.assertEquals(act_contentFontColor, exp_contentFontColor);
		}
	}
	public static void changecolorClosebtn() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.id("btnCloseCC")).click();
	}
}
