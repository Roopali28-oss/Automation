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

public class AddItemGroupTest extends Baseclass {

	@Test(priority = 1)
	public void AddItemGroup() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that User Is Able to Add ItemGroup")
					.assignCategory(sanitySuite_tag + "_" + env);
			node = extenttest.createNode("Report");
			
			
			//waiting for the Production option to be displayed after the click
/*
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItem.ProductionSelect);

			//Click on the Production option
			
			
			node.log(Status.INFO,
					"STEP1 : Click on the Production List and call the ProductionList function from Util Class");
			Utils.ClickProductionList(node,driver,"ProductionSelect");
			*/
			Thread.sleep(2000);

			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.AddItemGroup.ClickItemGroup);
			node.log(Status.INFO,
					"STEP2 : Click on the ItemGroup and call the Click_OnItemGroup function from Util Class");
			Utils.Click_OnItemGroup(node,driver,"ClickItemGroup");
			Thread.sleep(2000);
			
		
		
// Waiting for the option to create New ItemGroup
			
		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.Ellipse);
		
		// Click on the Ellipses to view the option of add group
		node.log(Status.INFO,
				"STEP3 : Click on the Ellipses and call the Click_OnEllipses function from Util Class");
		Utils.Click_OnEllipses(node,driver,"Ellipse");
		Thread.sleep(2000);
		
		// Waiting to view the New Group option
		
		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.CreateNewGroup);
		
		//Clicking on the New Group button.

		node.log(Status.INFO,
				"STEP4 : Click on the New Group opion  and call the Click_On_CreateItemGroup function from Util Class");
		Utils.Click_On_CreateItemGroup(node,driver,"CreateNewGroup");
		
		Thread.sleep(2000);
		
		// Waiting to view ItemGroup Name

		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.ItemGroupName);
		
		// Click on Itemgroup field and enter the value
		
		node.log(Status.INFO,
				"STEP5 : Click on the ItemGroupName and enter the values in the field");
		Utils. Click_Enter_OnItemGroup(node,driver,"ItemGroup");
		
		Thread.sleep(2000);
		
		//Waiting for element Itemgroup Description
		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.ItemGroupDescription);
		
		//Click on the Item Description field and enter the value

		node.log(Status.INFO,
				"STEP6 : Click on the Itemdescription and enter the values in the field");
		Utils.Click_Enter_OnItemDescription(node,driver,"ItemDescription");
		Thread.sleep(2000);
		
		node.log(Status.INFO,
				"STEP7 :Click on Add button to add the itemgroup");
		
		//Waiting for Add Item Group button
		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.AddGroup);
		
		Utils.Click_On_AddItemGroup(node,driver,XpathInterface.AddItemGroup.AddGroup);
		Thread.sleep(2000);
		
		//Go to Homepage
		
		Thread.sleep(2000);
		
		//Waiting to Search an item
		node.log(Status.INFO,"STEP8 :Search an item");
		
		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.SearchItem);
		Utils.SearchItemGroup(node,driver,"Searchitem");
		
		node.log(Status.INFO,"STEP8 :Click on the checkbox and Save the Itemgroup");
		//Waiting for the checkbox
		Thread.sleep(3000);
		
		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.Checkbox);
		Thread.sleep(3000);
		Utils.Click_On_Checkbox(node, driver,XpathInterface.AddItemGroup.Checkbox);
		Utils.Scrolldown();
		IWaitStrategy.waitForVisiblity(node, driver,
				XpathInterface.AddItemGroup.Save);
		Thread.sleep(3000);
		
		Utils.Save_ItemGroup(node,driver,XpathInterface.AddItemGroup.Save);


		
		
		
		
		}

		catch (Exception AddItemGroup) {
			node.log(
					Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In AddItemGroup test in AddItemGroupTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(
					driver, "AddItemGroup_Fail");
			node.log(
					Status.FAIL,
					"Some Exception Error"
							+ extenttest.addScreenCaptureFromPath(screenpath));

			AddItemGroup.printStackTrace();
			node.fail(AddItemGroup);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

}
