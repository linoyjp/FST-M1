package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;


public class Activity9 {
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
        public void learncourse(){


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

                WebElement linkElement2 = driver.findElement(By.linkText("All Courses"));
                linkElement2.click();


                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='entry-title']")));
                List<WebElement> courses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
                //System.out.println("Number of courses on the page: "+courses.size());
                System.out.println(courses.get(0).getText());
                List<WebElement> course = driver.findElements(By.xpath("//img[@class='attachment-course-thumb size-course-thumb wp-post-image']"));
                course.get(0).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ld-item-title']")));
                List<WebElement> topic1 = driver.findElements(By.xpath("//div[@class='ld-item-title']"));
                System.out.println(topic1.get(0).getText());
                topic1.get(0).click();
                String title = driver.getTitle();
                System.out.println("Title is: " + title);
                Assert.assertEquals("Developing Strategy – Alchemy LMS", title);

                //check status
                List<WebElement> topic2 = driver.findElements(By.xpath("//div[@class='ld-status ld-status-complete ld-secondary-background']"));
                System.out.println(topic2.get(0).getText());

                if (topic2.get(0).getText().equals("COMPLETE")){
                        System.out.println("Course completed already");
                }
                else {
                        // need to add steps (currently webpage has it as already completed)
                        System.out.println("Marked course complete");
                }

        }
        @AfterClass
        public void teardown(){
                driver.close();
        }
        }
