package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="mouseArea_Last Name") private WebElement actlastname;
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement actheradder;
	@FindBy(id="mouseArea_Organization Name") private WebElement actorgname;
	
	public WebElement getActorgname() {
		return actorgname;
	}

	public WebElement getActheradder() {
		return actheradder;
	}

	public WebElement getActlastname() {
		return actlastname;
	}
	
	public void validation(String actlastname) {
		
	}
	}

