package Activity;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity11_2 {

	public static void main(String[] args) throws InterruptedException, UnsupportedFlavorException, IOException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		System.out.println("Page title : " + driver.getTitle());
		
		driver.findElement(By.cssSelector("button#confirm")).click();
		Alert Alert = driver.switchTo().alert();
		String alertText = Alert.getText();
        System.out.println("Alert text is: " + alertText);
        Alert.accept();

        driver.findElement(By.cssSelector("button#confirm")).click();
        Alert Alert2 = driver.switchTo().alert();
		String alertText2 = Alert2.getText();
        System.out.println("Alert text is: " + alertText2);
        Alert.dismiss();
        
		driver.close();
	}
}