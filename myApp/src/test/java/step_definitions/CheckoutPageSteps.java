package step_definitions;

import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class CheckoutPageSteps {
    TestContextSetup testContextSetup;

    public CheckoutPageSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("the full name of the item will be displayed")
    public void the_full_name_of_the_item_will_be_displayed() {
    }
    @Then("the user will see the correct number of items in the cart")
    public void the_user_will_see_the_correct_number_of_items_in_the_cart() {
    }
    @Then("the the Apply and Place Order buttons will be displayed")
    public void the_the_apply_and_place_order_buttons_will_be_displayed() {
    }
}
