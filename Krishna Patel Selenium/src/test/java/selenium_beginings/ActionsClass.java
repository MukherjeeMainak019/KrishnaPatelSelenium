package selenium_beginings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		WebElement Signin = driver.findElement(By.id("nav-link-accountList"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(Signin).build().perform();
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		
		actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		WebElement orders = driver.findElement(By.id("nav-orders"));
		
		actions.moveToElement(orders).contextClick(orders).build().perform();
	}

}
