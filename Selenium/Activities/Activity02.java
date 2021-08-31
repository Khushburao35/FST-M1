package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity02 {

    public static void main(String[] args) 
    {
    	//Setting system properties of ChromeDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");
	
    	WebDriver driver = new ChromeDriver();
		
	driver.get("https://www.training-support.net");
		
	//Check the title of the page
    String title = driver.getTitle();
    System.out.println("Page title is: " + title);
    
    //Find the About Us link using id()
    WebElement idLocator = driver.findElement(By.id("about-link"));
    System.out.println("Text in idLocator: " + idLocator.getText());
    
    //Find the About Us link using className()
    WebElement classNameLocator = driver.findElement(By.className("green"));
    System.out.println("Text in classNameLocator: " + classNameLocator.getText());
    
    //Find the About Us link using cssSelector()
    WebElement cssLocator = driver.findElement(By.cssSelector(".green"));
    System.out.println("Text in cssLocator: " + cssLocator.getText());
    
    //Find the About Us link using linkText()
    WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
    System.out.println("Text in linkTextLocator: " + linkTextLocator.getText());
    
    driver.close();
}
}