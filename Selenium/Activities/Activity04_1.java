package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity04_1 {

	public static void main(String[] args) 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.training-support.net");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		driver.findElement(By.id("about-link")).click();
				
		String title1 = driver.getTitle();
		System.out.println("New Page title is: " + title1);

		driver.close();
	}
}