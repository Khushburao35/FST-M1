package Activity;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity01
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
	public void gettitle() 
	{
		
		title = driver.getTitle();
		System.out.println("Page title is: "+title);
		

	}


	@AfterClass
	public void afterClass() {
		
		if(title.equals("SuiteCRM"))
		{
		driver.close();
		}
		else
			System.out.println("Title is not “SuiteCRM”");
	}
}
