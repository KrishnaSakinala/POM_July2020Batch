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
		searchTextbox.sendKeys("HTML5 WebApp Develpment");
		searchTextbox.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		PageFactory.initElements(driver, new SearchResultsPage(driver));
		return new SearchResultsPage(driver);
	}

}



























