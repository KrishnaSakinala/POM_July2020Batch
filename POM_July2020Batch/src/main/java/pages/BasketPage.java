package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class BasketPage extends BasePage{

	@FindBy(xpath = "//*[@id=\"coupon_code\"]")
	private WebElement couponCodeTextbox;
	
	@FindBy(xpath = "//input[@name='apply_coupon']")
	private WebElement applyCouponButton;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")
	private WebElement proceedToCheckoutButton;
	
	public BasketPage(WebDriver driver,ExtentTest extentTest) {
		super(driver,extentTest);
	}
	
	public CheckoutPage proceedToCheckout()
	{
		waitUntilElementVisible(couponCodeTextbox);
		couponCodeTextbox.sendKeys("krishnasakinala");
		applyCouponButton.click();
		
		proceedToCheckoutButton.click();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver,extentTest);
		PageFactory.initElements(driver, checkoutPage);
		
		return checkoutPage;
	}
	

}
