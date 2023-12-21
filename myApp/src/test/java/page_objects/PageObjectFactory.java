package page_objects;

import org.openqa.selenium.WebDriver;

public class PageObjectFactory {
    WebDriver driver;
    public PageObjectFactory(WebDriver driver) { this.driver = driver; }

    public LandingPage getLandingPage() { return new LandingPage(driver); }

    public OffersPage getOffersPage() { return new OffersPage(driver); }

    public CheckoutPage getCheckoutPage() { return new CheckoutPage(driver); }
}
