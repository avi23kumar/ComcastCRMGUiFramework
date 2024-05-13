package com.comcat.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.POM.HomePage;
import com.comcast.crm.objectrepositoryutility.POM.OrganizationCreationpage;
import com.comcast.crm.objectrepositoryutility.POM.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.POM.Organizationspage;
import com.comcast.crm.objectrepositoryutility.POM.Orginfopage;
import com.crm.comcast.BaseClass.BaseClass;

public class CreateOrganizationtest extends BaseClass {

	@Test(groups = "smoke testing")

	public void createOrganizationtest() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();
//				  hp.navigateToCampainpage();

		Organizationspage org = new Organizationspage(driver);
		org.getOrgbutton().click();

//				  driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

		String orgname = ex.getDataFromExcel("Sheet1", 1, 2) + jU.getRandomNumber();
		String indus = ex.getDataFromExcel("Sheet1", 18, 2);
//				  driver.findElement(By.name("accountname")).sendKeys(orgname);

		OrganizationCreationpage orginfo = new OrganizationCreationpage(driver);
		orginfo.writeorg(orgname, indus);
//				  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

////verify header msg expected result 

		OrganizationInfoPage info = new OrganizationInfoPage(driver);
		Thread.sleep(5000);
		String text = info.getHeaddermsg().getText();
		if (text.contains(orgname)) {
			System.out.println(orgname + "is contains==pass");
		} else {
			System.out.println(orgname + "is not contains==fail");
		}

		// verify header msg expected result

		String actualorgname = info.getActorgname().getText();
		if (actualorgname.equals(orgname)) {
			System.out.println(orgname + "is contains==pass");
		} else {
			System.out.println(orgname + "is not contains==fail");
		}

		hp.getOrglink().click();
		org.getSearchbox().sendKeys(orgname);

		wuti.selectbyvisibletext(org.getSearchDD(), "Organization Name");
		org.getSearch().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='" + orgname + "']/../../td[8]/a[text()='del']")).click();
		Thread.sleep(5000);

		wuti.switchToAlertAndAccept(driver);
		hp.moveToSignout();
		Thread.sleep(2000);

	}

	@Test

	public void createorganizationWithINdustest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.getOrglink().click();

		Organizationspage orgpg = new Organizationspage(driver);
		orgpg.getOrgbutton().click();

		OrganizationCreationpage org = new OrganizationCreationpage(driver);
		String orgName = ex.getDataFromExcel("Sheet1", 4, 2) + jU.getRandomNumber();
//		  String type = ex.getDataFromExcel("Sheet1", 4, 4)+ jU.getRandomNumber();
		String inustype = ex.getDataFromExcel("Sheet1", 4, 3);
		org.getOrgnameedit().sendKeys(orgName);

//		org.getOrgnindusDD().click();
		Thread.sleep(3000);
		wuti.selectbyvisibletext(org.getOrgnindusDD(), "Finance");
		org.getSavebutton().click();
//verify the dropdown industries and type 
		Thread.sleep(2000);
		String actualind = org.getActindus().getText();
		if (actualind.contains("inustype")) {
			System.out.println("inustype information is verified==pass");
		} else {
			System.out.println("inustype information is not verified==fail");
		}

//verify header msg expected result 
//			 String actualtype =org.getActualtype().getText();
//			 if (actualtype.contains(type)) {
//				System.out.println(type+ "information is verified==pass");
//			}else {
//				System.out.println(type+ "information is not verified==fail");
//			}
	}

	@Test

	public void createOrgWithPhoneNumtest() throws Throwable {
		HomePage home = new HomePage(driver);
		home.getOrglink().click();

		Organizationspage orgpg = new Organizationspage(driver);
		orgpg.getOrgbutton().click();

		String orgName = ex.getDataFromExcel("Sheet1", 7, 2) + jU.getRandomNumber();
		String Phonenumber = ex.getDataFromExcel("Sheet1", 7, 3) + jU.getRandomNumber();

		OrganizationCreationpage org = new OrganizationCreationpage(driver);
		org.getOrgnameedit().sendKeys(orgName);
		org.getPhonum().sendKeys(Phonenumber);

		org.getSavebutton().click();

		// verify header msg expected result
		Thread.sleep(5000);

//verify header msg expected result 
		Orginfopage orginfo = new Orginfopage(driver);

		String actualorgname = orginfo.getActphone().getText();
		if (actualorgname.equals(Phonenumber)) {
			System.out.println(Phonenumber + " is created==pass");
		} else {
			System.out.println(Phonenumber + " is not created==fail");
		}
	}
}
