package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private final By landingPageSearch_input = By.xpath("//input[@type='search']");
    private final By longName_text = By.cssSelector("h4.product-name");
    private final By offersPage_link = By.xpath("//a[@href='#/offers']");
    private final By increaseItemAmount_button = By.cssSelector("a.increment");
    private final By addToCart_button = By.xpath("//button[contains(text(),'ADD TO CART')]");
    private final By cart_button = By.cssSelector("a.cart-icon");
    private final By itemAmount_text = By.cssSelector("div[class='cart-preview active'] div div p[class='quantity']");
    private final By proceedToCheckout_button = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

    WebDriver driver;

    public LandingPage(WebDriver driver) { this.driver = driver; }

    public String getURL() { return "https://rahulshettyacademy.com/seleniumPractise/#/"; }

    public void searchFor(String searchItem) throws InterruptedException {
        driver.findElement(landingPageSearch_input).sendKeys(searchItem);
        Thread.sleep(1000);
    }

    public String getProductName() {
        return driver.findElement(longName_text).getText().split("-")[0].trim();
    }

    public void clickTopDealsLink() {
        driver.findElement(offersPage_link).click();
    }

    public void clickAddItemAmount() {
        driver.findElement(increaseItemAmount_button).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCart_button).click();
    }

    public void clickCartIcon() {
        driver.findElement(cart_button).click();
    }

    public int getItemAmount() { return Integer.parseInt(driver.findElement(itemAmount_text).getText().split(" ")[0]);}

    public void clickCheckoutButton() throws InterruptedException {
        driver.findElement(proceedToCheckout_button).click();
        Thread.sleep(1000);
    }

}
