package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	 private WebElement Register;
	
	public WebElement getRegisterElement()
	{
				
		return Register;
	}
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement Login;
	public WebElement getLogin()
	{
		return Login;
	}
	
	

	

}
