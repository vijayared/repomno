package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
WebDriver driver;
public RegisterPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(id="input-email")
private WebElement email;

public WebElement sendemail()
{
	return email;
}

@FindBy(id="input-password")
private WebElement password;

public WebElement sendpassword()
{
	return password;
}
@FindBy(xpath="//input[@class='btn btn-primary']")
private WebElement login;
public WebElement login()
{
	return login;
}


}
