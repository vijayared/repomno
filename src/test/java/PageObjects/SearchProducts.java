package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchProducts 
{
WebDriver driver;
public SearchProducts(WebDriver driver)
{ 
	this.driver=driver;
	PageFactory.initElements(driver,this);	
}

@FindBy(xpath="//a[text()='Desktops']")
private WebElement search;

public WebElement Search()
{
	return search;
}

@FindBy(xpath="//a[text()='Show AllDesktops']")
private WebElement desktops;
public WebElement desktops()
{
	return desktops;
}
}
