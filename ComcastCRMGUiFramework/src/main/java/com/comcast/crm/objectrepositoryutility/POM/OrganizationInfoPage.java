package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText") private WebElement Headdermsg;
	@FindBy(id="dtlview_Organization Name") private WebElement actorgname;
	
	
	public WebElement getActorgname() {
		return actorgname;
	}


	public WebElement getHeaddermsg() {
		return Headdermsg;
	}
	
	
	
}
