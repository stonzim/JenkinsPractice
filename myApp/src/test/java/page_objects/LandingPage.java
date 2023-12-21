package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private final By landingPageSearch_input = By.xpath("//input[@type='search']");
    private final By longName_text = By.cssSelector("h4.product-name");
    private final By offersPage_link = By.xpath("//a[@href='#/offers']");

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
}
