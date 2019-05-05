package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.BaseTest;
import pages.GoogleHomePage;
import pages.GoogleSearchResultsPage;
import utilities.DataProviderClass;

public class GoogleHomePageTest2 extends BaseTest{
  @Test(dataProvider="testData",dataProviderClass=DataProviderClass.class)
  public void run1(String searchKey,String title) throws IOException {
	  GoogleHomePage GhomePage=new GoogleHomePage(getDriver(),"GoogleHomePageTest2");
	  GhomePage.searchText(searchKey);
	  GhomePage.clickSearch();
	  GoogleSearchResultsPage gSearchPage=new GoogleSearchResultsPage(getDriver());
	  gSearchPage.clickOnDesiredResults(searchKey);
	  System.out.println(driver.getTitle());
	  System.out.println();
	  System.out.println(title);
	  Assert.assertEquals(driver.getTitle(), title);
	  
  }
}
