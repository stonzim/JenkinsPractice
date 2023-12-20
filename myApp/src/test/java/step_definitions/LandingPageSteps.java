package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page_objects.LandingPage;
import utils.TestContextSetup;

public class LandingPageSteps {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        landingPage = this.testContextSetup.pageObjectFactory.getLandingPage();
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
