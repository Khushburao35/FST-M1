package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity02
{
	WebDriver driver;
	String title;


	@BeforeClass
	public void beforeMethod() {
		
		driver = new Browser_And_Login().beforeMethod();
	}

	@Test
	public void Imgurl()
	{
		WebElement img = driver.findElement(By.xpath(".//div[contains(@class,'companylogo')]/img"));
		System.out.println("IMAGE URL : "+ img.getAttribute("src"));
	}
	
		
	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
}
