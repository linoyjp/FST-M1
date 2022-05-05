package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class Activity8 {
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
    public void formsubmit(){

        WebElement linkElement1 = driver.findElement(By.linkText("Contact"));
        linkElement1.click();

        WebElement fullnameField = driver.findElement(By.id("wpforms-8-field_0"));
        WebElement emailField = driver.findElement(By.id("wpforms-8-field_1"));
        WebElement subjectField = driver.findElement(By.id("wpforms-8-field_3"));
        WebElement commentsfield = driver.findElement(By.id("wpforms-8-field_2"));
        //Enter values
        fullnameField.sendKeys("Linoy Paul");
        emailField.sendKeys("linoy_john@in.ibm.com");
        subjectField.sendKeys("project Activity");
        commentsfield.sendKeys("FST batch 36");
        driver.findElement(By.id("wpforms-submit-8")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //WebElement message_display=driver.findElement(By.className("wpforms-confirmation-container wpforms-confirmation-scroll"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpforms-confirmation-8")));
        List<WebElement> message_display = driver.findElements((By.id("wpforms-confirmation-8")));
        System.out.println(message_display.get(0).getText());
        System.out.println("Message_display: " + message_display.get(0).getText());
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
