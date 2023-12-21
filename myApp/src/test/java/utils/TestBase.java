package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//resources//global.properties"
        );
        Properties properties = new Properties();
        properties.load(fileInputStream);

        if(driver == null) {
            if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("start-maximized");
                options.addArguments("enable-automation");
                options.addArguments("--disable-infobars");

                driver = new ChromeDriver(options);
            }
            driver.get(properties.getProperty("QA-URL"));
        }

        return driver;
    }
}
