package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import page_objects.LandingPage;
import utils.TestContextSetup;
import java.io.IOException;

public class LandingPageSteps {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        landingPage = this.testContextSetup.pageObjectFactory.getLandingPage();
    }

    @Given("user is on GreenKart landing page")
    public void userIsOnGreenKartLandingPage() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(
                testContextSetup.testBase.WebDriverManager().getCurrentUrl(), landingPage.getURL()
        );
        softAssert.assertAll();
    }

    @When("^user searches with shortname (.+) to extract actual name of product$")
    public void user_searches_with_shortname_to_extract_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchFor(shortName);
        testContextSetup.testVariable = landingPage.getProductName();
    }

    @And("user adds {int} items to the cart")
    public void userAddsItemsToTheCart(int numOfItems) {

    }

    @And("user navigates to the checkout page")
    public void userNavigatesToTheCheckoutPage() {
    }
}
