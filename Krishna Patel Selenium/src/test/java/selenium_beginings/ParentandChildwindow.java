package selenium_beginings;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentandChildwindow {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.goibibo.com/flights/");
		
		WebElement hdfc = driver.findElement(By.xpath("(//p[contains (text(), 'Get up to 25% OFF on Travel Bookings!')])[1]"));
		
		hdfc.click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
//		Parent window - Goibibo
//		Child window - Goibibo to some other page
		
		String parentwindow = it.next();
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		
		System.out.println(driver.findElement(By.xpath("//section/div/table/tbody/tr[2]/td[2]")).getText());
		
		driver.switchTo().window(parentwindow);
		
		System.out.println(hdfc.getText());
		
		
		

	}

}
