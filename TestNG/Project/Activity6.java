package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;

import static liveProject.Login.LoginStep;

public class Activity6 {
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
    public void navtologin(){

        String userName=LoginStep();
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "My Account – Alchemy LMS");
        Assert.assertEquals("root", userName);

        /*WebElement linkElement1 = driver.findElement(By.linkText("My Account"));
        linkElement1.click();



        driver.findElement(By.linkText("Login")).click();


        WebElement usernameField = driver.findElement(By.id("user_login"));
        WebElement passwordField = driver.findElement(By.id("user_pass"));

        //Enter values
        usernameField.sendKeys("root");
        passwordField.sendKeys("pa$$w0rd");

        //Click Log in
        driver.findElement(By.id("wp-submit")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement username_display=driver.findElement(By.className("display-name"));
        System.out.println("username_display: " + username_display.getText());
        Assert.assertEquals("root", username_display.getText());

         */
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
