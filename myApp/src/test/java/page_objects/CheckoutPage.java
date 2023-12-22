package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class CheckoutPage {
    private final By productFullName_text = By.cssSelector("p.product-name");
    private final By productQuantity_text = By.cssSelector("p.quantity");
    private final By applyPromo_button = By.cssSelector("button.promoBtn");
    private final By placeOrder_button = By.xpath("//button[contains(text(),('Place Order'))]");

    WebDriver driver;

    public CheckoutPage(WebDriver driver) { this.driver = driver; }

    public String getProductFullName() { return driver.findElement(productFullName_text).getText().split(" ")[0]; }

    public int getProductQuantity() { return Integer.parseInt(driver.findElement(productQuantity_text).getText()); }

    public boolean applyButtonWorking() {
        return driver.findElement(applyPromo_button).isDisplayed() && driver.findElement(applyPromo_button).isEnabled();
    }

    public boolean placeOrderButtonWorking() {
        return driver.findElement(placeOrder_button).isDisplayed() && driver.findElement(placeOrder_button).isEnabled();
    }
}
