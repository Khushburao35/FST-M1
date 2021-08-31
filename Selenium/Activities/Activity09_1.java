package Activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity09_1 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.training-support.net/selenium/selects");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		WebElement chosen = driver.findElement(By.id("single-value"));
		
		
		WebElement dropDown = driver.findElement(By.id("single-select"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("Option 2");
		System.out.println(chosen.getText());

		//Select third option by index
		select.selectByIndex(3);
		System.out.println(chosen.getText());

		//Select fourth option by value
		select.selectByValue("4");
		System.out.println(chosen.getText());

		//Get all options
		List<WebElement> options = select.getOptions();
		//Print them
		for(WebElement option : options) {
			
			System.out.println("Option: " + option.getText());
		}



		//Close the browser
		driver.close();
	}
}