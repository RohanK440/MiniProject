package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Util {

    // Select dropdown by visible text
    public static void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    // Select dropdown by value
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Get selected option text
    public static String getSelectedOption(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    // Explicit wait for element to be visible
    public static WebElement waitForElementVisible(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Clear and type text
    public static void clearAndType(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
}