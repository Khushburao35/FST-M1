package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity05_1 {

	public static void main(String[] args) 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.training-support.net/selenium/dynamic-controls");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
		System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());

		driver.findElement(By.id("toggleCheckbox")).click();

		System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());

		driver.close();
	}
}