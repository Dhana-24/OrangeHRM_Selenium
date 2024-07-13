package orangeHRM.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import orangeHRM.extentReport.ExtentManager;
import orangeHRM.utils.ReadInput;

public class OrangeHRMBase extends SeleniumBase{
	
	SeleniumBase sb = new SeleniumBase();
	ReadInput read = new ReadInput();
	public String appURL = read.getAppURL();
	
	public WebDriver getDriver() {

		return driver;
	}


	
	
	
	public void setup(String URL) {
		
		driver.manage().window().maximize();
		driver.get(URL);
		wait = new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
	}
	
	@BeforeSuite
	public void startApp() throws InterruptedException {
		
		driver = new ChromeDriver();
		setup(appURL);
		
	}
	
	@AfterSuite
	public void closeApp() {
		
		sb.quit();
		ExtentManager.extentReports.flush();
		
	}
	
	
	
}
