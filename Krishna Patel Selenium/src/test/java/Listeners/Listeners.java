package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listeners extends BaseClass implements ITestListener  {
	
	String testcasename = null;
	WebDriver driver = null;
	
	ExtentReports extent = ExtentReportsutils.reportobject();
	
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		testcasename= result.getMethod().getMethodName() ;
		
		System.out.println(testcasename + " Execution started");
		
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		System.out.println(result.getMethod().getMethodName() + " is successfull");
		
		test.log(Status.PASS, "Test Passed");
		
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) 
		{
			
			
		} 
		try 
		{
			testcasename = result.getMethod().getMethodName();
			Screenshotutils.takescreenshot(driver, testcasename);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		try 
		{
			test.addScreenCaptureFromPath(Screenshotutils.takescreenshot(driver, testcasename), result.getMethod().getMethodName());
		} 
		catch (IOException e1) 
		{
			
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		
		
		
	try 
	{
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} 
	catch (Exception e) 
	{
		
		
	} 
	try 
	{
		testcasename = result.getMethod().getMethodName();
		Screenshotutils.takescreenshot(driver, testcasename);
	} 
	catch (IOException e) 
	{
		
		e.printStackTrace();
	}
	
	try 
	{
		test.addScreenCaptureFromPath(Screenshotutils.takescreenshot(driver, testcasename), result.getMethod().getMethodName());
	} 
	catch (IOException e1) 
	{
		
		e1.printStackTrace();
	}
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
			
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
}
	@Override
	public void onFinish(ITestContext context) {
	  extent.flush();
	}

}
