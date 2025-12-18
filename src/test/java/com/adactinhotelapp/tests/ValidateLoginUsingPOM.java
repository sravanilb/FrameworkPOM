package com.adactinhotelapp.tests;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.utils.ExcelUtils;
public class ValidateLoginUsingPOM extends BaseTest {	
	/*
	@Test
	public void ValidateLoginTest()
	{
		
		//Here we done hardcoding
		LoginPage lp = new LoginPage(driver);
		lp.usernameTextbox("reyaz0806");
		lp.passwordTextbox("reyaz123"); 
		lp.loginButton();
		
		Assert.assertEquals(lp.getTitle(),AppConstants.SEARCH_HOTEL_PAGE_TITLE); 
	} */
	
	@Test(dataProvider = "getTestData")
	public void ValidateLoginTest(HashMap<String, String> dataMap)
	{
		LoginPage lp = new LoginPage(driver);
		lp.usernameTextbox(dataMap.get("Username"));
		lp.passwordTextbox(dataMap.get("Password"));
		lp.loginButton();
		Assert.assertEquals(lp.getTitle(),AppConstants.SEARCH_HOTEL_PAGE_TITLE); 
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = new Object[1][1];
		HashMap<String, String> testDataMap = ExcelUtils.getTestDataFromExcel("TC101");
		data[0][0] = testDataMap;
		return data;
		
	}

}
