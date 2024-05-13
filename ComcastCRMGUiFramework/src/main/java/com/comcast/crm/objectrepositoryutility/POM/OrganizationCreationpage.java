package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationCreationpage {
		
	WebDriver driver;
	public OrganizationCreationpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname") private WebElement Orgnameedit;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement savebutton;
	@FindBy(name="industry") private WebElement OrgnindusDD;
	@FindBy(name="accounttype") private WebElement acctype;
	@FindBy(id="mouseArea_Industry") private WebElement actindus;
	@FindBy(id="mouseArea_Type") private WebElement actualtype;
	@FindBy(id="phone") private WebElement phonum;
	
	
	public WebElement getPhonum() {
		return phonum;
	}
	public WebElement getActualtype() {
		return actualtype;
	}
	public WebElement getActindus() {
		return actindus;
	}
	public WebElement getOrgnameedit() {
		return Orgnameedit;
	}
	public WebElement getOrgnindusDD() {
		return OrgnindusDD;
	}
	public WebElement getAcctype() {
		return acctype;
	}
	public WebElement getOrgname() {
		return Orgnameedit;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void writeorg(String orgname) {
		Orgnameedit.sendKeys(orgname);
		savebutton.click();
	}
	public void writeorg(String orgname , String indus) {
		Orgnameedit.sendKeys(orgname);
		Select sel=new Select(OrgnindusDD);
		sel.selectByVisibleText(indus);
		savebutton.click();
	}

}
