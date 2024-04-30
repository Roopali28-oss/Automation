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

public class EditItemTest extends Baseclass {

	@Test(priority = 1)
	public void EditItem() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that User Is Able to Add Item")
					.assignCategory(sanitySuite_tag + "_" + env);
			node = extenttest.createNode("Report");
			
			

			

			//Click on Home Dasboard on the side Menu
			
		node.log(Status.INFO,
					"STEP1 : Go to Succhi Homepage");

			//Utils.GoToHomepage(node,driver,XpathInterface.HomePage.homepage);

			Thread.sleep(3000);
			
			
			node.log(Status.INFO,
					"STEP2 : Click on the classification dropdown");
			
			
			// Waiting for the Classification dropdowm
	
			
			IWaitStrategy.waitForVisiblity(node, driver,
					XpathInterface.EditItem.Classification);
			Thread.sleep(3000);
			
						Utils.Search_By_Classification(node,driver,"Classification");
						

						node.log(Status.INFO,
								"STEP3 : Search from the Classification dropdown");

						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.EnterClassification);
		
						Utils.Search_In_Classification(node,driver,"EnterClassification");
						Thread.sleep(3000);
					

						node.log(Status.INFO,
								"STEP4 : Select the option from the Classification dropdown");
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.SelectClassification);
						
						Thread.sleep(3000);
						Utils. Select_Classification (node,driver, "SelectClassification");
						Thread.sleep(3000);
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.EllipseEditDetails);
						Thread.sleep(1000);
						Utils.Click_On_EllipseEditItem(node,driver,XpathInterface.EditItem.EllipseEditDetails);
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.EditButton);
						
						Thread.sleep(2000);
						
						Utils.Click_On_Editbutton(node,driver,XpathInterface.EditItem.EditButton);
						
						Thread.sleep(20000);
						Thread.sleep(2000);
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.ItemType);
						Thread.sleep(2000);
						Utils.Add_ItemType(node,driver,XpathInterface.EditItem.ItemType);
						
						Utils.Enter_ItemType(node,driver,"ItemTypeName");
						
						Thread.sleep(2000);
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.SelectItemName);
						
						Thread.sleep(2000);
						
						Utils.Select_ItemType(node,driver,XpathInterface.EditItem.SelectItemName);
						Thread.sleep(2000);
						
						Utils.Add_Category(node,driver,XpathInterface.EditItem.Category);
						
						Thread.sleep(3000);
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.CategoryName);
						Utils.Enter_Category(node,driver,"CategoryName");
						
						
						Thread.sleep(3000);
						
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.SelectCategory);
						Thread.sleep(3000);
						Utils.Select_Category(node,driver,XpathInterface.EditItem.SelectCategory);
						
						Thread.sleep(2000);
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.Subcategory);
						
						Utils.Add_SubCategory(node,driver,XpathInterface.EditItem.Subcategory);
						
						

						Thread.sleep(2000);
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.SubCategoryName);
						
						Utils.Enter_SubCategory(node,driver,XpathInterface.EditItem.SubCategoryName);
						
						
						Thread.sleep(4000);
						IWaitStrategy.waitForVisiblity(node, driver,
							XpathInterface.EditItem.SelectSubcategory);
						Thread.sleep(3000);
						
						Utils.Select_SubCategory(node,driver,XpathInterface.EditItem.SelectSubcategory);
						
						Thread.sleep(3000);
						
						
						node.log(Status.INFO, "STEP6 : Verify that View Item Button is visible on the Edit Item Page");

						IWaitStrategy.waitForVisiblity(node, driver, TestDataInterface.Dashboard.ViewItem_passCase);

						node.log(Status.INFO, "STEP7 : logged in user name is visible on top of Dashboard");

						IElementActions.assertTrue(extenttest, driver, TestDataInterface.Dashboard.ViewItem_passCase,
								"STEP7 :BUG:If View Item button is not on the EditItem Page",
								"STEP7 :EXPECTED:View Item button should come om the EditItem Page");
						
						IWaitStrategy.waitForVisiblity(node, driver,
								XpathInterface.EditItem.ManageSKU);
						Thread.sleep(3000);
						Utils.Manage_SKU(node,driver,XpathInterface.EditItem.ManageSKU);
						
						Thread.sleep(3000);
						
						
						Utils.Manage_SKU(node,driver,XpathInterface.EditItem.ColorwayName);
						
						
						
						
						
						
			
						
						
						
						
						
						
						

		}
						
						
			
			
			
			
			
			


		catch (Exception EditItem ) {
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

			EditItem.printStackTrace();
			node.fail(EditItem);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

}
