package Activity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity06_1 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/selenium/dynamic-controls");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		WebElement textInput = driver.findElement(By.id("toggleCheckbox"));
		WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
		
		Thread.sleep(3000);
		
		textInput.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("The checkbox is Display: " + checkboxInput.isDisplayed());
		
		Thread.sleep(3000);
		
		textInput.click();
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
		System.out.println("The checkbox is Display: " + checkboxInput.isDisplayed());
		
		Thread.sleep(3000);
		
		System.out.println("The checkbox is selected: " + checkboxInput.isSelected());
		checkboxInput.click();
		System.out.println("The checkbox is selected: " + checkboxInput.isSelected());
		
		//Close the browser
		driver.close();
	}
}