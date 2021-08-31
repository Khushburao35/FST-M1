package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity06_2 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/selenium/ajax");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		WebElement button = driver.findElement(By.xpath(".//button[contains(text(),'Change Content')]"));
		Thread.sleep(3000);
		button.click();
		
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));
		
		WebElement DynamicText = driver.findElement(By.id("ajax-content"));
		System.out.println("\n Ajax Dynamic Content :\n"+DynamicText.getText());
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
		System.out.println("\n Ajax Dynamic Content2 :\n"+ DynamicText.getText());
		
		//Close the browser
		driver.close();
	}
}