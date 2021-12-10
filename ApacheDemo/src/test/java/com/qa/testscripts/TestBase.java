package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;

public class TestBase {
	WebDriver driver;
	AmazonPages AmazonOR;
@Parameters({"Browser","Url"})
	@BeforeClass
	public void SetUp(String Browser,String Url)
	{
		
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\GJ-VT\\Desktop\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\GJ-VT\\Desktop\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\GJ-VT\\Desktop\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	    driver.manage().window().maximize();
	    driver.get(Url);
	    
	    AmazonOR=new AmazonPages(driver);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	//Taking screenshots
	
	public void captureScreenshot(WebDriver driver,String tName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(source, target);
	}
}
