package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class AddProduct
{
public WebDriver driver;
	public AddProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Desktops']")
	private WebElement breadcrumb;

	public WebElement getbreadcrumb()
	{
	
		if(breadcrumb.getText().equalsIgnoreCase("Desktops")) {
			Assert.assertTrue(true);
		}
		else {
			System.out.println("the page is not loaded ");
		}
		return breadcrumb;
	}
	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'HP LP3065')]")
	private WebElement laptop;
	
	
public WebElement getlaptop() {
	return laptop;
}


}
