package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class ProductDisplayPage extends BasePage{
	
	@FindBy(xpath = "//*[@id=\"product-160\"]/div[2]/form/button")
	private WebElement addToBasketButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/a")
	private WebElement viewBasketButton;
	
	public ProductDisplayPage(WebDriver driver,ExtentTest extentTest)
	{
		super(driver,extentTest); 
	}
	
	public BasketPage navigaTeBasketPage()
	{
		addToBasketButton.click();
		extentTest.info("Clicked on add to basket button.");
		viewBasketButton.click();
		extentTest.info("Clicked on view basket button.");
		
		BasketPage basketPage = new BasketPage(driver,extentTest);
		PageFactory.initElements(driver,basketPage);
		
		return basketPage;
		
	}

}
