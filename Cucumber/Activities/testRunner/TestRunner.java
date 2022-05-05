package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        plugin = {"html:reports/report.html"},
        tags = "@Firstest"
)

public class TestRunner {
    //Empty
}
