package cucumber_options;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions",
        monochrome = true,
        plugin = {"pretty",
                "html: target/cucumber.html",
                "json: target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
