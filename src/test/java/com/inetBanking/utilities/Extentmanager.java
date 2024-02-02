package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentmanager extends TestListenerAdapter {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void onStart() {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname = "Test-Teport" + timestamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Report/myReport.html");

		htmlReporter.config().setDocumentTitle("InetBanking test project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostname", "LocalHost");
		extent.setSystemInfo("Envirinment", "QA");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester Name", "Atish");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkip(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	}

	public static void onFinish() {
		extent.flush();
	}

}
