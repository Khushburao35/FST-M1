package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Login page$")
	public void userIsOnGooglePage() throws Throwable {
		//Create a new instance of the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);

		//Open the browser
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@When("^User enters username and password$")
	public void logindetails()
	{
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath(".//button[contains(text(),'Log in')]")).click();

	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^Read the page title and confirmation message$")
	public void Confirmationlogin()
	{
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
		System.out.println("Title : "+driver.getTitle());
		String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Text : "+confirmMessage);
	}

	@And("^Close the browser$")
	public void closeTheBrowser() throws Throwable {
		driver.close();
	}

}
