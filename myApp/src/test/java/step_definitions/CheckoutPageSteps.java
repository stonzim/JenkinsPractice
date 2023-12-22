package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import page_objects.CheckoutPage;
import utils.TestContextSetup;

import java.io.IOException;

public class CheckoutPageSteps {
    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;
    SoftAssert softAssert = new SoftAssert();

    public CheckoutPageSteps(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        checkoutPage = new CheckoutPage(this.testContextSetup.testBase.WebDriverManager());
    }

    @Then("the full name of the item will be displayed")
    public void the_full_name_of_the_item_will_be_displayed() {
        softAssert.assertEquals(testContextSetup.testStringVariable, checkoutPage.getProductFullName());
        softAssert.assertAll();
    }
    @And("the user will see the correct number of items in the cart")
    public void the_user_will_see_the_correct_number_of_items_in_the_cart() {
        softAssert.assertEquals(testContextSetup.testIntVariable, checkoutPage.getProductQuantity());
        softAssert.assertAll();
    }
    @And("the Apply and Place Order buttons will be displayed")
    public void the_apply_and_place_order_buttons_will_be_displayed() {
        softAssert.assertTrue(checkoutPage.applyButtonWorking());
        softAssert.assertTrue(checkoutPage.placeOrderButtonWorking());
        softAssert.assertAll();
    }
}
