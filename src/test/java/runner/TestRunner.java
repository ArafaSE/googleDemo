package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps"},
        tags = "@001",
        plugin = {"pretty", "html:target/cucumber-html-report.html"})
public class TestRunner extends TestBase {}

