package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage{
	
	@FindBy(how = How.XPATH, using = "//a[@title='HTML5 WebApp Develpment']")
	private WebElement searchResultsBookTitle;
	
	
	public SearchResultsPage(WebDriver driver)
	{
		super(driver); // calling the parent class constructor
	}
	
	public ProductDisplayPage clickSearchedBook()
	{
		searchResultsBookTitle.click();
		PageFactory.initElements(driver, new ProductDisplayPage());
		return new ProductDisplayPage();
	}

}
