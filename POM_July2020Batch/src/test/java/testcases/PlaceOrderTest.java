package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.*;
import repo.DataUtil;

public class PlaceOrderTest extends BaseTest {

	@Test
	public void placeOrderByCOD() throws InterruptedException {
		
		extentTest = extentReports.createTest("PlaceOrderByCOD", "Place order using Cash on Delivery Method.");

		if(DataUtil.isTestExecutable(eat, "placeOrderByCOD"))
		{
			HomePage homePage = new HomePage(driver,extentTest);
			PageFactory.initElements(driver, homePage);
			SearchResultsPage searchResultsPage = homePage.searchBook();
			ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
			BasketPage basketPage = productDisplayPage.navigaTeBasketPage();
			CheckoutPage checkoutPage = basketPage.proceedToCheckout();
			checkoutPage.placeOrderUsingCOD();
		}
		else
		{
			throw new SkipException("Skipping the Test as run mode is N");
		}
	}

	@Test
	public void placeOrderByDirectBankTransfer() throws InterruptedException {
		
		
		extentTest = extentReports.createTest("placeOrderByDirectBankTransfer", "Place order using Direct Bank Transfer Method.");
		
		if(!DataUtil.isTestExecutable(eat, "placeOrderByDirectBankTransfer"))
		{
			throw new SkipException("Skipping the Test as run mode is N");
		}
		
		HomePage homePage = new HomePage(driver,extentTest);
		PageFactory.initElements(driver, homePage);
		SearchResultsPage searchResultsPage = homePage.searchBook();
		ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
		BasketPage basketPage = productDisplayPage.navigaTeBasketPage();
		CheckoutPage checkoutPage = basketPage.proceedToCheckout();
		checkoutPage.placeOrderByDirectBankTransfer();
	}
}
