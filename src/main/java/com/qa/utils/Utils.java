package com.qa.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.locators.allPages.XpathInterface;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.element.IElementActions;

public class Utils extends Baseclass {

	/**
	 * The "isLinkBroken" function is used to check how many broken links
	 * available based on response.
	 *
	 * @param URL
	 *            url will enter
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 01.08.2021
	 ***/
	public static String isLinkBroken(URL url) throws Exception

	{

		String response = "";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try

		{

			connection.connect();

			response = connection.getResponseMessage();

			connection.disconnect();

			return response;

		}

		catch (Exception exp)

		{

			return exp.getMessage();

		}

	}

	/**
	 * The "findAllLinks" function is used fetch data in list based on same tag
	 * or you wan modify this functiona as per your requirement .
	 *
	 * @param driver
	 *            Selenium WebDriver Instance *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 01.08.2021
	 ***/
	public static List<WebElement> findAllLinks(WebDriver driver)

	{

		List<WebElement> elementList = new ArrayList<WebElement>();

		elementList = driver.findElements(By.tagName("a"));

		elementList.addAll(driver.findElements(By.tagName("img")));

		List<WebElement> finalList = new ArrayList<WebElement>();

		for (WebElement element : elementList)

		{

			if (element.getAttribute("href") != null
					&& element.getAttribute("href").contains("  ")) // add name

			{

				finalList.add(element);

			}

		}

		return finalList;

	}

	/**
	 * The "ChangeDateFormat" function is used to change date format .
	 *
	 * @param NewFormat
	 *            In which formate you want to chagne
	 * @param Date
	 *            date instance
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 01.08.2021
	 ***/
	public static String ChangeDateFormat(String NewFormat, String Date) {

		try {

			DateFormat formatter1 = new SimpleDateFormat(NewFormat);
			Date = formatter1.format(Date);

		} catch (Exception e) {

		}
		return Date;
	}

	/**
	 * The "getRandomNumberbetweenTwoLimits" function is used to generate random
	 * number between given limit*
	 *
	 * @param lowerBound
	 *            minimum range *
	 * @param upperBound
	 *            maximum range
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 01.08.2021
	 */
	public static int getRandomNumberbetweenTwoLimits(int lowerBound,
			int upperBound) {
		int randomNumber = 0;

		try {
			Random random = new Random();
			randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
		} catch (Exception e) {
			randomNumber = upperBound;
		}

		return randomNumber;

	}

	/**
	 * The "PauseTestExecution" function is used to pause run time execution as
	 * per given time*
	 *
	 * @param sec
	 *            pause time based on second at time time
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 01.08.2021
	 */
	public static void PauseTestExecution(int sec) {

		if (sec > 5)// show a warnig message, if test execution is paused more
			// than 5 seconds from
			// any
			System.out.println("Test Execution paused for " + sec);

		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The "userLogin" function is used to login into the application
	 *
	 * @param test
	 *            Extent Test Instance
	 * @param driver
	 *            Selenium WebDriver Instance *
	 * @param email
	 *            Pass email id at run time as per need
	 * @param passord
	 *            Enter password at run time
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 01.08.2021
	 */
	public static void userLogin(ExtentTest test, WebDriver driver,
			String email, String Password) throws InterruptedException {

		// Click on email id field and input the email.
		IElementActions.clickAndInput_usingInterface(test, driver,
				XpathInterface.LoginForm.emailField, email, "EmailId");

		// Click on password field and input the password.
		IElementActions.clickAndInput_usingInterface(test, driver,
				XpathInterface.LoginForm.passwordField, Password, "Password");

		// Click on login button
		IElementActions.clickelement(node, driver,
				XpathInterface.LoginForm.Submitbutton);
		node.log(Status.INFO, "FUNCTION-SUB STEP1 :Clicked on login button");
	}
	
	public static void ClickProductionList(ExtentTest test, WebDriver driver, String ProductionSelect)
	
	{ 
	
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItem.ProductionSelect);
		
		//IElementActions.clickelement(test, driver,XpathInterface.AddItem.ProductionSelect);
	}
	
	public static void ClickItemlist(ExtentTest test, WebDriver driver, String Itemlist)
	{
	
		//IElementActions.clickelement(test, driver,XpathInterface.AddItem.Itemlist);
		
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItem.Itemlist);
		
		
	}
	
public static void ClickSelectClassification(ExtentTest test, WebDriver driver, String fieldxpath)

