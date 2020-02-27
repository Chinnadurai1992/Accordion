package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.accordion.utility.ExtentManager;
import com.accordion.utility.ExtentTestManager;
import com.accordion.utility.Library;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener 
{
	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("***Test Suite "+context.getName()+" Started ***");
	}
	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}
	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("TestCases Started: "+result.getName());
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("**TestCases Execution Completed & Passed: "+result.getName()+"\n");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("**TestCases Execution Completed & Failed: "+result.getName());	
        String screenShot = Library.captureScreenshot();
        try 
        {
        	ExtentTestManager.getTest().addScreenCaptureFromPath(screenShot);
			ExtentTestManager.getTest().fail("Test Case Failed: "+result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("**Test Cases Skipped: "+result.getName());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}
