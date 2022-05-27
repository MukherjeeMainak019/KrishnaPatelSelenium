package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunnerClass {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://www.nanakflights.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
//		HomePage Object creation
		
		HomePage homepage = new HomePage(driver);
		homepage.from().click();
		homepage.from().sendKeys("DEL");
		homepage.from_value().click();
		
		
		FlightPage flightpage = new FlightPage(driver);
		PageFactory.initElements(driver, flightpage); // for @FindBy this line to be included for passing the driver knowledge to the Flight page
		
		
		homepage.flights().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		flightpage.free_flight_qoute.click();

	}

}
