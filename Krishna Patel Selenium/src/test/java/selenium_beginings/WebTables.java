package selenium_beginings;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	
	
public static WebDriver driver;


	@Test	
	public static void launch_browser() throws InterruptedException, IOException
	{
//		System.setProperty("webdriver.chrome.driver", "/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Krishna_Selenium/driver/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("https://demo.guru99.com/test/write-xpath-table.html");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		
		WebElement firstrow = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
		
		//table/tbody/tr[2]/td[1]
		
		//div/table/tbody/tr[2]/td[1]
		
		takescreenshot(driver, "launch_browser");
		System.out.println(firstrow.getText());
		
	}
		
	public static void takescreenshot(WebDriver driver, String testcasename) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("/Users/mainakmukherjee/Eclipse/Eclipse Workspace/Krishna_Selenium/Screenshot/" +testcasename+ ".png");
		
		FileUtils.copyFile(src, dest);
		
		
	}
	
	
	
	
	
	
	
	
	
	
//		IMPLICIT WAIT - driver.timeout();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000)); //syntax
		
		
//		Explicit wait - WebDriverWait()
		
//		WebDriverWait expwait = new WebDriverWait(driver, Duration.ofMillis(3000));
		
//		expwait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath(null)));
		
//		Fluent Wait
		
//		Wait<WebDriver> fluwait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(10));
		
		
}
