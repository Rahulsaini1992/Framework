package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//To handle Screenshots, Frames,Windows,Sync issues, javascript executor
	
	public static String captureScreenshots(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+getCurrentDateTime()+".png";
		
		try {
			FileHandler.copy(src,new File("./Screenshots/"+getCurrentDateTime()+".png"));
			System.out.println("Screenshot Captured");
		} catch (Exception e) {
			
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}
		return screenshotPath;
	}

	public static String getCurrentDateTime()
	{
		//DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		//Date now = new Date();
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		return(dtf.format(now));
		
	}
	
}
