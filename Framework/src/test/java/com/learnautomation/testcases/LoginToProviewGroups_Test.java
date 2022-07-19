package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.learnautomation.pages.BaseClass;

import com.learnautomation.pages.LoginPage;

import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginToProviewGroups_Test extends BaseClass {
	

	@Test
	public void loginApp()
	{
		logger=report.createTest("Login to PVG");
		
		ExcelDataProvider excel=new ExcelDataProvider();
		
		logger.info("Application Started");
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		//loginpage.LogintoPVG(config.getUserName(), config.getPwd());
		loginpage.LogintoPVG(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Helper.captureScreenshots(driver);
		
		logger.pass("Login Success");
		
	}

	
}
