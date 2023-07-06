package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@Scenario1",
        plugin = {
                "pretty",
                "html:src/reports/HTML_Report.html"
        },
        publish = true
)
public class TestRunner {


}
