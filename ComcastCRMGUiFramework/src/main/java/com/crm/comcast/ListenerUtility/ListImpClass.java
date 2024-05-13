package com.crm.comcast.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcat.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.comcast.BaseClass.BaseClass;

public class ListImpClass implements ITestListener, ISuiteListener {

	ExtentReports rep;
	ExtentSparkReporter REPORT;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		REPORT = new ExtentSparkReporter("./advancedreporting/report_" + time + ".html");
		REPORT.config().setDocumentTitle("CRM test Suite Result");
		REPORT.config().setReportName("CRM report");
		REPORT.config().setTheme(Theme.DARK);

		//add env information & Create test
		rep = new ExtentReports();
		rep.attachReporter(REPORT);
		rep.setSystemInfo("OS", "Windows 10");
		rep.setSystemInfo("Browser", "Chrome-v100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("report backup");
		rep.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====" + result.getMethod().getMethodName() + "====start=====");
		test = rep.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.PASS, result.getMethod().getMethodName() + "===>Started<====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====" + result.getMethod().getMethodName() + "====end=====");
		test.log(Status.PASS, result.getMethod().getMethodName() + "===>completed<====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String scr = ts.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(scr, testname + " " + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>completed<====");
	}

}
