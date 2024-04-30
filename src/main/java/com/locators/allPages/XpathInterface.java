package com.locators.allPages;

public interface XpathInterface {

	interface Site {
		String loginPageView = "//span[contains(text(),'Log in to the GRID')]";
	}

	interface LoginForm {
		String emailField = "(//input[contains(@type,'email')])";
		String passwordField = "(//input[contains(@type,'password')])";
		String Submitbutton = "//span[contains(text(),'Log In')]";

	}

	interface Dashboard {
		String Search= "//input[@id='mat-input-8']";
	}

    interface AddItem
{
	String ProductionSelect="//span[contains(text(),'Production')]" ;
	
	String Itemlist="//a[contains(text(),'Item List')]";
	
	String additem="//span[contains(text(),'Add Item')]";
	
	String ClickSelectClassification="//span[contains(text(),'Select Classification')]";
	
	String SelectClassification="//span[contains(text(),'Aroma')]";
	
String ItemName="//label[contains(text(),'Item Name')]//parent :: div//input" ;
String ItemNumber="//label[contains(text(),'Item Number')]//parent::div//input" ;

String SearchCompany="//span[contains(text(),'Search Company')]";
String SearchCompany2 ="//input[@placeholder='Search Company']";
String SelectCompanyName="//span[@class='ng-star-inserted']//strong[contains(text(),'Daffodil')][1]";
String ItemDescription="//label[text()='Item Description']/following::input";
 String Add="//button[contains(text(),'Add')]";
 String Complete="//button[contains(text(),'Complete')]";
 
 
   
   
}
    
    interface AddItemGroup
    {
    	
    	String ClickItemGroup="(//a[@class='white-menu-link'])[3]";
    	
    	String Ellipse="//i[@class='fa fa-ellipsis-h']";
    	
    	String CreateNewGroup="//span[text()=' New Group ']";
    	
    	String ItemGroupName="//*[@name='groupName']";
    	
    	String ItemGroupDescription="//input[@name='description']";
    	
    	String AddGroup="//button[text()='Create']";
    	String SearchItem="//input[contains(@class,'search-text mat-input-element')]";
    	String Checkbox="//label[@for='mat-checkbox-1-input']//div";
    	String Save="//button[@class='btn orangeBtn']";
   
    }
    
    
    interface HomePage
    {
    	
    	String homepage="//*[@class='suuchi-logo']";
    }
    
   interface SearchFunctionality
   {
	  String SearchHomepage="//input[@ng-reflect-type='text']";
   }
   
   
   interface LogOut
   {
	   String Admin="//span[text()='Test Admin']";
	   String Logout="(//a[@class='dropdown-item'])[2]";
   }
   
   interface EditItem
   {
	   String Classification="//span[contains(text(), 'Select Classification')]";
	   String EnterClassification="//input[@placeholder='Select Classification']";
	   String SelectClassification="//strong[text()='Aroma']";
	   String EllipseEditDetails="//span[@class='glyphicon glyphicon-option-vertical']";
	   String EditButton="//button[@role='menuitem']//span";
	   String ItemType="(//span[text()='Item Type'])[2]";
	   String ItemTypeName="//input[contains(@class,'ngx-select__search form-control')]";
	   String SelectItemName="//strong[text()='Aroma1']";
	   String Category="(//span[text()='Category'])[2]";
	  String CategoryName="//input[@placeholder='Category']";
	  String SelectCategory="//strong[contains(text(),'AromaCategory')]";
	 String Subcategory="(//span[text()='Subcategory'])[2]";
	 String SubCategoryName="//input[@placeholder='Subcategory']";
	 String SelectSubcategory="//strong[contains(text(),'AromaSubcategory')]";
	 String Season="html>body>app-root>app-admin>app-main>div>mat-sidenav-container>mat-sidenav-content>div>app-content>app-product-information>div>div>app-product-info-header>div>div>form>div:nth-of-type(9)>div>ngx-select>div>div:nth-of-type(2)>div";
	 String Selectseason="//span[contains(text(),'Spring')]";
	 String  ManageSKU="//div[text()='Manage SKUs']";
	 String ColorwayName="//span[contains(text(),'Colorway Name')]";
	 


   }
   
   

	
}
    
    
    
    
