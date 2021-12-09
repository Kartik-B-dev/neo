package com.qa.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.Pages.NeoPages;

public class TestBase {
	WebDriver driver;
	NeoPages Neo;
	
@Parameters({"Url"})

	@BeforeClass
	public void setUp(String Url) {
	
		System.setProperty("webdriver.gecko.driver","C:\\Users\\GJ-VT\\Desktop\\Drivers\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		
		Neo=new NeoPages(driver);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
