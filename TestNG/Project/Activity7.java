package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Activity7 {
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
    public void navtocourses(){

        WebElement linkElement1 = driver.findElement(By.linkText("All Courses"));
        //WebElement partialElement = driver.findElement(By.partialLinkText("Account"));
        linkElement1.click();

        //Click login
        //driver.findElement(By.className("ld-icon ld-icon-login ld-icon-left")).click();
        //driver.findElement(By.xpath("//button[text()='Login']")).click();
        //driver.findElement(By.linkText("Login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='entry-title']")));
        List<WebElement> headings = driver.findElements(By.xpath("//h3[@class='entry-title']"));
        System.out.println("Number of courses on the page: "+headings.size());

    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
