package Activity;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class Activity_05
{
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	String msg = "Hello Abhishek, This is Appium server automation tool";

	@BeforeTest
	public void setup() throws MalformedURLException 
	{

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel_4_Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.ConversationListActivity");
		caps.setCapability("noreset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void add_cont()
	{
		driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();

		String id_number = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(id_number)));

		driver.findElement(MobileBy.AndroidUIAutomator(id_number)).sendKeys("9425602724");

		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

		//driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/contact_picker_create_group\")")).click();

		String id_text = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";

		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(id_text)));	


		driver.findElement(MobileBy.AndroidUIAutomator(id_text)).sendKeys(msg);

		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Assertion


		List<MobileElement> t=driver.findElements(MobileBy.xpath(".//android.support.v7.widget.RecyclerView/android.widget.FrameLayout"));
		String sentMessageText = t.get(t.size()-1).getAttribute("content-desc");
		System.out.println(sentMessageText);
		assertTrue(sentMessageText.contains(msg));

}

@AfterClass
public void afterClass() {
	driver.quit(); 
}
}
