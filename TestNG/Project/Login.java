package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Login {
    public static String LoginStep(){
        WebDriver driver= new FirefoxDriver();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account")));
        WebElement linkElement1 = driver.findElement(By.linkText("My Account"));
        linkElement1.click();

        driver.findElement(By.linkText("Login")).click();


        WebElement usernameField = driver.findElement(By.id("user_login"));
        WebElement passwordField = driver.findElement(By.id("user_pass"));

        //Enter values
        usernameField.sendKeys("root");
        passwordField.sendKeys("pa$$w0rd");

        //Click Log in
        driver.findElement(By.id("wp-submit")).click();

        String username_display=driver.findElement(By.className("display-name")).getText();
        return username_display;
    }
}
