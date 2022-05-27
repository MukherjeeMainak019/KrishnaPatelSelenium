package selenium_beginings;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Radiobutton {

	
	public static WebDriver driver;
	
	public static void launch_browser() throws InterruptedException
	{
//		System.setProperty("webdriver.chrome.driver", "/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Krishna_Selenium/driver/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://www.nanakflights.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	
	public static void  radiobutton() throws InterruptedException
	{
		List<WebElement> radioList = driver.findElements(By.id("optionsrow"));
		
		WebElement radio_return = driver.findElement(By.id("rreturn"));
		WebElement radio_oneway = driver.findElement(By.id("roneway"));
		WebElement radio_multicity = driver.findElement(By.id("rmulticity"));
		
		ArrayList<String> newlist= new ArrayList<String>();
		
		for(int i=0; i<radioList.size(); i++)
		{
			String value = radioList.get(i).getText();
			
			newlist.add(value);
		}
			
			
			if(newlist.contains("Return One Way Multicity"))
			{
				radio_multicity.click();
				
				Thread.sleep(3000);
				
			}
			
		}
		
		
	
	
	
	
	
	public static void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {

		Checkbox_Radiobutton obj = new Checkbox_Radiobutton();
		obj.launch_browser();
		obj.radiobutton();
//		obj.teardown();
	}

}
