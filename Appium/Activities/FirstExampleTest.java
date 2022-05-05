package examples;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstExampleTest {
    // Driver declaration
    AndroidDriver<MobileElement> driver;

    //Setup method
    @BeforeClass
    public void setUp () throws MalformedURLException {
        //Desired capabilities
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("deviceId","R58R41WFFWL");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        //Appium server url
        URL serverURL=new URL("http://localhost:4723/wd/hub");

        //Driver initialization
        driver = new AndroidDriver<MobileElement>(serverURL,caps);
    }

    @Test
    public void additionTest () {
        driver.findElementById("calc_keypad_btn_03").click();
        driver.findElementByAccessibilityId("Plus").click();
        driver.findElementById("calc_keypad_btn_06").click();
        driver.findElementByAccessibilityId("Equal").click();

        //Find result and print
        String Result= driver.findElementById("calc_edt_formula").getText();
        System.out.println("Result is "+Result);

        Assert.assertEquals(Result,"9");
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
