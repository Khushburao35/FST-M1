package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity03 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/selenium/simple-form");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		driver.findElement(By.id("firstName")).sendKeys("Abhishek");

		driver.findElement(By.id("lastName")).sendKeys("Mondal");

		driver.findElement(By.id("email")).sendKeys("test@example.com");

		driver.findElement(By.id("number")).sendKeys("1234567890");

		driver.findElement(By.xpath(".//input[contains(@type,'submit')]")).click();

		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();

		Thread.sleep(3000);
		
		driver.close();
	}
}