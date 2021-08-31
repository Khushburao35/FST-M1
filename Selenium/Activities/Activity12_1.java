package Activity;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity12_1 {

	public static void main(String[] args) throws InterruptedException, UnsupportedFlavorException, IOException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.training-support.net/selenium/iframes");
		System.out.println("Page tilte : " + driver.getTitle());
		
		driver.switchTo().frame(0);
		System.out.println("Frame tilte : " + driver.findElement(By.tagName("title")).getAttribute("innerHTML"));
		WebElement a = driver.findElement(By.id("actionButton"));
		a.click();
		System.out.println("Button text : " + a.getText() + "    Button color : " + a.getCssValue("color") );
		
		
		driver.switchTo().parentFrame();
		
		
		driver.switchTo().frame(1);
		System.out.println("Frame tilte : " + driver.findElement(By.tagName("title")).getAttribute("innerHTML"));
		WebElement b = driver.findElement(By.id("actionButton"));
		b.click();
		System.out.println("Button text : " + b.getText() + "    Button color : " + b.getCssValue("color") ); 
        
		
		
		driver.close();
    }
}