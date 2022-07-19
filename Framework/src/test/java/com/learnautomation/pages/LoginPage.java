package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(name="UserName") WebElement uname;
	@FindBy(name="Password") WebElement pwd;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/div[2]/form/div/div[5]/div/button") WebElement loginbtn;

    public void LogintoPVG(String username,String password)
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			
		}
    	
    	uname.sendKeys(username);
    	pwd.sendKeys(password);
    	loginbtn.click();
    }
	
}
