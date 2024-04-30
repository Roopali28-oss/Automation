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

public class AddItemTest extends Baseclass {

	@Test(priority = 1)
	public void AddItem() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that User Is Able to Add Item")
					.assignCategory(sanitySuite_tag + "_" + env);
			node = extenttest.createNode("Report");
			
			
			//waiting for the Home dashboard page to be opened.
			
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItem.ProductionSelect);

			//Click on Production on the side Menu

			node.log(Status.INFO,
					"STEP2 : Click on the Production List and call the ProductionList function from Util Class");
			Utils.ClickProductionList(node,driver,"ProductionSelect");
			
			
			

			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItem.Itemlist);
			
			node.log(Status.INFO, "STEP3 : Click on the ItemList and call Itemlist function from Util Class");
			Utils.ClickItemlist(node,driver,"Itemlist");
			Thread.sleep(3000);
			
			//Wait for the ItemList to be loaded and then click on Add Item
			
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItem.additem);
			
			
			
			
			//Function to Click on Add Item
			node.log(Status.INFO,
					"STEP2 : Click on Add Item and call the ProductionList function from Util Class");
			
			Utils.ClickonAddItem(node,driver,"ClickonAddItem");
			Thread.sleep(2000);
			
			
			// function to click on select classification from utils class
			node.log(Status.INFO,
					"STEP4 : Call the Select Classification  function from utils class");
			
			// wait for the Select Classification dropdown to be displayed
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItem.ClickSelectClassification);

			Utils.ClickSelectClassification(node, driver,"ClickSelectClassification");
			Thread.sleep(2000);
				

			// Select the classification
			node.log(Status.INFO,
					"STEP5 : Select the Classification");
			Utils.SelectClassification(node, driver,"SelectClassification");
			

			node.log(Status.INFO,
					"STEP6 : Enter Item Name into the field");
			//System.out.println(urlData);
			
			Utils.EnterItemName(node,driver,Baseclass.urlData.getProperty("ItemName"));
			Thread.sleep(3000);

			// Enter ItemNumber
			node.log(Status.INFO,
					"STEP8 : Enter the ItemNumber in the field");
			
			Utils.EnterItemNumber(node,driver, Baseclass.urlData.getProperty("ItemNumber"));
			
			// Enter the Company Name
			
			node.log(Status.INFO,
					"STEP8 : Search and Enter the CompanyName in the field");
			
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItem.SearchCompany);
			Utils.SearchCompany(node,driver,"Search Company");
			Utils.EnterCompanyName(node,driver,"SearchCompanyName2");
			
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItem.SelectCompanyName);
			
			Utils.SelectCompany(node,driver,"SelectCompanyName");
			
			
			// Enter the Item Status as New
			

			node.log(Status.INFO,
					"STEP9 : Search and Select the ItemStatus in the field");
			
			// Waiting to click on Item Description
			
			node.log(Status.INFO,
					"STEP10 :  Click and enter the values in the Item Description Field");
			
Utils.EnterItemDescription(node,driver,"ItemDescription");


// Click on Add Item to Add the item to the list.

node.log(Status.INFO,"STEP11 :  Click on Add Button");

Utils.ClickOnAdd(node,driver,"Add");

Thread.sleep(2000);
node.log(Status.INFO,"STEP12 :  Click on Complete Button");

Utils.ClickOnCompleteButton(node,driver,"Complete");





		}

	

	

	 catch (AssertionError AddItem) {

			node.log(
					Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In AddItem test in  class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(
					driver, "UserLogin_Fail");
			node.log(
					Status.FAIL,
					"Some Assertion Error"
							+ extenttest.addScreenCaptureFromPath(screenpath));

			AddItem.printStackTrace();
			node.fail(AddItem);
			Assert.fail();
			extent.flush();
		}

		catch (Exception AddItem ) {
			node.log(
					Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In AddItem test in AddItemTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(
					driver, "Use_Fail");
			node.log(
					Status.FAIL,
					"Some Exception Error"
							+ extenttest.addScreenCaptureFromPath(screenpath));

			AddItem.printStackTrace();
			node.fail(AddItem);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

}
