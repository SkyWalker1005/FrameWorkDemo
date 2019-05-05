package tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.BaseTest;
import pages.GoogleHomePage;
import pages.GoogleSearchResultsPage;
import utilities.DataProviderClass;

public class GoogleHomePageTest extends BaseTest{
  @Test(dataProvider="testData",dataProviderClass=DataProviderClass.class)
  public void run1(String searchKey,String title) throws IOException {
	  GoogleHomePage gHomePage=new GoogleHomePage(getDriver(),"GoogleHomePageTest");
	  gHomePage.searchText(searchKey);
	  gHomePage.clickSearch();
	  GoogleSearchResultsPage gSearchPage=new GoogleSearchResultsPage(getDriver());
	  gSearchPage.clickOnDesiredResults(searchKey);
	  Assert.assertEquals(getDriver().getTitle(), title);
  }
}
