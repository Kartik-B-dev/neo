package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AmazonPages {

	WebDriver driver;
	
	@FindBy(id="searchDropdownBox")
	WebElement Category;
	public Select getCategory()
	{
		Select categorySel=new Select(Category);
		return categorySel;
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchTextField;
	
	public WebElement getSearchTxtField()
	{
		return SearchTextField;
	}
	
	@FindBy(id="nav-search-submit-button")
	 WebElement MagnifierBtn;
	
	 public WebElement getMagnifierBtn()
	 {
		 return MagnifierBtn;
	 }
	 
	 @FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	 List<WebElement> AllItems;
	 
	 public List<WebElement> getAllItems()
	 {
		 return AllItems;
	 }
	 public AmazonPages(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
}
