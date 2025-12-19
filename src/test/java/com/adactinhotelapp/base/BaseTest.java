package com.adactinhotelapp.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.adactinhotelapp.factory.DriverFactory;
import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)

public class BaseTest {
	
	protected WebDriver driver;
	DriverFactory diverFactory;
	Properties prop;
	
	@BeforeTest
    public void setUp() 
	{
	new DriverFactory().initProp();
	}
	
	@BeforeMethod
	public void appLaunch()
	{
		diverFactory = new DriverFactory();
	
		driver = diverFactory.initDriver(DriverFactory.configProp);
		
	}

	
	@AfterMethod
	public void closeBrowser(ITestResult result) throws InterruptedException
	{
		Thread.sleep(5000);
		if(!result.isSuccess())
		{
		ChainTestListener.embed(diverFactory.getScreenshotFile(),"image/png");
		}
		driver.quit();
		ChainTestListener.log("Browser closed...");
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	

}
