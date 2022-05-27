package selenium_beginings;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Selenium_selectclass {

	public static WebDriver driver;
	
	public static void launch_browser() throws InterruptedException
	{
//		System.setProperty("webdriver.chrome.driver", "/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Krishna_Selenium/driver/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	public static void selectclass() throws InterruptedException
	{
		WebElement country = driver.findElement(By.cssSelector("select[name='country']"));
		
		ArrayList<String> newlist= new ArrayList<String>();
		
		
		
//		Select class use karenge
		
		Select select = new Select(country);
		
		select.selectByIndex(6);
		Thread.sleep(2000);

		
		select.selectByValue("BELGIUM");
		Thread.sleep(2000);
		
		select.selectByVisibleText("NIGERIA");
		Thread.sleep(2000);
		
		System.out.println(select.getFirstSelectedOption().getText());
		
		
		List<WebElement> countryList = select.getOptions();
		
		for(int i=0; i<countryList.size(); i++)
		{
			String country_Value =countryList.get(i).getText();
			
			newlist.add(country_Value);
		}
			
		if(newlist.contains("INDIA"))
		{
			Assert.assertTrue(true, "India is present in the select dropdown options");
		}
		else
		{
			Assert.assertTrue(false, "Indiaa is present in the select dropdown options");
		}

			
		}
		
	
	public static void teardown()
	{
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Selenium_selectclass selenium = new Selenium_selectclass();
		selenium.launch_browser();
		selenium.selectclass();
		selenium.teardown();
}

}


//css= tagname[attribute = 'value']
//xpath= //tagname[@attribute='value']