package HrmProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UrlImage {
	
	WebDriver driver;
	@BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        // driver = new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\KhushbuKumari\\eclipse-workspace\\TestNGProject\\drivers\\chromedriver.exe");
    	driver = new ChromeDriver();
        
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
	}
	
	@Test
	public void ImageUrl() {
		WebElement imageUrl=driver.findElement(By.xpath("//image[@overflow='visible']"));
		System.out.println("Src attribute is: "+ imageUrl.getAttribute("src"));
	}
	@AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
