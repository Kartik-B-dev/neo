package com.qa.testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_Kart_001 extends TestBase{
	
	@Test
	public void countLinks()
	{
		List<WebElement> Links=driver.findElements(By.tagName("a"));
		System.out.println(Links.size());
		driver.close();
	}
}
