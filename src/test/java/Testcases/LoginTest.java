package Testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base1;
import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import junit.framework.Assert;

public class LoginTest extends Base1 {
	
	public WebDriver driver;
	
	
	@Test(dataProvider="Data")
	
	public void Login(String email,String password,String status) throws IOException, InterruptedException 
	{
	driver=IntializeBrowser();
	LandingPage landingpage=new LandingPage(driver);
	landingpage.getRegisterElement().click();
	log.debug("clicked on my account dropdown");
	landingpage.getLogin().click();
	
	
	RegisterPage register=new RegisterPage(driver);
	register.sendemail().sendKeys(email);
	log.debug("email got entered");
	register.sendpassword().sendKeys(password);
	log.debug("password got printed");
	register.login().click();
	//register.sendemail().sendKeys(properties.getProperty("email"));
	//register.sendpassword().sendKeys(properties.getProperty("password"));
	
	
	AccountPage accountpage=new AccountPage(driver);
	String actualresult = null;
	try {
		
		if(accountpage.breadcrumb1().isDisplayed()) {
	 
	 actualresult="success";
	 log.info("login test got passed");
		}
	}
	catch(Exception e){
		 actualresult="failure";
		 log.error("login test got failed");
	}
	Assert.assertEquals(actualresult,status);
	
	}
	
	
	 @AfterMethod
	 public void teardown()
	 {
	 	//driver.quit();
	 }
	
	@DataProvider
	public Object[] [] Data()
	{
		Object[] []data= {{"vlakshmi123@gmail.com","12345","success"}};
		return data;
	}

}
