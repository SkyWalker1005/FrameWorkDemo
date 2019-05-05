package framework;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.TakeScreenshotClass;

public class BasePage {

	protected static String testName;
	protected static String ssPath=System.getProperty("user.home")+"//Screenshots";
	protected WebDriver driver;
	protected WebDriverWait wait;
	private int TIMEOUT= 20;
	private int POLLING= 100;
	public BasePage(WebDriver driver,String testName){
		this.driver=driver;
		BasePage.testName=testName;
		wait=new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);
		
	}
	protected void waitForElementToAppear(WebElement webElement) throws IOException {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        TakeScreenshotClass scrShot=new TakeScreenshotClass();
        scrShot.takeScreenshot(driver,ssPath,testName);
          }

    protected void waitForElementToDisappear(WebElement webElement) {
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
    protected void waitForElementToBeClickable(WebElement webElement) throws IOException {
        //wait.until(ExpectedConditions.elementToBeClickable(webElement));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        TakeScreenshotClass scrShot=new TakeScreenshotClass();
        scrShot.takeScreenshot(driver,ssPath,testName);
          }
}
