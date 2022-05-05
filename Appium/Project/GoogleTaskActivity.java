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

public class GoogleTaskActivity {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void addTasksActivity() {

        //insert 1st task
        clickaddbutton();
        String str1="Complete Activity with Google Tasks";
        inserttask(str1);

        //insert 2nd task
        clickaddbutton();
        String str2="Complete Activity with Google Keep";
        inserttask(str2);

        //insert 3rd task
        clickaddbutton();
        String str3="Complete the second Activity Google Keep";
        inserttask(str3);

        //asert all tasks
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));
        List<MobileElement> results =driver.findElementsById("task_name");
        String s1=results.get(0).getText();
        System.out.println(s1);
        String s2=results.get(1).getText();
        System.out.println(s2);
        String s3=results.get(2).getText();
        System.out.println(s3);
        Assert.assertEquals(s1,str3);
        Assert.assertEquals(s2,str2);
        Assert.assertEquals(s3,str1);
    }
    public void clickaddbutton(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        driver.findElementById("tasks_fab").click();
    }
    public void inserttask(String str){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
        //insert  task
        driver.findElementById("add_task_title").sendKeys(str);
        driver.findElementById("add_task_done").click();
    }

    @AfterClass
    public void inserttask() {
        driver.quit();
    }
}
