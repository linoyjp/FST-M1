import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
/*
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity3"
)
*/

@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        plugin = {"html:reports/report.html"},
        tags = "@activity5",
        plugin = {"pretty"},
        monochrome = true
)

public class ActivitiesRunner {
    //empty
}