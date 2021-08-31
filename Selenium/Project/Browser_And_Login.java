package Activity;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_And_Login 
{
	
	public WebDriver beforeMethod() {
		
		String currentdir = System.getProperty("user.dir");
		String dir = new File(currentdir).getParent();
		System.setProperty("webdriver.chrome.driver", dir+"\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://alchemy.hguy.co/crm");
		System.out.println("Test Started");
		return driver;
	}
	
	public void Login(WebDriver driver)
	{
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
	}
	
}
