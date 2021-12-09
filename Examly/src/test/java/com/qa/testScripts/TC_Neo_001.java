package com.qa.testScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Neo_001 extends TestBase{
	
	@Test
	public void Navigate()
	{
		String title=driver.getTitle();
		if(title.contains("We are Hiring!"))
		{
			System.out.println("PASS");
			Reporter.log("PASS");
		}
		else
		{
			Reporter.log("FAIL");
			System.out.println("FAIL");
		}
		driver.get("https://www.facebook.com");
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
	}
}
