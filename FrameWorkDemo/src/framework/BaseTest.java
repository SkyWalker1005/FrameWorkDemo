package framework;


import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  
	protected WebDriver driver;
  @BeforeMethod
  @Parameters({"browserName","webSite"})
  public void setup(String browserName,String webSite) throws Exception {
	  if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Lalit\\Selenium\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			else if(browserName.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "D:\\Lalit\\Selenium\\drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
			else if(browserName.equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver", "D:\\Lalit\\Selenium\\drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
			else if(browserName.equalsIgnoreCase("edge")){
				System.setProperty("webdriver.edge.driver", "D:\\Lalit\\Selenium\\drivers\\MicrosoftWebDriver.exe");
				driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}
			else{
				throw new Exception("Browser is not correct");
			}
	  driver.get(webSite);
  }
@AfterMethod
public void closeBrowser(){
	if(driver!=null){
	driver.close();
	}
}
 
  public WebDriver getDriver(){
	  return driver;
  }

}

