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
    SoftAssert softAssert = new SoftAssert();

    public LandingPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        landingPage = this.testContextSetup.pageObjectFactory.getLandingPage();
    }

    @Given("user is on GreenKart landing page")
    public void userIsOnGreenKartLandingPage() throws IOException {
        softAssert.assertEquals(
                testContextSetup.testBase.WebDriverManager().getCurrentUrl(), landingPage.getURL()
        );
        softAssert.assertAll();
    }

    @When("^user searches with shortname (.+) to extract actual name of product$")
    public void user_searches_with_shortname_to_extract_actual_name_of_product(String shortName) throws InterruptedException {
        landingPage.searchFor(shortName);
        testContextSetup.testStringVariable = landingPage.getProductName();
    }

    @And("user uses the plus button to add {int} items to cart")
    public void userUsesThePlusButtonToAddItemsToCart(int numOfItems) throws InterruptedException {
        testContextSetup.testIntVariable = numOfItems;
        for(int i = 1; i < numOfItems; i++) {
            landingPage.clickAddItemAmount();
            Thread.sleep(200);
        }
        landingPage.clickAddToCart();
    }

    @And("user confirms the amount in cart and proceeds to checkout")
    public void userConfirmsTheAmountInCartAndProceedsToCheckout() throws InterruptedException {
        landingPage.clickCartIcon();
        softAssert.assertEquals(testContextSetup.testIntVariable, landingPage.getItemAmount());
        landingPage.clickCheckoutButton();
        softAssert.assertAll();
    }
}
