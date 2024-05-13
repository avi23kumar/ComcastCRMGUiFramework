package com.comcat.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.objectrepositoryutility.POM.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.POM.Contactspage;
import com.comcast.crm.objectrepositoryutility.POM.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.POM.HomePage;
import com.comcast.crm.objectrepositoryutility.POM.OrganizationCreationpage;
import com.comcast.crm.objectrepositoryutility.POM.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.POM.Organizations_childbrowserPage;
import com.comcast.crm.objectrepositoryutility.POM.Organizationspage;
import com.comcat.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.BaseClass.BaseClass;

//@Listeners(com.crm.comcast.ListenerUtility.ListImpClass.class)
public class CreateContactTest extends BaseClass {

	@Test /* (groups = "smoke testing") */
	public void createContactTest() throws Throwable {

//		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
//			Step 2: navigate  to contact module 			
		HomePage hp = new HomePage(driver);
		hp.getContlink().click();

//		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
//			Step 3: click on "create organization" button
		Contactspage conpage = new Contactspage(driver);
		conpage.getCreatecont().click();

//		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
//			Step 4: enter all the details and create new organization
		String lastname = ex.getDataFromExcel("Sheet2", 1, 1) + jU.getRandomNumber();

//		UtilityClassObject.getTest().log(Status.INFO, "creation of contact");
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastName().sendKeys(lastname);
		ccp.getSaveButton().click();

//		UtilityClassObject.getTest().log(Status.INFO, " verify headder phone number info expected result");
//			Step 5: verify headder phone number info expected result
		ContactInformationPage cont = new ContactInformationPage(driver);
		String actlastname = cont.getActheradder().getText();
		boolean status = actlastname.contains(lastname);
		/*SoftAssert asrt=new SoftAssert();*/
		Assert.assertEquals(status, true);
		/*if (actlastname.contains(lastname)) {
			System.out.println(lastname + " is avaliable");
		} else {
			System.out.println(lastname + " is==fail");
		}*/
//		asrt.assertAll();

	}

	@Test
	public void CreateContactWithOrgTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hompg = new HomePage(driver);
		hompg.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization page");
		Organizationspage orgpg = new Organizationspage(driver);
		orgpg.getOrgbutton().click();

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgname = ex.getDataFromExcel("Sheet1", 16, 2) + jU.getRandomNumber();
		OrganizationCreationpage orgcre = new OrganizationCreationpage(driver);
		orgcre.getOrgname().sendKeys(orgname);
		orgcre.getSavebutton().click();

		UtilityClassObject.getTest().log(Status.INFO, "get name of the organization page and verify");
		// verify header msg expected result
		Thread.sleep(5000);
		OrganizationInformationPage orginfo = new OrganizationInformationPage(driver);
		String actorgname = orginfo.getActorgname().getText();

		if (actorgname.contains(orgname)) {
			System.out.println(orgname + "is contains==pass");
		} else {
			System.out.println(orgname + "is not contains==fail");
		}

		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		hompg.getContlink().click();
		Contactspage create = new Contactspage(driver);
		create.getCreatecont().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		String conlastname = ex.getDataFromExcel("Sheet1", 16, 3) + jU.getRandomNumber();
		CreateContactPage crecont = new CreateContactPage(driver);
		crecont.getLastName().sendKeys(conlastname);
		crecont.getOrgname().click();

		wuti.switchToTabOnURL(driver, "module=Accounts");

		Organizations_childbrowserPage orgchild = new Organizations_childbrowserPage(driver);
		orgchild.getSearch_txt().sendKeys(orgname);
		orgchild.getSearch().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		wuti.switchToTabOnURL(driver, "Contacts&action");

		CreateContactPage createconpag = new CreateContactPage(driver);
		createconpag.getSaveButton().click();

		ContactInformationPage coninfo = new ContactInformationPage(driver);
		String actheadder = coninfo.getActheradder().getText();

		if (actheadder.contains(conlastname)) {
			System.out.println(conlastname + "is contains==pass");
		} else {
			System.out.println(conlastname + "is not contains==fail");
		}

		String actorgname1 = coninfo.getActorgname().getText();

		if (actorgname1.contains(orgname)) {
			System.out.println(orgname + "is contains==pass");
		} else {
			System.out.println(orgname + "is not contains==fail");
		}
	}

	@Test
	public void CreateContactWithSupportDateTest() throws Throwable {

		Contactspage cont = new Contactspage(driver);
		HomePage hp = new HomePage(driver);
		hp.getContlink().click();
		cont.getCreatecont().click();

		CreateContactPage crepage = new CreateContactPage(driver);

		String lastname = ex.getDataFromExcel("Sheet1", 13, 2) + jU.getRandomNumber();
		crepage.getLastName().sendKeys(lastname);

		String Enddate = jU.getSystemDateYYYYMMDD();
		String Startdate = jU.getRequiredDateYYYDDMM(30);
		crepage.getStartDate().clear();
		crepage.getStartDate().sendKeys(Startdate);
		crepage.getEndDate().clear();
		crepage.getEndDate().sendKeys(Enddate);
		crepage.getSaveButton().click();

//	
		Thread.sleep(2000);

//verify header msg expected result 
//	 wlib.switchToAlertAndAccept(driver);

		String actstartdate = crepage.getActstartdate().getText();

		if (actstartdate.contains(Startdate)) {
			System.out.println(Startdate + "is contains==pass");
		} else {
			System.out.println(Startdate + "is not contains==fail");
		}

//verify header msg expected result 
		String actuallenddate = crepage.getActenddate().getText();

		if (actuallenddate.equals(Enddate)) {
			System.out.println(Enddate + "is verified==pass");
		} else {
			System.out.println(Enddate + "is not verified==fail");
		}
	}
}
