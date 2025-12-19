package com.adactinhotelapp.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.adactinhotelapp.exceptions.FrameWorkException;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class DriverFactory {	
	public WebDriver driver;
	public static Properties configProp; //Properties is a Java class used to store key–value pairs
	
	public WebDriver initDriver(Properties configProp)

	{
		String browserName = configProp.getProperty("browser");
		switch(browserName.toLowerCase()) 
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			FrameWorkException fe = new FrameWorkException("please pass the right browser..choose chrome/firefox");
			throw new FrameWorkException("Invalid browser Exception");
		}
		
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	}	
	
	public Properties initProp()
	{
		FileInputStream fis = null;
		try {
		 fis = new FileInputStream("src\\test\\resources\\Config\\qa.config.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
				configProp = new Properties();
		try {
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChainTestListener.log("Properties file has been initialized");
		return configProp;	
	}
	
	public File getScreenshotFile() {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		return srcFile;
	}
}
