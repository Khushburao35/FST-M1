package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity05
{
	WebDriver driver;

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
	public void checkcolor() 
	{
		
		String rgb = driver.findElement(By.id("toolbar")).getCssValue("color");
		System.out.println("Menu Color is: "+rgb);
		

	}


	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
}
