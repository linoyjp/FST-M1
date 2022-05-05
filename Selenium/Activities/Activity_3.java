package activities;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {
    public static void main(String[] args) {
        //Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //And now use this to visit the website
        driver.get("https://training-support.net/selenium/simple-form");

        //Check the title of the page
        String title = driver.getTitle();
        //Print the title of the page
        System.out.println("Page title is: " + title);

        WebElement firstname = driver.findElement(By.id("firstName"));
        WebElement lastname = driver.findElement(By.id("lastName"));

        firstname.sendKeys("Linoy");
        lastname.sendKeys("Paul");

        //Enter the email
        driver.findElement(By.id("email")).sendKeys("linoyjp@gmail.com");

        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("1234567890");

        //Click Submit
        driver.findElement(By.cssSelector(".ui.green.button")).click();

        //Close the browser
        driver.close();
    }
}
