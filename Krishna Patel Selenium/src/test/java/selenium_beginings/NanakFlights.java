package selenium_beginings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NanakFlights {

	public static WebDriver driver;
	
	public static String expectedyear = "2023";
	
	public static String expectedmonth = "March";
	
	public static String expectedday = "15";
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://www.nanakflights.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.id("DepDate")).click();
		
while(true)
{
	String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	if(year.equals(expectedyear))
	{
		break;
	}
	else
	{
		WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		next.click();
	}
}

while(true)
{
	String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	if(month.equals(expectedmonth))
	{
		break;
	}
	else
	{
		WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
		next.click();
	}
}

    List<WebElement> day = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr/td"));
    
    for(WebElement ele: day)
    {
    	String actualday = ele.getText();
    	
    	if(actualday.equals(expectedday))
    	{
    	ele.click();
    	break;
    	}
    }




driver.quit();
		
		
				

	}

}