{
	IElementActions.clickelement(test, driver,XpathInterface.AddItem.ClickSelectClassification);
}


public static void SelectClassification(ExtentTest test, WebDriver driver, String SelectClassification)

{
IElementActions.clickelement(test, driver,XpathInterface.AddItem.SelectClassification);

}

public static void ClickonAddItem(ExtentTest test, WebDriver driver, String ClickonAddItem)

{
//IElementActions.clickelement(test, driver,XpathInterface.AddItem.additem);
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItem.additem);

}

public static void EnterItemName(ExtentTest test, WebDriver driver, String ItemName) throws InterruptedException

{
	IElementActions.clickAndInput_usingInterface(test, driver,
			XpathInterface.AddItem.ItemName, "Testing ItemName1", "ItemName");

}

public static void EnterItemNumber(ExtentTest test, WebDriver driver, String ItemNumber) throws InterruptedException

{
	IElementActions.clickAndInput_usingInterface(test, driver,
			XpathInterface.AddItem.ItemNumber, "TestingItemnumber012", "ItemNumber");

}

public static void SearchCompany(ExtentTest test, WebDriver driver, String SearchCompany) throws InterruptedException

{
		
IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItem.SearchCompany);


	        	

}


public static void EnterCompanyName(ExtentTest test, WebDriver driver,String SearchCompanyName2)
{

//IElementActions.clickelement(test,driver,XpathInterface.AddItem.SearchCompany2);
IElementActions.EnterValues(test,driver,XpathInterface.AddItem.SearchCompany2,"Daffodil");
//IElementActions.ClickOnEnter(test,driver,XpathInterface.AddItem.SearchCompany2);

}

public static void SelectCompany(ExtentTest test, WebDriver driver,String SelectCompanyName)
{

//IElementActions.clickelement(test,driver,XpathInterface.AddItem.SearchCompany2);

IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItem.SelectCompanyName);
//IElementActions.ClickOnEnter(test,driver,XpathInterface.AddItem.SelectCompanyName);

}


public static void EnterItemDescription(ExtentTest test, WebDriver driver, String ItemDescription)
{

//IElementActions.clickelement(test,driver,XpathInterface.AddItem.SearchCompany2);

	IElementActions.EnterValues(test,driver,XpathInterface.AddItem.ItemDescription,"ItemTestingDescription");

}


public static void ClickOnAdd(ExtentTest test, WebDriver driver, String Add)
{

//IElementActions.clickelement(test,driver,XpathInterface.AddItem.SearchCompany2);

	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItem.Add);

}

public static void ClickOnCompleteButton(ExtentTest test, WebDriver driver, String Complete)
{



	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItem.Complete);

}













public static void Click_OnItemGroup(ExtentTest test,WebDriver driver, String ClickItemGroup)
{
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.ClickItemGroup);
}

public static void Click_OnEllipses(ExtentTest test,WebDriver driver,String Ellipse)
{

	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.Ellipse);
}


public static void Click_On_CreateItemGroup(ExtentTest test,WebDriver driver,String CreateNewGroup)
{
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.CreateNewGroup);
}

public static void Click_Enter_OnItemGroup(ExtentTest test, WebDriver driver, String ItemGroupName) throws InterruptedException
{
	//WebElement element=driver.findElement(By.xpath("XpathInterface.AddItemGroup.ItemGroupName"));
	//IElementActions.JavascriptExecutor_Click(test,driver,"XpathInterface.AddItemGroup.ItemGroupName");
	//element.sendKeys("QA ItemGroup");
	

	IElementActions.clickAndInput_usingInterface(test, driver,
			XpathInterface.AddItemGroup.ItemGroupName,"QAItemGroupTest", "ItemGroupName");
}



public static void Click_Enter_OnItemDescription(ExtentTest test, WebDriver driver, String ItemDescription) throws InterruptedException
{
	//WebElement element=driver.findElement(By.xpath("XpathInterface.AddItemGroup.ItemGroupDescription"));
	//IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.ItemGroupDescription);
	//element.sendKeys("QA ItemGroup Description");
	
	IElementActions.clickAndInput_usingInterface(test, driver,
			XpathInterface.AddItemGroup.ItemGroupDescription,"QAItemGroupTest Description", "ItemDescription");
}



public static void Click_On_AddItemGroup(ExtentTest test,WebDriver driver,String AddGroup)
{
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.AddGroup);
}


