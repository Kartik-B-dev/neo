package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.ExcelUtility;

public class TC_AmazonSearch_001 extends TestBase{
	
	@Test(dataProvider="getData")
	public void searchItem(String cat,String item) throws InterruptedException, IOException {		
   
		//Reporter.log(,true);
		SoftAssert SA=new SoftAssert();
		AmazonOR.getCategory().selectByVisibleText(cat);
		AmazonOR.getSearchTxtField().sendKeys(item);
		AmazonOR.getMagnifierBtn().click();
		AmazonOR.getSearchTxtField().clear();
		//Thread.sleep(3000);
        Reporter.log(driver.getTitle());
        boolean contains = driver.getTitle().contentEquals(item);
        
		if(contains) {
			System.out.println("Title has the search term");
			List <WebElement> allItems = AmazonOR.getAllItems();
			System.out.println("Total no. of items loaded are : " +  allItems.size());

			for(WebElement item1:allItems) 
			{
				System.out.println(item1.getText());
			}

		}
		else {
			captureScreenshot(driver,"searchItem");
			SA.assertTrue(false);
			Reporter.log("Incorrect title",true);		
			}	

	}


@DataProvider
public static String[][] getData() throws IOException{
	String xFile="D:\\kartik\\javaproj\\SeleniumxlDemo\\ApacheDemo\\src\\test\\java\\com\\qa\\testdata\\testdata.xlsx";
	String xSheet="Sheet1";
	int rowCount=ExcelUtility.getRowCount(xFile, xSheet);
	int cellCount=ExcelUtility.getCellCount(xFile, xSheet, rowCount);
	String [][]data=new String[rowCount][cellCount];
	for(int i=1;i<=rowCount;i++) {
		for(int j=0;j<cellCount;j++) {
			data[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
		}
	}
	return data;
}
}