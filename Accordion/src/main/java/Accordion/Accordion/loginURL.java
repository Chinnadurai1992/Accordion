package Accordion.Accordion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginURL 
{
	public static WebDriver driver;
	public static void openChromeBrowser()
	{
			System.setProperty("webdriver.chrome.driver", ".\\SeleniumDriver\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
			driver.get("https://ngenioussolutions.sharepoint.com/sites/365AppzQA/QA1/Pages/AutomationTesting.aspx");
		
//			System.setProperty("webdriver.edge.driver", ".\\SeleniumDriver\\MicrosoftWebDriver.exe");
//			driver=new EdgeDriver();	
//			driver.get("https://ngenioussolutions.sharepoint.com/sites/365AppzQA/QA1/Pages/AutomationTesting.aspx");	
			
//			System.setProperty("webdriver.ie.driver", ".\\SeleniumDriver\\IEDriverServer.exe");
//			driver=new InternetExplorerDriver();	
//			driver.manage().window().maximize();
//			driver.get("https://ngenioussolutions.sharepoint.com/sites/365AppzQA/QA1/Pages/AutomationTesting.aspx");
	}
	public static void loginContentAdmin() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.id("i0116")).sendKeys("cdurai@ngenioussolutions.com");
		Thread.sleep(2000);
		driver.findElement(By.id("idSIButton9")).click(); 
		
		Thread.sleep(2000);
		driver.findElement(By.id("i0118")).sendKeys("Test@1512");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("idBtn_Back")).click();
	}
	public static void loginNormalUser() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.id("i0116")).sendKeys("test01@ngenioussolutions.com");
		Thread.sleep(2000);
		driver.findElement(By.id("idSIButton9")).click(); 
		
		Thread.sleep(2000);
		driver.findElement(By.id("i0118")).sendKeys("Ngss@1234");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("idBtn_Back")).click();
	}
	public static void closeChromeBrowser()
	{
		driver.close();
	}
}
