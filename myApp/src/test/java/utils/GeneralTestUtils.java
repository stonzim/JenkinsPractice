package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Iterator;
import java.util.Set;

public class GeneralTestUtils {
    WebDriver driver;
    public GeneralTestUtils(WebDriver driver) { this.driver = driver; }

    public void switchToChildWindow() {
        Set<String> windows;
        Iterator<String> iterator;
        String parentWindow;
        String childWindow;

        windows = driver.getWindowHandles();
        iterator = windows.iterator();
        parentWindow = iterator.next();
        childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }
}
