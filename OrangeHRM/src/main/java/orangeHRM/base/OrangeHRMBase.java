package orangeHRM.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import orangeHRM.utils.ReadExcel;
import orangeHRM.utils.Report;

public class OrangeHRMBase extends Report{
	
	String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	protected RemoteWebDriver driver = null; // if we use static, then it shows error during parallel execution
	
	public String fileName ="";
	
	@DataProvider(name="data")
	public String[][] dataProvider() {
		String[][] excelData =ReadExcel.getExcelData(fileName);
		return excelData;
	}
	
	
	@BeforeMethod
	public void startApp() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
	
	
}
