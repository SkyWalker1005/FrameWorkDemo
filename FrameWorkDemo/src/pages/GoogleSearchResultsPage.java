package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;

public class GoogleSearchResultsPage extends BasePage{

	@FindBy(xpath="//*[@id='tsf']/div[2]/div/div[2]/div/div[1]/input")
	WebElement searchResultsTextBox;
	@FindBy(xpath="//*[contains(text(), 'Amazon.in')]")  //Amazon
	WebElement clickOnAmazonResults;
	@FindBy(xpath="//*[contains(text(), 'Selenium - Web Browser Automation')]")  //Selenium
	WebElement clickOnSeleniumResults;
	@FindBy(xpath="//*[contains(text(), 'https://www.wikipedia.org/')]")  //Wiki
	WebElement clickOnWikiResults;
	public GoogleSearchResultsPage(WebDriver driver) {
		super(driver, BasePage.testName);
		// TODO Auto-generated constructor stub
	}
	public void searchText(String searchKey) throws IOException{
		waitForElementToAppear(searchResultsTextBox);
		searchResultsTextBox.clear();
		searchResultsTextBox.sendKeys(searchKey);
	}
	public void clickOnDesiredResults(String searchKey) throws IOException{
		switch(searchKey)
		{
		case "Amazon": 
			waitForElementToBeClickable(clickOnAmazonResults);
			clickOnAmazonResults.click();
			break;
		case "Selenium": 
			waitForElementToBeClickable(clickOnSeleniumResults);
			clickOnSeleniumResults.click();
			break;
		case "Wikipedia": 
			waitForElementToBeClickable(clickOnWikiResults);
			clickOnWikiResults.click();
			break;
		}
	}
	

}
