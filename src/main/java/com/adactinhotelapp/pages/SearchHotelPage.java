package com.adactinhotelapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactinhotelapp.utils.ElementUtils;

public class SearchHotelPage extends BasePage{
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	//By locators
	//private By locationDropDown = By.xpath("//select[@name='location']");
	@FindBy(xpath="//select[@name='location']")
	private WebElement locationDropDown;

	public SearchHotelPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	public void locationDropDown(String option)
	{
		//elementUtils.getElement(locationDropDown).sendKeys(option);
		locationDropDown.sendKeys(option);
		
	}

}
