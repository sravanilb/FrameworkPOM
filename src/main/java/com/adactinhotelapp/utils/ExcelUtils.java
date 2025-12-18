package com.adactinhotelapp.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static HashMap<String, String> getTestDataFromExcel(String testCaseName) {
		
		FileInputStream fis = null; 
// initialized outside of try & catch methods, so that we can use in entire main method(getTestDataFromExcel)
		
		try {
		 fis = new FileInputStream("src\\test\\resources\\testdata\\excels\\MasterTestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook wb = null;
		
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet ws = wb.getSheet("regression");
		
		//Now it finds the "rows" that belong to your test case name.
		ArrayList<Row> testCaseRows = getTestCaseRows(ws, testCaseName); //
		
		//Then it creates an empty map to store data:
		HashMap<String, String> testDataMap = new HashMap<String, String>();
		
		//the most import loop in this class 
		/*Starts from column 1 (skips test case name column).
           Takes the key from Row 0 (e.g., “Username”).
             Takes the value from Row 1 (e.g., “user1”).
                Stores it like:
                
                            testDataMap.put("Username", "user1");*/
		for(int i=1;i<testCaseRows.get(0).getLastCellNum();i++)
		{
			testDataMap.put(testCaseRows.get(0).getCell(i).getStringCellValue(), 
										testCaseRows.get(1).getCell(i).getStringCellValue());
		}
		
		return testDataMap;
	}
	
//This just adds all rows from the sheet to a list (skipping null rows).
	private static ArrayList<Row> getTestCaseRows(XSSFSheet ws, String testCaseName) {
		
		ArrayList<Row> allRows = new ArrayList<Row>();
		
		for(int i=0; i<=ws.getLastRowNum(); i++)
		{
			if(ws.getRow(i)!=null)
			{
				allRows.add(ws.getRow(i));
			}
		}
		
		/*It looks at column 0 (first column) in each row.

        If that cell matches the given testcaseName, it adds that row to the list.
        
        So if you search for "TC01", it collects all rows where the first cell*/
		ArrayList<Row> testCaseRows = new ArrayList<Row>();
		
		for(int i=0;i<allRows.size(); i++)
		{
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName))
			{
				testCaseRows.add(allRows.get(i));
			}
		}
		
	
		
		System.out.println("no of rows "+testCaseRows.size());
		
		return testCaseRows;
	}
}
