package step_definitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartSteps {
    WebDriver driver;
    String landingPageName;
    String offersPageName;

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("user searches with shortname {string} to extract actual name of product")
    public void user_searches_with_shortname_to_extract_actual_name_of_product(String shortName) throws InterruptedException {
        By landingPageSearch_input = By.xpath("//input[@type='search']");
        By longName_text = By.cssSelector("h4.product-name");

        driver.findElement(landingPageSearch_input).sendKeys(shortName);
        Thread.sleep(1000);
        landingPageName = driver.findElement(longName_text).getText().split("-")[0].trim();

    }
    @And("user searches {string} in offers page to extract actual name there as well")
    public void userSearchesInOffersPageToExtractActualNameThereAsWell(String shortName) throws InterruptedException {
        By offersPage_link = By.xpath("//a[@href='#/offers']");
        By offersPageSearch_input = By.xpath("//*[@id='search-field']");
        By longName_text = By.xpath("//tbody/tr/td[1]");
        Set<String> windows;
        Iterator<String> iterator;
        String parentWindow;
        String childWindow;

        driver.findElement(offersPage_link).click();
        windows = driver.getWindowHandles();
        iterator = windows.iterator();
        parentWindow = iterator.next();
        childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.findElement(offersPageSearch_input).sendKeys(shortName);
        Thread.sleep(1000);
        offersPageName = driver.findElement(longName_text).getText();
    }

    @Then("the names extracted from both pages will match")
    public void theNamesExtractedFromBothPagesWillMatch() {
        Assert.assertEquals(landingPageName, offersPageName);
    }
}
