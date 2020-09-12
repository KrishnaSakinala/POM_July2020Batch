package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pages.*;

public class PlaceOrderTest extends BaseTest{
	
	@Test
	public void placeOrderByCOD() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		PageFactory.initElements(driver, homePage);
		SearchResultsPage searchResultsPage = homePage.searchBook();
		ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
		BasketPage basketPage = productDisplayPage.navigaTeBasketPage();
		CheckoutPage checkoutPage = basketPage.proceedToCheckout();
		checkoutPage.placeOrderUsingCOD();
	}

	@Test
	public void placeOrderByDirectBankTransfer() throws InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		PageFactory.initElements(driver, homePage);
		SearchResultsPage searchResultsPage = homePage.searchBook();
		ProductDisplayPage productDisplayPage = searchResultsPage.clickSearchedBook();
		BasketPage basketPage = productDisplayPage.navigaTeBasketPage();
		CheckoutPage checkoutPage = basketPage.proceedToCheckout();
		checkoutPage.placeOrderByDirectBankTransfer();
	}
}
