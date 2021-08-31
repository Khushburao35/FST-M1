package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity04_3 {

	public static void main(String[] args) 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.training-support.net/selenium/target-practice");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		WebElement thirdheader = driver.findElement(By.id("third-header"));
		System.out.println("third-header : "+thirdheader.getText());

		String fiftheader = driver.findElement(By.xpath("//h5")).getCssValue("color");
		System.out.println("third-header : "+fiftheader);
		
		String violetButtonClasses = driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class");
        System.out.println("Violet button's classes are: " + violetButtonClasses);
        
        String greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
        System.out.println("The grey button's text is: " + greyButton);
		
		driver.close();
	}
}