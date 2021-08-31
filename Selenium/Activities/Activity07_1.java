package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity07_1 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.training-support.net/selenium/dynamic-attributes");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		driver.findElement(By.xpath("//input[starts-with(@class, 'username')]")).sendKeys("admin");
		driver.findElement(By.xpath(".//input[contains(@class, 'password')]")).sendKeys("password");
		driver.findElement(By.xpath(".//button[contains(text(),'Log in')]")).click();
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"), "Welcome Back, admin"));
		
		WebElement DynamicText = driver.findElement(By.id("action-confirmation"));
		System.out.println("\n Ajax Dynamic Content :\n"+DynamicText.getText());
		
		//Close the browser
		driver.close();
	}
}