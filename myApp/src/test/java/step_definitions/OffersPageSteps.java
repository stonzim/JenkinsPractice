package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import page_objects.LandingPage;
import page_objects.OffersPage;
import utils.TestContextSetup;

import java.io.IOException;

public class OffersPageSteps {
    TestContextSetup testContextSetup;
    String offersPageFullName;

    public OffersPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @And("^user searches (.+) in offers page to extract actual name there as well$")
    public void userSearchesInOffersPageToExtractActualNameThereAsWell(String shortName) throws InterruptedException, IOException {
        LandingPage landingPage = testContextSetup.pageObjectFactory.getLandingPage();
        OffersPage offersPage = testContextSetup.pageObjectFactory.getOffersPage();

        if(!testContextSetup.testBase.WebDriverManager().getCurrentUrl().equals(offersPage.getURL())) landingPage.clickTopDealsLink();
        testContextSetup.generalTestUtils.switchToChildWindow();
        offersPage.searchFor(shortName);
        offersPageFullName = offersPage.getProductName();
    }

    @Then("the names extracted from both pages will match")
    public void theNamesExtractedFromBothPagesWillMatch() {
        Assert.assertEquals(testContextSetup.testStringVariable, offersPageFullName);
    }
}
