package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);

        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void getheading1() {

        WebElement heading1=driver.findElement(By.className("uagb-ifb-title"));
        System.out.println(heading1.getText());
        Assert.assertEquals("Learn from Industry Experts", heading1.getText());
        driver.close();
    }
}
