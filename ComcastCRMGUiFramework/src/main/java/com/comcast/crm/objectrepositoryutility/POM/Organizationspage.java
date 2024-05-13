package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {
	
	@FindBy(xpath="//img[@title='Create Organization...']") private WebElement orgbutton;
	@FindBy(name="search_text") private WebElement searchbox;
	@FindBy(name="search_field") private WebElement searchDD;
	@FindBy(name="submit") private WebElement search;
	
	WebDriver driver;
	public Organizationspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgbutton() {
		return orgbutton;
	}
	public WebElement getSearchbox() {
		return searchbox;
	}
	public WebElement getSearchDD() {
		return searchDD;
	}
	public WebElement getSearch() {
		return search;
	}
	
	
	
	
	
	
	
}
