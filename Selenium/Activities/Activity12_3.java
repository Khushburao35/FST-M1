package Activity;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12_3 {

	public static void main(String[] args) throws InterruptedException, UnsupportedFlavorException, IOException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);

		driver.get("https://www.training-support.net/selenium/popups");
		System.out.println("Page tilte : " + driver.getTitle());
		
		WebElement button = driver.findElement(By.xpath(".//button[contains(text(),'Sign In')]"));
		builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
        String tooltipText = button.getAttribute("data-tooltip");
        System.out.println("Tooltip text: " + tooltipText);
        
        button.click();
        
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        System.out.println(driver.findElement(By.id("action-confirmation")).getText());
		
		driver.close();
    }
}