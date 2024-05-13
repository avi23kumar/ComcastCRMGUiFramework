package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcat.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage  {
	
//	rule 2: Object creation
	@FindBy(linkText="Organizations") private WebElement orglink;
	@FindBy(linkText="Contacts") private WebElement contlink;
	@FindBy(linkText="Campaigns") private WebElement camplink;
	@FindBy(linkText="More") private WebElement morelink;
	@FindBy(xpath="//img[@ src='themes/softed/images/user.PNG']")private WebElement signoutimg;
	@FindBy(xpath = "//a[text()='Sign Out']") private WebElement signout;
	@FindBy(xpath = "//a[text()='Products']") private WebElement product;
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
		
		
	}

//	Rule 4:Object Encapsulation
	
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getContlink() {
		return contlink;
	}

	public WebElement getCamplink() {
		return camplink;
	}
	
	
    public WebElement getSignoutimg() {
		return signoutimg;
	}

	public WebElement getSignout() {
		return signout;
	}

	//	Rule 5: Provide action
	public void navigateToCampainpage() {
		WebDriverUtility wb=new WebDriverUtility();
		wb.mouseOver(driver, morelink);
	}
	public void moveToSignout() {					
	WebDriverUtility wb=new WebDriverUtility();
	wb.mouseOver(driver,signoutimg);

	}
	
	}

