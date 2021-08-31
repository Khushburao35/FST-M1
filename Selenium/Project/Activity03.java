package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity03
{
	WebDriver driver;
	String title;


	@BeforeClass
	public void beforeMethod() {
		
		driver = new Browser_And_Login().beforeMethod();
	}

	@Test
	public void Copyrighttext()
	{
		WebElement img = driver.findElement(By.id("admin_options"));
		System.out.println("Copyright text : "+ img.getText());
	}
	
		
	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
}
