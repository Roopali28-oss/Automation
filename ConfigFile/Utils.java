package com.spring.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utils {

	public static void CreateDirectoryIfNotExist(String folder){		
		File theDir = new File(folder);		
		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    boolean result = false;
		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		    	  System.out.println("Unable to Create Directory for storing Reports "+folder);  
		    }        
		    if(result) {    
		        System.out.println("Created Directory for storing Reports "+folder);  
		    }
		}
	}
	
	//-This method will create new file within particular folder
	public static File CreateNewFile(String ReportsFolder, String filename){		
		CreateDirectoryIfNotExist(ReportsFolder);		
		File newFile = new File(ReportsFolder, filename);
		try {
			newFile.createNewFile();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		return newFile;		
	}
	
	public static String getFileExtension(){		
		Calendar calendar = Calendar.getInstance();		
		Calendar.getInstance();
		new SimpleDateFormat("dd-MM-yyyyHHMMa"); 		
		int month = calendar.get(Calendar.MONTH)+1;		
		String fileExtn = 
				"_"
				+ calendar.get(Calendar.DAY_OF_MONTH) + "_"
				+ month + "_"
				+ calendar.get(Calendar.YEAR) + "_"
				+ calendar.get(Calendar.HOUR_OF_DAY) + "_"
				+ calendar.get(Calendar.MINUTE) + "_"
				+ calendar.get(Calendar.SECOND);
		
		return fileExtn;
		
	}
	
	//-This method will generate random number at the time of execution
	public static int getRandomNumberInRange(int min, int max) {
	    if (min >= max) {
	        throw new IllegalArgumentException("max must be greater than min");
	        }
	    Random r = new Random();
	    return r.nextInt((max - min) + 1) + min;
	}
	
	
	
	
	//-Capture screenshot and store in folder
	public static String captureScreenShot2(WebDriver driver,
			String ScreenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyy-MM-dd hhmmss")
				.format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshot/"
				+ ScreenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	//-Scroll on page
	public static void scrollOnPage(WebDriver driver){		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)");
	}
	
}
