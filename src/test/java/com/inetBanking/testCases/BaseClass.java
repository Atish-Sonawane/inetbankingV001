package com.inetBanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.inetBanking.utilities.Extentmanager;
import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	// public String browser = readconfig.getBrowserName();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassord();
	public static WebDriver driver;

	public static Logger logger;
	
	@BeforeSuite
	public void Beforesuite() {
		Extentmanager.onStart();
	}
	
	@AfterSuite
	public void Aftersuite() {
		Extentmanager.onFinish();
	}


	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome")String browser) {

		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

		if (browser.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// configProp.getProperty("chromepath"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			// System.setProperty("webdriver.chrome.driver",
			// configProp.getProperty("edgepath"));
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		}
		logger.info("*************** Launchimg browser ****************");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
	public void captureScreen(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		// after execution you could see a folder "FailedTestScrenshots" under SRC
		// folder
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + screenshotName + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot tacken");
	}

	public String randomString() {
		String geneateString = RandomStringUtils.randomAlphabetic(7);
		return geneateString;
	}

	public String randomNumber() {
		String geneateNumber = RandomStringUtils.randomNumeric(10);
		return geneateNumber;
	}

}
