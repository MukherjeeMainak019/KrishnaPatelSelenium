package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightPage {
	
public static WebDriver driver;
	
	public FlightPage(WebDriver driver) {
	
		this.driver = driver;
	}

//	FindBy annotations for PageObjectModel
//	FindBy annotation is used for Page Factory
	
	
	@FindBy (xpath="//span[contains(text(), 'REQUEST A FREE FLIGHT QUOTE')]")
	WebElement free_flight_qoute;
	
	
	
}