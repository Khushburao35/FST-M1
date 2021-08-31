package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity06
{
	WebDriver driver;
	WebElement title;


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
	public void checkActivity() 
	{
		
		title = driver.findElement(By.xpath(".//span/a[contains(text(),'Activities')]"));
		Assert.assertTrue(title.isDisplayed());
		System.out.println("Acitivty is diplayed : "+ title.isDisplayed()); 
		Assert.assertTrue(title.isEnabled());
		System.out.println("Acitivty is Enabled : "+ title.isEnabled()); 	

	}


	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
}
