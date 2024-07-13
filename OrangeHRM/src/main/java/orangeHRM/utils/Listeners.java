package orangeHRM.utils;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class Listeners implements ITestListener{
	

	 protected static ExtentReports reports;
	 protected static ExtentTest test;
	 
	

	 public void onTestStart(ITestResult result) {
		 System.out.println("Test Started : " + result.getName());
		 
		 }

	 
	 
	}
	


