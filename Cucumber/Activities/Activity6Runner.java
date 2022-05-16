package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = {"stepDefinition"},
        tags = "@SmokeTest",
        plugin = {"html: test-reports"},
        monochrome = true
)
public class Activity6Runner {
}
