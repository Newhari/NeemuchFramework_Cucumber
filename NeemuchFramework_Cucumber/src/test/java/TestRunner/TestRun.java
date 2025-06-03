package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".//Features/Customers1.feature",
    glue = "StepDefination",
    dryRun = false,
    monochrome = true,
    tags = "@sanity or @regression",
    plugin = {"pretty", "html:target/test-output"}
)
public class TestRun {
}