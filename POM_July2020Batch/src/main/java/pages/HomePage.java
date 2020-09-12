package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	@FindBy(how = How.ID, using = "s") 
	private WebElement searchTextbox;
	
	public HomePage(WebDriver driver)
	{
		super(driver); // calling the parent class constructor
	}
	
	public SearchResultsPage searchBook() throws InterruptedException
	{
		searchTextbox.sendKeys("Selenium Ruby");
		searchTextbox.sendKeys(Keys.ENTER);
		//PageFactory.initElements(driver, new SearchResultsPage(driver));
		//return new SearchResultsPage(driver);
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		PageFactory.initElements(driver, searchResultsPage);
		return searchResultsPage;
	}

}



























