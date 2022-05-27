package selenium_beginings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_dropdwons {

public static WebDriver driver;
	
	public static void launch_browser() throws InterruptedException
	{
//		System.setProperty("webdriver.chrome.driver", "/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Krishna_Selenium/driver/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	public static void dynamic_dropdown() throws InterruptedException
	{
		WebElement one_way_from = driver.findElement(By.xpath("//span[contains (text(), 'From')]"));
		
		one_way_from.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder = 'From']")).sendKeys("CAN");
		
		//ul[@role = 'listbox']//li // parent child relationship
		
		//li[@role='option']
		
		List <WebElement> list_from = driver.findElements(By.xpath("//ul[@role = 'listbox']//li "));
		
//		WebElement list_from_value = driver.findElement(By.xpath("//ul[@role = 'listbox']//li "));
		
		for(WebElement ele:list_from)
		{
			String value = ele.getText();
			
			if(value.contains("Mexico"))
			{
				ele.click();
				break;
			}
			
		}
		
		driver.findElement(By.xpath("//input[@placeholder = 'To']")).sendKeys("AME");
		
		List <WebElement> list_to = driver.findElements(By.xpath("//ul[@role = 'listbox']//li "));
		
		for(WebElement ele:list_to)
		{
			String value = ele.getText();
			
			if(value.contains("Amsterdam"))
			{
				ele.click();
				break;
			}
			
		}
		
		
		
		
	}
	
	
	
	
	public static void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Dynamic_dropdwons dynamic_dropdwons = new Dynamic_dropdwons();
		dynamic_dropdwons.launch_browser();
		dynamic_dropdwons.dynamic_dropdown();
		dynamic_dropdwons.teardown();

	}

}
