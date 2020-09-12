package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage extends BasePage{
	
	@FindBy(xpath = "//*[@id=\"product-160\"]/div[2]/form/button")
	private WebElement addToBasketButton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/a")
	private WebElement viewBasketButton;
	
	public ProductDisplayPage(WebDriver driver)
	{
		super(driver); 
	}
	
	public BasketPage navigaTeBasketPage()
	{
		addToBasketButton.click();
		viewBasketButton.click();
		
		BasketPage basketPage = new BasketPage(driver);
		PageFactory.initElements(driver,basketPage);
		
		return basketPage;
		
	}

}
