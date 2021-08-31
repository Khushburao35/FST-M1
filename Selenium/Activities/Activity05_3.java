package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity05_3 {

	public static void main(String[] args) 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/selenium/dynamic-controls");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));

		System.out.println("The checkbox is selected: " + textInput.isEnabled());

		driver.findElement(By.id("toggleInput")).click();

		System.out.println("The checkbox is selected: " + textInput.isEnabled());

		//Close the browser
		driver.close();
	}
}