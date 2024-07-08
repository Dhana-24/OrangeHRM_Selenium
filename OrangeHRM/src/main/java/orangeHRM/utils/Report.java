package orangeHRM.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	ExtentReports extent;
	public static ExtentTest test;
	public String desc = "";
	public String author = "";
	public String category = "";
	public String status = ""; 
	public String description = "";
	
	@BeforeSuite
	protected void startReport() {
		//blank html
				ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
				//report
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				/////
				test = extent.createTest(desc);
				test.assignAuthor(author);
				test.assignCategory(category);
		
	}
	@AfterSuite
	protected void stopReport() {
		extent.flush();//save
	}
	@BeforeClass
	void createTest() {
		test = extent.createTest(desc);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	@AfterTest
	public void stepReport() {
		
		switch(status.toLowerCase()) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.fail(description);
			break;
		case "warning":
			test.warning(description);
			break;
		case "info":
			test.info(description);
			break;
		}
		
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * test.pass("Enter the desired product name");
	 * test.pass("Check if the product is listed");
	 * test.pass("Add the product to the cart");
	 * 
	 * ExtentTest test2 = extent.createTest("TC001 - Search product");
	 * test2.pass("navigated to the payment page"); test2.fail("Payment failed");
	 * 
	 * 
	 * 
	 * }
	 */

}
