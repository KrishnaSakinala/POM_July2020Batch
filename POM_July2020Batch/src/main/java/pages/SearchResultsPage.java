package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class SearchResultsPage extends BasePage{
	
	@FindBy(how = How.XPATH, using = "//a[@title='Selenium Ruby']")
	private WebElement searchResultsBookTitle;
	
	
	public SearchResultsPage(WebDriver driver,ExtentTest extentTest)
	{
		super(driver,extentTest); // calling the parent class constructor
	}
	
	public ProductDisplayPage clickSearchedBook() throws InterruptedException
	{
		searchResultsBookTitle.click();
		extentTest.info("Clicked on serached book.");
		Thread.sleep(15000);
		
		ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver,extentTest);
		PageFactory.initElements(driver, productDisplayPage);
		return productDisplayPage;
	}

}
