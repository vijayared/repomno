package Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base1;
import PageObjects.AddProduct;
import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import PageObjects.SearchProducts;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class FailedTest extends Base1 {

	public WebDriver driver;
	@Test


		public void addproducts() throws IOException, InterruptedException
		{
			driver=IntializeBrowser();
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
		        AddProduct add=new AddProduct(driver);
		        add.getbreadcrumb();
		        Thread.sleep(5000);
		        add.getlaptop().click();
		        Assert.assertTrue(false);
		      System.out.println("new branch is created");
		       
		    
		        
		}
	}
