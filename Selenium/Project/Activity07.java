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



public class Activity07
{
	WebDriver driver;
	WebElement target;
	Actions actions;
	int a = 1, b = 1;

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
	public void checkSales() 
	{
		
		target = driver.findElement(By.xpath(".//span/a[contains(text(),'Sales')]"));
		new Actions(driver).moveToElement(target).perform();
		driver.findElement(By.xpath(".//span/a[contains(text(),'Sales')]/following-sibling::ul/li/a[contains(text(),'Leads')]")).click();

	}
	
	@Test (priority = 3)
	public void Info() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> info = driver.findElements(By.xpath(".//span[contains(@title,\"Additional Details\")]"));
		//System.out.println(info.size());
		for (WebElement webElement : info) {
            webElement.click();

            String path = ".//div[contains(@class,'ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable')][contains(@style,'display: block')]";
            int Path_Present = driver.findElements(By.xpath(path)).size();
            //System.out.println(a++ +"."+ Path_Present + " " + path);

            if (Path_Present>0)
            {
            	String path1 = path + "/div/span[contains(@class,'phone')]";
            	int Path1_Present = driver.findElements(By.xpath(path1)).size();
            	
            	//System.out.println(b++ +"."+ Path1_Present + " " + path1);
            	
            	if(Path1_Present>0)
            	{
            		System.out.println(driver.findElement(By.xpath(path1)).getText());
            		
            	}
            	else
            	{
            		System.out.println("Blank");
            	}
            	String path2 = path + "/div/button";
            	driver.findElement(By.xpath(path2)).click();
            	
            	
            }
            
           // driver.findElement(By.xpath(".//button[contains(@class,'ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close ui-state-hover')]")).click();
            
        }
		
	}


	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
}
