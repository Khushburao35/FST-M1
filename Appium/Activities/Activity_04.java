package Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity_04
{
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;


	@BeforeTest
	public void setup() throws MalformedURLException 
	{

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel_4_Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", ".activities.PeopleActivity");
		caps.setCapability("noreset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void add_cont()
	{
		driver.findElementByAccessibilityId("Create new contact").click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Contacts']")));
		
		List<MobileElement> a = driver.findElementsByXPath("//android.widget.Button[@text='CANCEL']");
		
		if(a.size()>0)
		{
			driver.findElementByXPath("//android.widget.Button[@text='CANCEL']").click();
		}
		
		//dial_number("999148292");
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Create new contact']").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='First name']")));
		
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Abhishek");
		driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Pune");
		driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("999148292");
		driver.findElementById("editor_menu_save_button").click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

		// Assertion
		MobileElement mobileCard = driver.findElementById("toolbar_parent");
		Assert.assertTrue(mobileCard.isDisplayed());

		String contactName = driver.findElementById("large_title").getText();
		Assert.assertEquals(contactName, "Abhishek Pune");
	}

	@AfterClass
	public void afterClass() {
		driver.quit(); 
	}
}
