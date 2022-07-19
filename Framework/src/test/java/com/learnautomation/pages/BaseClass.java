package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up configrations and Test is getting ready", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/PvgGroup"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Configurations Done- Test Can be started", true);
	}
	
	@BeforeClass
	public void LaunchBrowser()
	{
		
		Reporter.log("Trying to start browser & getting application ready", true);
		driver=BrowserFactory.LaunchBrowser(driver,config.getBrowser(),config.getStagingURL());
		Reporter.log("Browser Launched & Application Login page opened", true);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		
		BrowserFactory.KillBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			Helper.captureScreenshots(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		
		report.flush();
		Reporter.log("Test Completed >> Reports Generated", true);
	}
	
}
