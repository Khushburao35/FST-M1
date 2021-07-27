package HrmProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {
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
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
		driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
		driver.findElement(By.id("btnLogin")).click();
		
		String title = driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	@AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
