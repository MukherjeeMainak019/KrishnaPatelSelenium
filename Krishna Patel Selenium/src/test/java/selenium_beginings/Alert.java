package selenium_beginings;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static WebDriver driver;
	
	@BeforeTest
	public static void launch_browser() throws InterruptedException
	{
//		System.setProperty("webdriver.chrome.driver", "/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Krishna_Selenium/driver/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void alert() throws InterruptedException
	{
		driver.findElement(By.name("cusid")).sendKeys("123");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		String expected = "Do you really want to delete this Customer?";
		String actual = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
//		driver.switchTo().alert().dismiss();
		AssertJUnit.assertEquals(actual, expected); //Hard Asert
	}
	
	
	@AfterTest
	public static void teardown()
	{
		driver.quit();
	}
	
	

}
