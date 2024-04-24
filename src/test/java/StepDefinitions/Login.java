package StepDefinitions;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import Base.Base1;
public class Login extends Base1 {
	public WebDriver driver;
	LandingPage landingPage;
    RegisterPage registerPage;
	AccountPage accountPage;
	
	@Given("^Open any Browser$")
    public void open_any_browser() throws IOException, InterruptedException  {
		
		driver = IntializeBrowser();
        log.debug("Browser initialized");
        
    }
	
	 @And("^Navigate to Login page$")
	 public void navigate_to_login_page() throws InterruptedException  {
		 
		 driver.get(url);
		 LandingPage landingpage = new LandingPage(driver);
	        landingpage.getRegisterElement().click();

	        landingpage.getLogin().click();

	        log.debug("Login button clicked");
	       
	 }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email, String password)  {
    	
    	RegisterPage registerpage = new RegisterPage(driver);
        registerpage.sendemail().sendKeys(email);
        registerpage.sendpassword().sendKeys(password);

        log.debug("Email and password entered");
        
    }

    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button()  {
       
    	   registerPage.login().click();
    	
    }
    
    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
    	
    	accountPage = new AccountPage(driver);
    	Assert.assertTrue(accountPage.breadcrumb1().isDisplayed());
    	
    }
    
    @After
    public void closure() {
    	
    	driver.close();
    	
    }

}
