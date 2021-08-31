package Activity;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) throws InterruptedException, UnsupportedFlavorException, IOException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);

		driver.get("https://www.training-support.net/selenium/input-events");
		System.out.println("Page title : " + driver.getTitle());
		
		WebElement cube = driver.findElement(By.id("keyPressed"));
		
		//Send name first letter
		actions.sendKeys("A").build().perform();
		System.out.println("First Name Char: " + cube.getText());

		//Ctrl A Ctrl V
		actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build().perform();
        
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String result = (String) clipboard.getData(DataFlavor.stringFlavor);
		System.out.println("String from Clipboard:" + result);

		driver.close();
	}
}