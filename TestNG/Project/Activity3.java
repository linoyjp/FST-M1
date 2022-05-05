package liveProject;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.util.List;

public class Activity3 {

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
    public void getheading2() {

        //WebElement heading1=driver.findElement(By.className("uagb-ifb-title"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='uagb-ifb-title']")));
        List<WebElement> headings = driver.findElements(By.xpath("//h3[@class='uagb-ifb-title']"));
        System.out.println(headings.get(0).getText());
        Assert.assertEquals("Actionable Training", headings.get(0).getText());
        driver.close();
    }
}
