package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.HomePage;
import pages.ProductDisplayPage;
import pages.SearchResultsPage;

public class PlaceOrderTest extends BaseTest{
	
	@Test
	public void placeOrderByCOD() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		PageFactory.initElements(driver, homePage);
		SearchResultsPage searchResultsPage = homePage.searchBook();
		ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();		
	}

}
