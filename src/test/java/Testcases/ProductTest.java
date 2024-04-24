package Testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.Base1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import PageObjects.SearchProducts;

public class ProductTest extends Base1 {
	public WebDriver driver;
	
	@Test
	
	public void AddProduct() throws IOException, Exception
	{	
		 driver = IntializeBrowser();
	        log.debug("Browser initialized");
	
	        LandingPage landingpage = new LandingPage(driver);
	        landingpage.getRegisterElement().click();

	        landingpage.getLogin().click();

	        log.debug("Login button clicked");

	        RegisterPage registerpage = new RegisterPage(driver);
	        registerpage.sendemail().sendKeys(email);
	        registerpage.sendpassword().sendKeys(password);

	        log.debug("Email and password entered");

	        SearchProducts products = new SearchProducts(driver);
	        products.Search().click();
	        products.desktops().click();

	        Thread.sleep(5000);
	        }
	        }
