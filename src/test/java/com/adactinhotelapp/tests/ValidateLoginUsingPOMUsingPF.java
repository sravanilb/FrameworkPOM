package com.adactinhotelapp.tests;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.utils.ExcelUtils;
public class ValidateLoginUsingPOMUsingPF extends BaseTest {	

	
	@Test(dataProvider = "getTestData")
	public void ValidateLoginTest(HashMap<String, String> dataMap)
	{
		
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		
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
