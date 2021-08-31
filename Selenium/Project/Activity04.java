package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity04
{
	WebDriver driver;
	String title;


	@BeforeClass
	public void beforeMethod() {
		
		driver = new Browser_And_Login().beforeMethod();
	}

	
	@Test (priority = 1)
	public void Login()
	{
		new Browser_And_Login().Login(driver);
	}
	
	@Test (priority = 2)
	public void checkHomePage() 
	{
		
		title = driver.getCurrentUrl();
		Assert.assertTrue(title.contains("Home"));
		
		
		Assert.assertEquals("HOME",driver.findElement(By.id("moduleTab_Home")).getText());
		System.out.println("Page title is: "+title);
		

	}


	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
}
