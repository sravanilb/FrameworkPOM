package com.adactinhotelapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;
import com.aventstack.chaintest.plugins.ChainTestListener;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	
	 //Standard POM implementation //By locators
	 
		/*
		 * private final By userNameTextBox = By.xpath("//input[@name='username']");
		 * private final By passwordTextbox=By.xpath("//input[@name='password']");
		 * private final By loginButton=By.xpath("//input[@name='login']");
		 */
	 
	
	//POM implementation using page Factory 
	@FindBy(xpath ="//input[@name='username']")
	private WebElement userNameTextBox;
	
	@FindBy(xpath ="//input[@name='password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath ="//input[@name='login']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	//Methods
	public void usernameTextbox(String text)
	{
		// elementUtils.getElement(userNameTextBox).sendKeys(text); - Standard POM implementation
		userNameTextBox.sendKeys(text);
		ChainTestListener.log("Entering text "+text+" into texbox usernameTextbox");
	}
	
	public void passwordTextbox(String text)
	{
		//elementUtils.getElement(passwordTextbox).sendKeys(text);
		passwordTextbox.sendKeys(text);
		ChainTestListener.log("Entering text "+text+" into texbox passwordTextbox");
		
	}
	
	public void loginButton()
	{
		//elementUtils.getElement(loginButton).click();
		loginButton.click();
		ChainTestListener.log("Clicked login button");
		
	}
	
	public void doLogin()
	{
		/*
		 * usernameTextbox(prop.getProperty("username"));
		 * passwordTextbox(prop.getProperty("password"));
		 */
		
		usernameTextbox(configProp.getProperty("username"));
		passwordTextbox(configProp.getProperty("password"));
		
		loginButton();
	}

}
