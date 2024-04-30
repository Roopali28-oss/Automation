package com.Sanity.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.locators.allPages.XpathInterface;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.Utils;
import com.testdata.allPages.TestDataInterface;

public class SearchOnHomePageTest extends Baseclass {

	@Test(priority = 1)
	public void SearchHomePage() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that User Is Able to Search the Item on HomePage")
					.assignCategory(sanitySuite_tag + "_" + env);
			node = extenttest.createNode("Report");
			
			node.log(Status.INFO,
					"STEP1 : Go to Succhi Homepage");

			Utils.GoToHomepage(node,driver,XpathInterface.HomePage.homepage);

			Thread.sleep(3000);
			
			
			//waiting for the Search option to be displayed after the click

			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.SearchFunctionality.SearchHomepage);
			
			Thread.sleep(2000);

			//Click on the Search option
			node.log(Status.INFO,
					"STEP1 : Click on Search option and call Search functionality Util Class");
			Utils.SearchOnHomePage(node,driver,"Search");
			
			Thread.sleep(3000);			
		
			
			Utils.Scrolldown();
			

			Thread.sleep(3000);
			
			Utils.ScrollUp(driver);
			
			// Logging out after the searching
			
			Thread.sleep(2000);
			
			
			
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.LogOut.Admin);
		
			node.log(Status.INFO,
					"STEP2 : Click on Admin option and call ClickoOnAdmin from Util Class");
			
			Utils.ClickoOnAdmin(node,driver,"Admin");
			
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.LogOut.Logout);

			node.log(Status.INFO,
					"STEP2 : Click on Logout option and call Logout from Util Class");
			
			Utils.Logout(node,driver,"Logout");
			
		
		}

		catch (Exception SearchHomePage) {
			node.log(
					Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In SearchHomePage test in SearchOnHomePageTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(
					driver, "SearchHomePage_Fail");
			node.log(
					Status.FAIL,
					"Some Exception Error"
							+ extenttest.addScreenCaptureFromPath(screenpath));

			SearchHomePage.printStackTrace();
			node.fail(SearchHomePage);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

}
