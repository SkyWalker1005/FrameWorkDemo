package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;

public class GoogleHomePage extends BasePage{

	String testName=null;
	@FindBy(xpath="/html/body/div/div[3]/form/div[2]/div/div[1]/div/div[1]/input")
	private WebElement searchBox;
	@FindBy(xpath="//*[@id='tsf']/div[2]/div/div[2]/div[2]/div/center/input[1]")
	private WebElement searchButton;
	public GoogleHomePage(WebDriver driver,String testName) {
		super(driver, testName);
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void searchText(String string) throws IOException{
		waitForElementToAppear(searchBox);
		searchBox.sendKeys(string);
	}
	public void clickSearch() throws IOException{
		waitForElementToBeClickable(searchButton);
		searchButton.click();
	}
	

}
