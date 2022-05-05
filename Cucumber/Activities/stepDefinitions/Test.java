package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.time.Duration;


public class Test extends BaseClass {
    @Given("^user is on TS homepage$")
    public void openTShomepage(){
        driver.get("https://www.training-support.net/");
    }
    @When("^user clicks on the About us button$")
    public void clickaboutusbutton () {
        driver.findElement(By.id("about-link")).click();
    }
    @Then("^user is taken into About us page$")
        public void aboutUsPageVerification () {
            String AboutUsPageTitle = driver.findElement(By.xpath("//h1[@class='ui header']")).getText();
            Assert.assertEquals("About Us", AboutUsPageTitle);
        }
    @And("^close the browser$")
        public void closeBrowser(){
            driver.close();
        }

}