public static void GoToHomepage(ExtentTest test,WebDriver driver,String Homepage)
{
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.HomePage.homepage);
}

public static void SearchOnHomePage(ExtentTest test,WebDriver driver, String Search)
{
	
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.SearchFunctionality.SearchHomepage);
	
	IElementActions.EnterValues(test,driver,XpathInterface.SearchFunctionality.SearchHomepage,"Daffodil");
	
	
	
}

public static void ClickoOnAdmin(ExtentTest test,WebDriver driver,String Admin)
{

IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.LogOut.Admin);
}


public static void Logout(ExtentTest test, WebDriver driver,String Logout) throws InterruptedException
{
	
	
	
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.LogOut.Logout);
}


public static void Scrolldown()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}


//scroll up
	public static void ScrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,-400)", "");
		
	}
	
	public static void SearchItemGroup(ExtentTest test,WebDriver driver,String Searchitem) throws InterruptedException
	
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.SearchItem);

		IElementActions.EnterValues(test,driver,XpathInterface.AddItemGroup.SearchItem,"QAItem");
		/*
		IElementActions.clickAndInput_usingInterface(test, driver,
				XpathInterface.AddItemGroup.SearchItem,"SearchItem","QAItem");*/
		
	}
	
	public static void Click_On_Checkbox(ExtentTest test, WebDriver driver,String Checkbox)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.Checkbox);
	}
	
	
	public static void Save_ItemGroup(ExtentTest test,WebDriver driver,String Save)
	{
		
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.AddItemGroup.Save);
	}
	
	public static void Search_By_Classification(ExtentTest test, WebDriver driver, String Classification)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.Classification);
		
		
	}
	
	public static void Search_In_Classification(ExtentTest test, WebDriver driver,String EnterClassification)
	{
		IElementActions.EnterValues(test,driver,XpathInterface.EditItem.EnterClassification,"Aroma");
	}
	
	public static void Select_Classification (ExtentTest test, WebDriver driver, String SelectClassification)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.SelectClassification);
	}
	
	
	
	public static void Click_On_EllipseEditItem(ExtentTest test,WebDriver driver,String EditEllipse)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.EllipseEditDetails);
		
		
	}
	
	
	public static void Click_On_Editbutton(ExtentTest test,WebDriver driver,String EditButton)
	{
	
	IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.EditButton);
	
	}
	
	public static void Add_ItemType(ExtentTest test, WebDriver driver,String ItemType)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.ItemType);
	}
	
	public static void Enter_ItemType(ExtentTest test, WebDriver driver, String ItemTypeName)
	{
		IElementActions.EnterValues(test,driver,XpathInterface.EditItem.ItemTypeName,"Aroma1");
	}
	
	public static void Select_ItemType(ExtentTest test, WebDriver driver, String SelectItemName)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.SelectItemName);
	}
	
	public static void Add_Category(ExtentTest test, WebDriver driver, String Category)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.Category);
	}
	
	public static void Enter_Category(ExtentTest test, WebDriver driver, String CategoryName)
	{
		IElementActions.EnterValues(test,driver,XpathInterface.EditItem.CategoryName,"AromaCategory");
	}
	

	public static void Select_Category(ExtentTest test, WebDriver driver, String SelectCategory)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.SelectCategory);
	}
	

	public static void Add_SubCategory(ExtentTest test, WebDriver driver, String SubCategory)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.Subcategory);
		
	}
	

	public static void Enter_SubCategory(ExtentTest test, WebDriver driver, String CategoryName)
	{
		IElementActions.EnterValues(test,driver,XpathInterface.EditItem.SubCategoryName,"AromaSubcategory");
	}
	
	
	public static void Select_SubCategory(ExtentTest test, WebDriver driver, String SelectSubCategory)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.SelectSubcategory);
	}
	

	public static void Add_Seasons(ExtentTest test, WebDriver driver, String Seasons)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.Season);
	}
	
	

	public static void Select_Seasons(ExtentTest test, WebDriver driver, String Selectseason)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.Selectseason);
	}
	
	public static void Manage_SKU(ExtentTest test, WebDriver driver, String ManageSKU)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.ManageSKU);
	}
	
	public static void Click_On_Colorway(ExtentTest test, WebDriver driver, String ColorwayName)
	{
		IElementActions.JavascriptExecutor_Click(test,driver,XpathInterface.EditItem.ColorwayName);
	}
	
	
	
	
	
	
	

	
	
	
}

















