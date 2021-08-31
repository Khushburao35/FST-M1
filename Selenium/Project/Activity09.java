package Activity;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Activity09
{
	WebDriver driver;
	WebElement target;
	Actions actions;


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
	public void checkSales() throws InterruptedException 
	{

		target = driver.findElement(By.xpath(".//span/a[contains(text(),'Sales')]"));
		new Actions(driver).moveToElement(target).perform();
		driver.findElement(By.xpath(".//span/a[contains(text(),'Sales')]/following-sibling::ul/li/a[contains(text(),'Leads')]")).click();

	}

	@Test (priority = 3)
	public void Info() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement t = driver.findElement(By.xpath(".//table[contains(@class,'list view table-responsive')]/tbody"));
		// count rows with size() method
		List<WebElement> rws = t.findElements(By.tagName("tr"));
		int rws_cnt = rws.size();
		//iterate rows of table
		for (int i = 0;i < rws_cnt ; i++) {
			// count columns with size() method
			List<WebElement> cols = rws.get(i).findElements(By.tagName("td"));
			String c = cols.get(2).getText() + "--->" + cols.get(7).getText();
			System.out.println("\t" + c);
		}
		System.out.print("\n");
	}



	@AfterClass
	public void afterClass() {

		driver.close();
	}
}
