package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Regression ",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},

        plugin = { "html:target//cucumber-reports.html" }
        // mac için plugin e tek ayrac koy = { "html:target/cucumber-reports.html" }
)

public class _06_TestRunnerRegressionWithPlugin extends AbstractTestNGCucumberTests {
}
