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

public class GoogleKeepActivity {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void addKeepActivity() {
        // find add button and click
        clickaddbutton();
        //add title & description
        addtitleandDescription();
        // assert
        validatetask();

    }
    public void clickaddbutton(){
        driver.findElementById("new_note_button").click();
    }
    public void addtitleandDescription(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
        driver.findElementById("editable_title").sendKeys("Android Project using APPIUM");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
        driver.findElementById("edit_note_text").sendKeys("Live project on handling & automating android apps");

        driver.findElementByClassName("android.widget.ImageButton").click();
    }
    public void validatetask(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("index_note_text_description")));

        String Result=driver.findElementById("index_note_text_description").getText();
        Boolean flag1=false;
        if (Result.length()>0){
            flag1=true;
        }
        Assert.assertEquals(flag1,true);

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
