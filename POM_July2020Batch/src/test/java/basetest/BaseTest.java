package basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public FileInputStream fis = null;
	public Properties config = null;

	@BeforeSuite
	public void init() throws IOException {
		fis = new FileInputStream("/Users/krishnasakinala/git/POM_July2020Batch/POM_July2020Batch/src/main/resources/config.properties");
		config = new Properties();
		config.load(fis);

		if (driver == null) {
			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "/AKSHAYA/Selenium/drivers/chromedriver83");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
				//System.setProperty("webdriver.gecko.driver", "/AKSHAYA/Selenium/drivers/geckodriver");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				driver = new EdgeDriver();
			}
		}
		driver.get(config.getProperty("url"));
	}
	
	@AfterSuite
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
	
}
//HTML5 WebApp Develpment
