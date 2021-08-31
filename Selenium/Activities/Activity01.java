package Activity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity01 {

    public static void main(String[] args) 
    {
    	//Setting system properties of ChromeDriver
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");
	
    	WebDriver driver = new ChromeDriver();
		
	driver.get("https://www.training-support.net");
		
	//Close the browser
	driver.close();
    }

}
