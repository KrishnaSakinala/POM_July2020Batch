package basetest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import repo.ExcelApiTest;

public class BaseTest {

	public WebDriver driver;
	public FileInputStream fis = null;
	public Properties config = null;

	public ExcelApiTest eat = null;

	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	@BeforeSuite
	public void init() throws Exception {

		eat = new ExcelApiTest(
				"/Users/krishnasakinala/git/POM_July2020Batch/POM_July2020Batch/src/main/resources/TestData.xlsx");

		fis = new FileInputStream(
				"/Users/krishnasakinala/git/POM_July2020Batch/POM_July2020Batch/src/main/resources/config.properties");
		config = new Properties();
		config.load(fis);

		if (extentReports == null) {
			extentHtmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "/src/main/resources/ATReport.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentHtmlReporter);
			
			extentReports.setSystemInfo("OS", "Mac OS");
			extentReports.setSystemInfo("Environment", "QA");
			extentReports.setSystemInfo("Author", "Krishna Sakinala");
			extentReports.setSystemInfo("Browser", config.getProperty("browser"));
			
			extentHtmlReporter.config().setChartVisibilityOnOpen(true);
			extentHtmlReporter.config().setDocumentTitle("Automation Report");
			extentHtmlReporter.config().setReportName("My Own Report");
			extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			extentHtmlReporter.config().setTheme(Theme.DARK);
		}
		if (driver == null) {
			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				// System.setProperty("webdriver.chrome.driver",
				// "/AKSHAYA/Selenium/drivers/chromedriver83");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {
				// System.setProperty("webdriver.gecko.driver",
				// "/AKSHAYA/Selenium/drivers/geckodriver");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				driver = new EdgeDriver();
			}
		}
		driver.get(config.getProperty("url"));
	}
	
	/*@BeforeMethod
	public void startApplication()
	{
		
	}*/

	private static String capture(WebDriver driver, String screenshotName) throws Exception
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/src/main/resources/Screenshots/"+screenshotName+".png";
		File destination = new File(dest);
		FileHandler.copy(source, destination);
		return dest;
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			extentTest.fail("Test Failed.");
			extentTest.fail(result.getThrowable());
			String path = capture(driver,"Screenshot");
			extentTest.fail("Find the Screenshot below: ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			extentTest.fail("Test Passed.");
		}
		else
		{
			extentTest.fail("Test Skipped.");
		}
	}
	
	
	@AfterSuite
	public void tearDown() {
		
		extentReports.flush();
		
		if (driver != null) {
			driver.quit();
		}
		
	}
}