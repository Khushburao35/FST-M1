package Activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project_03
{
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	boolean found = false;

	@BeforeTest
	public void setup() throws MalformedURLException 
	{

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel_4_Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noreset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void add_task()
	{

		System.out.println("Note is open to add reminder to existing note");

		Sendtext("Complete Activity with Google Tasks");

		Sendtext("Complete Activity with Google Keep");

		Sendtext("Complete the second Activity Google Keep");

	}


	private void Sendtext(String msg) 
	{

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/index_note_title")));

		List<MobileElement> t=driver.findElements(MobileBy.id("com.google.android.keep:id/index_note_title"));
		
		for(MobileElement a : t)
		{
			
			if(a.getText().contains(msg))
			{
				System.out.println("Adding reminder to existing: "+a.getText());
				a.click();
				adding_reminder_to_note();	
				found = true;
			}
						
		}
		
		if (!found)
		{
			System.out.println("New note adding then reminder");
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
			driver.findElement(MobileBy.AccessibilityId("New text note")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/editable_title")));
			driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title")).sendKeys("Title : "+ msg);
			driver.findElement(MobileBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Note : "+ msg);
			adding_reminder_to_note();	
		}

	}

	private void adding_reminder_to_note()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Single-column view")));
		driver.findElement(MobileBy.AccessibilityId("Single-column view")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/menu_text")));
		driver.findElement(MobileBy.xpath(".//android.view.ViewGroup[1]/android.widget.TextView[1]")).click();
		String remind_text = driver.findElement(MobileBy.id("com.google.android.keep:id/reminder_chip")).getAttribute("content-desc");
		System.out.println(remind_text);
		Assert.assertTrue(remind_text.contains("Time reminder"));
		driver.findElement(MobileBy.AccessibilityId("Open navigation drawer")).click();
		
	}

	@AfterClass(enabled = false)
	public void afterClass() {
		driver.quit(); 
	}
}
