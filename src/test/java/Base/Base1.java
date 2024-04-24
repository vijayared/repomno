package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {
    public WebDriver driver;
    public String url;
    public String email;
    public String password;
    public String browser;
    public Logger log;
    
    
    @BeforeMethod
public void setup() throws IOException, InterruptedException
{ 
    	PropertiesReader propReader = new PropertiesReader();
		propReader.loadProperties();
		browser = propReader.getBrowser();
		url = propReader.getURL();
		email = propReader.getEmail();
		password = propReader.getPassword();
				
				    log = LogManager.getLogger(Base1.class.getName());
				    log.debug("launched the browser");
					log.debug("opened the website");
				    
				    
				if(browser.equalsIgnoreCase("Chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				
				if(browser.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				
				if(browser.equalsIgnoreCase("IE"))
				{
					WebDriverManager.iedriver().setup();
					driver=new InternetExplorerDriver();
				}
}
	public WebDriver IntializeBrowser() throws IOException, InterruptedException
	{	
			 
	driver.get(url);
	Thread.sleep(5000);
	log.debug("opened the website");
	driver.manage().window().fullscreen();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;		
}
	
	@AfterMethod
	 public void teardown()
		{
			driver.quit();
		}
        public String Screenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		return destinationFilePath;
	
	}
	
}
