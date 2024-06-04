package org.enmovil.atf.util;

import org.enmovil.atf.config.BrowserDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseListener extends TestListenerAdapter {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest logger;

	@BeforeSuite
	public void startReport() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Reports//AMNS-Sanity.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name", "Enmovil");
		extent.setSystemInfo("Environment", "PROD");
		extent.setSystemInfo("User Name", "Sai Prakash");
		spark.config().setDocumentTitle("AMNS");
		spark.config().setReportName("AMNS SANITY");
		spark.config().setTheme(Theme.DARK);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			// logger.fail("Test Case Failed Snapshot is below " +
			// logger.addScreenCaptureFromPath("D:\\web-automation\\atf-web-ui\\Reports"));
			// logger.fail("Test Case Failed Snapshot is below " +
			// logger.addScreenCaptureFromPath("D:\\web-automation\\atf-web-ui\\ScreenShots"));
			BrowserDriver.takeScreenShot();
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			BrowserDriver.takeScreenShot();
		}
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	} 
}

/*
 * @Override public void onTestStart(ITestResult itr) {
 * log("Test Started.........."); }
 * 
 * @Override public void onTestSuccess(ITestResult itr) { log("Test "
 * +itr.getName() + " Passed"); log(itr.getTestClass());
 * log("Priority of the method is " +itr.getMethod().getPriority());
 * 
 * }
 * 
 * @Override public void onTestFailure(ITestResult itr) {
 * BrowserDriver.takeScreenShot(); log("Test " +itr.getName() + " Failed");
 * log(itr.getTestClass()); log("Priority of the method is "
 * +itr.getMethod().getPriority());
 * 
 * }
 * 
 * private void log(String methodName) { System.out.println(methodName); }
 * 
 * private void log(IClass testClass) { System.out.println(testClass); }
 */
