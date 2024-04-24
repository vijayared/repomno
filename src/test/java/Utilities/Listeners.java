package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.Base1;

public class Listeners extends Base1 implements ITestListener {

	
	ExtentReports extentreport=MyExtentReports.extent();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		String testName=result.getName();
	extentTest = extentreport.createTest(testName);
	extentTestThread.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		extentTestThread.get().log(Status.PASS,"passed the testcase");
	}

	public void onTestFailure(ITestResult result) {
		
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		String testname=result.getName();
		WebDriver driver = null ;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e) { 
			e.printStackTrace();
		}
		

		try {
			String destinationFilePath=Screenshot(testname,driver);
			extentTestThread.get().addScreenCaptureFromPath(destinationFilePath,testname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		
		extentreport.flush();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
