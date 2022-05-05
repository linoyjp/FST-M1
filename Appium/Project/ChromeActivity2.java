package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ChromeActivity2 {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void beforeclass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 30);

        // Open page
        driver.get("https://www.training-support.net/selenium");
    }
    @Test
    public void activity2 () {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"Login\"))")).click();
        List<MobileElement> uListItems = driver.findElementsByXPath("//android.widget.EditText[1]");
        uListItems.get(0).sendKeys("admin");
        List<MobileElement> uListItems = driver.findElementsByXPath("//android.widget.EditText[2]");
        uListItems.get(0).sendKeys("password");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Log In\")")).click();


    }
    @AfterClass
    public  void teardown () {
        //driver.quit();
    }
}
