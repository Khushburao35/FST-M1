package Activity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Activity_06 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSearchAppium() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.training-support.net/selenium/lazy-loading");

        String pageTitle = driver.findElementByClassName("android.webkit.WebView").getText();
        System.out.println("Title on Homepage: " + pageTitle);

        List<MobileElement> NoOfImages = driver.findElementsByXPath(".//android.webkit.WebView/android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image: " + NoOfImages.size());
        
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"helen\"))"));
        
        List<MobileElement> NoOfImages2 = driver.findElementsByXPath(".//android.webkit.WebView/android.view.View/android.view.View/android.widget.Image");
        System.out.println("Number of image: " + NoOfImages2.size());
    }
/*
    @AfterTest
    public void tearDown() {
        driver.quit();
    } */
}