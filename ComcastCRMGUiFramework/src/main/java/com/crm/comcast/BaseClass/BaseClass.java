	package com.crm.comcast.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.comcast.crm.objectrepositoryutility.POM.HomePage;
import com.comcast.crm.objectrepositoryutility.POM.LoginPage;
import com.comcat.crm.generic.fileutility.ExelUtility;
import com.comcat.crm.generic.fileutility.FileUtility;
import com.comcat.crm.generic.webdriverutility.JavaUtility;
import com.comcat.crm.generic.webdriverutility.UtilityClassObject;
import com.comcat.crm.generic.webdriverutility.WebDriverUtility;
import com.comcat.crm.grneric.databaseutility.dataBaseUtility;

public class BaseClass {

	public static WebDriver sdriver = null;
	public WebDriver driver = null;
	public FileUtility file = new FileUtility();
	public ExelUtility ex = new ExelUtility();
	public JavaUtility jU = new JavaUtility();
	public dataBaseUtility dblib = new dataBaseUtility();
	public ExtentSparkReporter REPORT;
	public WebDriverUtility wuti = new WebDriverUtility();

	@BeforeSuite /* (groups = {"smoke testing","regression testing"}) */
	public void configBS() {
		dblib.getDbconnection();
		System.out.println("====conn to DB==========");
	}

//	@Parameters ("BROWSER")
	@BeforeClass /* (groups = {"smoke testing","regression testing"}) */
	public void configBC(/* String browser */) throws Throwable {

//		String BROWSER = c;
		String browser = file.getDataFromPropertiesFile("browser");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else driver = new FirefoxDriver();
			
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		
		System.out.println("========exicute BC=========");
	}

	@BeforeMethod /* (groups = {"smoke testing","regression testing"}) */
	public void connBM() throws Throwable {
		
		String url = file.getDataFromPropertiesFile("url");
		String username = file.getDataFromPropertiesFile("username");
		String password = file.getDataFromPropertiesFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(url, username, password);
		
		System.out.println("====exicute BM==========");
	}

	@AfterMethod /* (groups = {"smoke testing","regression testing"}) */
	public void configAM() {
		
		HomePage hp = new HomePage(driver);
		hp.moveToSignout();
		hp.getSignout().click();
		
		System.out.println("========exicute AM=========");
	}

	@AfterClass /* (groups = {"smoke testing","regression testing"}) */
	public void connAC() {
		driver.quit();
		
		System.out.println("====exicute AC==========");
	}

	@AfterSuite /* (groups = {"smoke testing","regression testing"}) */
	public void configAS() throws Throwable {
		dblib.closeConnection();
		
		System.out.println("========close DB=========");
	}

}
