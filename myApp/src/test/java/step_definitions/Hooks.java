package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) { this.testContextSetup = testContextSetup; }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot)testContextSetup.testBase.WebDriverManager())
                    .getScreenshotAs(OutputType.FILE);
            byte[] fileContent =  FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }

    @After
    public void tearDown() throws IOException { testContextSetup.testBase.WebDriverManager().quit(); }
}
