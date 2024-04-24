package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyExtentReports {
	static ExtentReports report;
	public static  ExtentReports extent()
	{
		String reportpath = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportpath);
	       reporter.config().setReportName("omayo report name");  
	       reporter.config().setDocumentTitle("omayo title");
	       report = new ExtentReports();
	       report.attachReporter(reporter);
	       report.setSystemInfo("Operating system","Windows");
	       report.setSystemInfo("user","vijaya lakshmi");   
	       return report;
	}
}
