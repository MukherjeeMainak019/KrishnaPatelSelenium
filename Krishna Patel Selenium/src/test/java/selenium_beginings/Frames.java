package selenium_beginings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement frames = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
		
		driver.switchTo().frame(frames);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(drag).dragAndDrop(drag, drop).build().perform();
		
		driver.switchTo().defaultContent(); // to move out of a frame
		
		
		

	}

}
