package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_objects.LandingPage;
import utils.TestContextSetup;

public class LandingPageSteps {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        testContextSetup.driver = new ChromeDriver(options);
        landingPage = new LandingPage(this.testContextSetup.driver);
    }

    @Given("user goes to GreenKart landing page")
    public void userGoesToGreenKartLandingPage() {
        landingPage.goToLandingPage();
    }

    @When("user searches with shortname {string} to extract actual name of product")
    public void user_searches_with_shortname_to_extract_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchFor(shortName);
        testContextSetup.testVariable = landingPage.getProductName();
    }
}
