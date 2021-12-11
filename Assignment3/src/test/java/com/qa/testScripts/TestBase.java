package com.qa.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.Pages.KartPages;

public class TestBase {
	WebDriver driver;
	KartPages flipkart;
	
@Parameters({"Browser","Url"})
	
	@BeforeClass
	public void setup(String Browser,String Url)
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\GJ-VT\\Desktop\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\GJ-VT\\Desktop\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\GJ-VT\\Desktop\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(Url);
		
		flipkart=new KartPages(driver);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}
