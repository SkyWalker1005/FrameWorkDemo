package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotClass {

	public void takeScreenshot(WebDriver driver,String ssPath,String testName) throws IOException{
		//logic to create folder if does not exists
		File ssPathDirectory=new File(ssPath);
		if(!ssPathDirectory.exists()){
			ssPathDirectory.mkdir();
		}
		File ssFolder=new File(ssPath+"//"+testName);
		if(!ssFolder.exists()){
			ssFolder.mkdir();
		}
		
		TakesScreenshot scrShot=(TakesScreenshot) driver;
		File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(ssFolder+"//"+new SimpleDateFormat("dd-MMM-yyyy").format(new Date())+" "+new SimpleDateFormat("hhmmss").format(new Date())+".png");
		FileHandler.copy(srcFile, destFile);
		
	}
}
