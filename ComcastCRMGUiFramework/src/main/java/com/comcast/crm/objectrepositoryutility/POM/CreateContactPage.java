package com.comcast.crm.objectrepositoryutility.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname") private WebElement lastName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveButton;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img") private WebElement orgname;
	@FindBy(name="support_start_date") private WebElement startDate;
	@FindBy(name="support_end_date") private WebElement endDate;
	@FindBy(xpath="//span[@id='dtlview_Support Start Date']") private WebElement actstartdate;
	@FindBy(xpath="//td[@id='mouseArea_Support End Date']") private WebElement actenddate;
	
	public WebElement getActstartdate() {
		return actstartdate;
	}
	public WebElement getActenddate() {
		return actenddate;
	}
	public WebElement getStartDate() {
		return startDate;
	}
	public WebElement getEndDate() {
		return endDate;
	}
	public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
