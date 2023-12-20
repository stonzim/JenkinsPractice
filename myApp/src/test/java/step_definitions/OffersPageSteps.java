package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import page_objects.LandingPage;
import page_objects.OffersPage;
import utils.TestContextSetup;

public class OffersPageSteps {
    TestContextSetup testContextSetup;
    OffersPage offersPage;
    String offersPageName;

    public OffersPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        offersPage = new OffersPage(this.testContextSetup.driver);
    }

    @And("user searches {string} in offers page to extract actual name there as well")
    public void userSearchesInOffersPageToExtractActualNameThereAsWell(String shortName) throws InterruptedException {
        LandingPage landingPage = new LandingPage(this.testContextSetup.driver);
        if(!testContextSetup.driver.getCurrentUrl().equals(offersPage.getURL())) landingPage.switchToOffersPage();
        offersPage.searchFor(shortName);
        offersPageName = offersPage.getProductName();
    }

    @Then("the names extracted from both pages will match")
    public void theNamesExtractedFromBothPagesWillMatch() {
        Assert.assertEquals(testContextSetup.testVariable, offersPageName);
        testContextSetup.driver.quit();
    }
}
