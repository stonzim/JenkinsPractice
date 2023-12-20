package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    private final By offersPageSearch_input = By.xpath("//*[@id='search-field']");
    private final By longName_text = By.xpath("//tbody/tr/td[1]");
    WebDriver driver;

    public OffersPage(WebDriver driver) { this.driver = driver; }

    public String getURL() { return "https://rahulshettyacademy.com/seleniumPractise/#/offers"; }

    public void searchFor(String searchItem) throws InterruptedException {
        driver.findElement(offersPageSearch_input).sendKeys(searchItem);
        Thread.sleep(1000);
    }

    public String getProductName() {
        return driver.findElement(longName_text).getText();
    }

}
