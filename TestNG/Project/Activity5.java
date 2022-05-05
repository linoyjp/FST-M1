package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void navtoaccount(){

        WebElement linkElement = driver.findElement(By.linkText("My Account"));
        //WebElement partialElement = driver.findElement(By.partialLinkText("Account"));
        linkElement.click();

        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "My Account – Alchemy LMS");

    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
