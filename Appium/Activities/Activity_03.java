package Activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity_03 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;


	@BeforeTest
	public void setup() throws MalformedURLException 
	{

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel_4_Emulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		caps.setCapability("noreset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void addition()
	{
		driver.findElement(MobileBy.id("digit_5")).click();
		driver.findElement(MobileBy.id("op_add")).click();
		driver.findElement(MobileBy.id("digit_9")).click();
		driver.findElement(MobileBy.id("eq")).click();
		
		String result = driver.findElementById("result").getText();
        System.out.println("Result add= " + result);
        Assert.assertEquals(result, "14");
	}
	
	@Test
	public void subtract()
	{
		driver.findElement(MobileBy.id("digit_1")).click();
		driver.findElement(MobileBy.id("digit_0")).click();
		driver.findElement(MobileBy.id("op_sub")).click();
		driver.findElement(MobileBy.id("digit_5")).click();
		driver.findElement(MobileBy.id("eq")).click();
		
		String result = driver.findElementById("result").getText();
        System.out.println("Result subtract= " + result);
        Assert.assertEquals(result, "5");
	}
	
	@Test
	public void multiply()
	{
		driver.findElement(MobileBy.id("digit_5")).click();
		driver.findElement(MobileBy.id("op_mul")).click();
		driver.findElement(MobileBy.id("digit_1")).click();
		driver.findElement(MobileBy.id("digit_0")).click();
		driver.findElement(MobileBy.id("digit_0")).click();
		driver.findElement(MobileBy.id("eq")).click();
		
		String result = driver.findElementById("result").getText();
        System.out.println("Result multiply= " + result);
        Assert.assertEquals(result, "500");
        
	}
	
	@Test
	public void divide()
	{
		driver.findElement(MobileBy.id("digit_5")).click();
		driver.findElement(MobileBy.id("digit_0")).click();
		driver.findElement(MobileBy.id("op_div")).click();
		driver.findElement(MobileBy.id("digit_2")).click();
		driver.findElement(MobileBy.id("eq")).click();
		
		String result = driver.findElementById("result").getText();
        System.out.println("Result divide= " + result);
        Assert.assertEquals(result, "25");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
