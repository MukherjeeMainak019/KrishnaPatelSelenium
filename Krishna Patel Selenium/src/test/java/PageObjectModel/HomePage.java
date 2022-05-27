package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public static WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
	
		this.driver = driver;
	}
	
	By home = By.xpath("//a[contains (text(), 'Home')]");
	By flights = By.xpath("//a[contains (text(), 'Flights')]");
	By from = By.id("OBdep");
	By to = By.id("OBarr");
	By from_value = By.xpath("//ul[@id='ui-id-1']//li//a");
	By to_value = By.xpath("//ul[@id='ui-id-2']//li//a");
	
	
public WebElement home()
	{
	  return driver.findElement(home);
	}
	
	public WebElement flights()
	{
	  return driver.findElement(flights);
	}
	
	public WebElement from()
	{
	  return driver.findElement(from);
	}
	
	public WebElement from_value()
	{
	  return driver.findElement(from_value);
	}
}
