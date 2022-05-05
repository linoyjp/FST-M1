package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ChromeActivity1 {
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
    public void activity1() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"To-Do List\"))")).click();

        //add task
        String str1="Add tasks to list";
        addTask(str1);
        String str2="Get number of tasks";
        addTask(str2);
        String str3="Clear the list";
        addTask(str3);

        /*
        // Find all text elements on the page
        List<MobileElement> textItems = driver.findElementsByClassName("android.widget.TextView");
        for(MobileElement textItem : textItems) {
            System.out.println(textItem.getText());
        }
        */

        List<MobileElement> uListItems = driver.findElementsByXPath("//android.view.View[2]/android.view.View[2]/android.widget.TextView");
        String s1=uListItems.get(0).getText();
        System.out.println(s1);
        Assert.assertEquals(s1,str1);
        uListItems = driver.findElementsByXPath("//android.view.View[2]/android.view.View[3]/android.widget.TextView");
        String s2=uListItems.get(0).getText();
        System.out.println(s2);
        Assert.assertEquals(s2,str2);
        uListItems = driver.findElementsByXPath("//android.view.View[2]/android.view.View[4]/android.widget.TextView");
        String s3=uListItems.get(0).getText();
        System.out.println(s3);
        Assert.assertEquals(s3,str3);

    }
    public void addTask(String str1){
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("taskInput")));
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")));
        driver.findElementByClassName("android.widget.EditText").sendKeys(str1);
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Add Task\")")).click();
    }
    @AfterClass
    public void inserttask() {
        driver.quit();
    }
}
