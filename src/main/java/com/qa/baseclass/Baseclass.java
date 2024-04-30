package com.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.qa.paths.BaseclassPaths;
import com.qa.paths.WebdriverPaths;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.testlistener.TestListeners;
import com.qa.utils.Utils;

@Listeners(TestListeners.class)
public class Baseclass {

	public static String env;
	public static String url;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest extenttest;
	public static ExtentTest node;
	public static WebDriver driver;
	public static Properties urlData = new Properties();
	public static Properties credentials = new Properties();
	public static Properties configFile = new Properties();
	public static String systemOsName = System.getProperty("os.name");
	public static String commonChromeWebdriverPath = System
			.getProperty("user.dir") + "/Chromedriver/chromedriver";
	public static String commonFirefoxWebdriverPath = System
			.getProperty("user.dir") + "/FirefoxDriver/geckodriver";
	public static String windowsOS = "Windows 10";
	public static String linuxOS = "Linux";
	public static String login_tag = "Login";
	public static String sanitySuite_tag = "SanitySuite";
	public static String regressionSuite_tag = "RegressionSuite";
	public static String Mac = "Mac OS X";
	public static String commonChromeWebdriverPath_mac = System
			.getProperty("user.dir") + "/Chromedriver/chromedrivermac";

	@Parameters({ "Browser" })
	@BeforeSuite
	public static void setUp(String Browser) throws InterruptedException,
			IOException {

		// Config Property File
		File ConfigFile = new File(System.getProperty("user.dir")
				+ "/ConfigFile/Config.properties");

		FileInputStream fileInput3 = null;
		fileInput3 = new FileInputStream(ConfigFile);
		configFile.load(fileInput3);

		// Initializing the property method by calling property function from
		// BaseclassPaths
		BaseclassPaths.property();

		// Create object of baseclasspath and access its variable
		BaseclassPaths obj = new BaseclassPaths();
		env = configFile.getProperty("Environment");
		url = configFile.getProperty("url");

		Utils util = new Utils();

		// Create report folder in project root
		IScreenAction.createDirectoryForReport();

		// Launch the webdriver as per browser selected in config file
		Browser = configFile.getProperty("Browser");

		if (Browser.equalsIgnoreCase("chrome")) {

			// Call Chrome function WebdriverPaths class
			WebdriverPaths.Webdriver_chrome();

		}

		else if (Browser.equalsIgnoreCase("firefox")) {

			// Call Firefox function for WebdriverPaths class
			WebdriverPaths.Webdriver_firefox();
		}

		// Extent Report Setup
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "/QA-Report/AutomationReport_"
				+ IScreenAction.getFileExtension() + "Spark.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] { ViewName.CATEGORY, ViewName.DASHBOARD,
						ViewName.TEST, ViewName.EXCEPTION, ViewName.AUTHOR,
						ViewName.DEVICE, ViewName.LOG }).apply();
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("OS", systemOsName);
		extent.setSystemInfo("Host Name", "Demo");
		extent.setSystemInfo("Environment", env);
		extent.setSystemInfo("Url", url);
		extent.setSystemInfo("User Name", "Roopali Pahuja");
		reporter.config().setDocumentTitle("Automation-Testing");
		reporter.config().setReportName("Succhi-AutomationReport");
		reporter.config().setTheme(Theme.DARK);

	}

	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			node.log(Status.FAIL, MarkupHelper.createLabel(result.getName()
					+ " :Test case FAILED due to below issues:",
					ExtentColor.RED));
			node.log(Status.FAIL, result.getThrowable());

			// test1.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			node.log(
					Status.PASS,
					MarkupHelper.createLabel(result.getName()
							+ " :Test Case PASSED", ExtentColor.GREEN));

		} else if (result.getStatus() == ITestResult.SKIP) {
			node.log(
					Status.SKIP,
					MarkupHelper.createLabel(result.getName()
							+ " :Test Case SKIPPED ", ExtentColor.YELLOW));

		}
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		driver.quit();

	}
}
