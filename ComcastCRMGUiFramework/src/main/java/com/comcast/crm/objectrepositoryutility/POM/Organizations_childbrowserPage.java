package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations_childbrowserPage {
	
	WebDriver driver;
	public Organizations_childbrowserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text") private WebElement search_txt;
	@FindBy(name="search") private WebElement search;
	
	
	public WebElement getSearch_txt() {
		return search_txt;
	}
	public WebElement getSearch() {
		return search;
	}
	
	
}
