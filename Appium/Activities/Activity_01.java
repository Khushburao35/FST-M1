package Activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity_01 {
    @Test
    public void calc() throws InterruptedException, IOException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noreset", true);

        // Instantiate Appium Driver
        AppiumDriver<MobileElement> driver = null;
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("Calculator is open");
            
            driver.findElement(MobileBy.id("digit_3")).click();
            driver.findElement(MobileBy.id("op_mul")).click();
            driver.findElement(MobileBy.id("digit_7")).click();
            driver.findElement(MobileBy.id("eq")).click();
            
          //Display Result
            String result = driver.findElementById("result").getText();
            System.out.println(result);
            //Assert.assertEquals(result, "21");
            
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}