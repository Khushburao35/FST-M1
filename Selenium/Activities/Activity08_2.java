package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity08_2 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/selenium/tables");

		//Check the title of the page
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		String table_name = driver.findElement(By.xpath(".//div[@class='spaced']/div")).getText();
		int tr = driver.findElements(By.xpath(".//div[@class='spaced']//tbody/tr")).size();
		int td = driver.findElements(By.xpath(".//div[@class='spaced']//tbody/tr[1]/td")).size();
		System.out.println("table_name = " + table_name + "    No of row = " + tr + "    No fof col = " + td);
		
		
		String table_name1 = driver.findElement(By.xpath(".//div[@class='extra spaced']/div")).getText();
		int tr1 = driver.findElements(By.xpath(".//div[@class='extra spaced']//tbody/tr")).size();
		int td1 = driver.findElements(By.xpath(".//div[@class='extra spaced']//tbody/tr[1]/td")).size();
		System.out.println("table_name = " + table_name1 + "    No of row = " + tr1 + "    No fof col = " + td1);
		
		String row_3_data = driver.findElement(By.xpath(".//div[@class='extra spaced']//tbody/tr[3]")).getText();
		System.out.println("3rd row data = " + row_3_data);
		
		String row_2_data = driver.findElement(By.xpath(".//div[@class='extra spaced']//tbody/tr[2]/td[2]")).getText();
		System.out.println("2rd row data = " + row_2_data);
		
		driver.findElement(By.xpath(".//div[@class='extra spaced']//th")).click();
		
		String sort_row_3_data = driver.findElement(By.xpath(".//div[@class='extra spaced']//tbody/tr[3]")).getText();
		System.out.println("Sort 3rd row data = " + sort_row_3_data);
		
		String sort_row_2_data = driver.findElement(By.xpath(".//div[@class='extra spaced']//tbody/tr[2]/td[2]")).getText();
		System.out.println("Sort 2rd row data = " + sort_row_2_data);

		
		//Close the browser
		driver.close();
	}
}