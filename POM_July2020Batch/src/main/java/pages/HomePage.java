package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class HomePage extends BasePage{
	
	@FindBy(how = How.ID, using = "s") 
	private WebElement searchTextbox;
	
	public HomePage(WebDriver driver,ExtentTest extentTest)
	{
		super(driver,extentTest); // calling the parent class constructor
	}
	
	public SearchResultsPage searchBook() throws InterruptedException
	{
		searchTextbox.sendKeys("Selenium Ruby");
		extentTest.info("Entered Selenium Ruby book in the search box.");
		searchTextbox.sendKeys(Keys.ENTER);
		extentTest.info("It hit enter to search the book.");
		//PageFactory.initElements(driver, new SearchResultsPage(driver));
		//return new SearchResultsPage(driver);
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver,extentTest);
		PageFactory.initElements(driver, searchResultsPage);
		return searchResultsPage;
	}

}



























