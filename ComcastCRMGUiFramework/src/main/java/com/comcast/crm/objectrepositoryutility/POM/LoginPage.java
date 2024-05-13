package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcat.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {	// rule 1: create separate java class
		
//	rule 2: Object creation
	@FindBy(name="user_name") private WebElement userNameEdit;
	@FindBy(name="user_password") private WebElement passwordEdit;
	@FindBy(id="submitButton") private WebElement submitbutton;
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	Rule 4:Object Encapsulation
	/**
	 * username text field
	 * @return
	 */
	
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
 
	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	
//	Rule 5: Provide action
	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToapp(String url, String username , String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		submitbutton.click();
		
	}
	
	

	
}
