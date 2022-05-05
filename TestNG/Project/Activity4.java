package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Activity4 {
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
    public void getheading3(){

        //WebElement heading3 = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div/div[2]/div/div/div/div[2]/article/div[2]/h3"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='entry-title']")));
        List<WebElement> headings = driver.findElements(By.xpath("//h3[@class='entry-title']"));
        System.out.println(headings.get(1).getText());
        Assert.assertEquals("Email Marketing Strategies", headings.get(1).getText());

    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
}
