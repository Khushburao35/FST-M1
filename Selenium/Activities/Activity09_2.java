package Activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity09_2 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.training-support.net/selenium/selects");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		//Chosen option
		WebElement chosen = driver.findElement(By.id("multi-value"));

		//Find multiList
		Select multiList = new Select(driver.findElement(By.id("multi-select")));

		if(multiList.isMultiple()) {

			//Select 'JavaScript' by Visible text
			multiList.selectByVisibleText("Javascript");
			System.out.println(chosen.getText());
			Thread.sleep(5000);
			

			//Select 'NodeJS' by value
			multiList.selectByValue("node");
			System.out.println(chosen.getText());
			Thread.sleep(5000);

			//Select 4,5, and 6 options by index
			for(int i=4; i<=6; i++) {
				multiList.selectByIndex(i);
			}
			System.out.println(chosen.getText());
			Thread.sleep(5000);

			//Deselect 'NodeJS' by value
			multiList.deselectByValue("node");
			System.out.println(chosen.getText());

			//Deselect 7th opttion by index
			multiList.deselectByIndex(7);
			System.out.println(chosen.getText());

			//Get all selected options
			List<WebElement> selectedOptions = multiList.getAllSelectedOptions();
			//Print all selected options
			for(WebElement selectedOption : selectedOptions) {
				System.out.println("Selected option: " + selectedOption.getText());
			}

			//Deselect all options
			multiList.deselectAll();
			System.out.println(chosen.getText());
		}        
		//Close browser
		//driver.close();
		}
}