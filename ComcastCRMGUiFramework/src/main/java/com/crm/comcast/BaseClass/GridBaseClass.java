package com.crm.comcast.BaseClass;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.objectrepositoryutility.POM.HomePage;
import com.comcast.crm.objectrepositoryutility.POM.LoginPage;
import com.comcat.crm.generic.fileutility.ExelUtility;
import com.comcat.crm.generic.fileutility.FileUtility;
import com.comcat.crm.generic.webdriverutility.JavaUtility;
import com.comcat.crm.generic.webdriverutility.WebDriverUtility;
import com.comcat.crm.grneric.databaseutility.dataBaseUtility;

public class GridBaseClass {

//	public static WebDriver sdriver = null;
	public RemoteWebDriver sdriver = null;
	public RemoteWebDriver driver = null;
	public FileUtility file = new FileUtility();
	public ExelUtility ex = new ExelUtility();
	public JavaUtility jU = new JavaUtility();
	public dataBaseUtility dblib = new dataBaseUtility();

	public WebDriverUtility wuti = new WebDriverUtility();

	@BeforeSuite /* (groups = {"smoke testing","regression testing"}) */
	public void configBS() {
		System.out.println("====conn to DB==========");
		dblib.getDbconnection();
	}

//	@Parameters ("BROWSER")
	@BeforeClass /* (groups = {"smoke testing","regression testing"}) */
	public void configBC(/* String browser */) throws Throwable {
		System.out.println("========exicute BC=========");

//		String BROWSER = c;
		String browser = file.getDataFromPropertiesFile("browser");

		URL url = new URL("http://192.168.116.1:4444");
		DesiredCapabilities dc = new DesiredCapabilities();

		if (browser.equalsIgnoreCase("chrome")) {
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WINDOWS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.WINDOWS);
		} else {
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.WINDOWS);
		}
		driver = new RemoteWebDriver(url, dc);
		sdriver = driver;
	}

	@BeforeMethod /* (groups = {"smoke testing","regression testing"}) */
	public void connBM() throws Throwable {
		System.out.println("====exicute BM==========");
		String url = file.getDataFromPropertiesFile("url");
		String username = file.getDataFromPropertiesFile("username");
		String password = file.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(url, username, password);
	}

	@AfterMethod /* (groups = {"smoke testing","regression testing"}) */
	public void configAM() {
		System.out.println("========exicute AM=========");
		HomePage hp = new HomePage(driver);
		hp.moveToSignout();
		hp.getSignout().click();

	}

	@AfterClass /* (groups = {"smoke testing","regression testing"}) */
	public void connAC() {
		System.out.println("====exicute AC==========");
		driver.quit();
	}

	@AfterSuite /* (groups = {"smoke testing","regression testing"}) */
	public void configAS() throws Throwable {
		System.out.println("========close DB=========");
		dblib.closeConnection();
	}

}
