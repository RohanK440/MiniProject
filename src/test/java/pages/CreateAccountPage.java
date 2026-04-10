package pages;

import utils.Util;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    WebDriver driver;

    // Locators
    private By createAccountLink = By.linkText("Get a new Rediffmail ID");
    private By fullName = By.xpath("//input[@placeholder='Enter your full name']");
    private By rediffId = By.xpath("//input[@placeholder='Enter Rediffmail ID']");
    private By checkAvailabilityBtn = By.xpath("//input[@value='Check availability']");
    private By suggestedOption = By.xpath("//input[@name='radio_login']");
    private By password = By.id("newpasswd");
    private By rePassword = By.id("newpasswd1");
    private By day = By.xpath("//div[@class='form-group']//select[1]");
    private By month = By.xpath("//div[@class='form-group']//select[2]");
    private By year = By.xpath("//div[@class='form-group']//select[3]");
    private By genderMale = By.xpath("//input[@value='m']");
    private By countryDropdown = By.id("country");
    private By noAltIdCheckbox = By.className("nomargin");

    // Constructor
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openCreateAccountPage() {
        driver.findElement(createAccountLink).click();
    }

    public void enterName(String name) {
        driver.findElement(fullName).sendKeys(name);
    }

    public void enterRediffId(String id) {
        driver.findElement(rediffId).sendKeys(id);
    }

    public void checkAvailability() {
        driver.findElement(checkAvailabilityBtn).click();
    }

    public void selectSuggestedOption() {
        driver.findElement(suggestedOption).click();
    }
    
    public void reCheckAvailabilityAfterSuggestion() {
        driver.findElement(checkAvailabilityBtn).click();
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(rePassword).sendKeys(pwd);
    }

    public void selectDOB(String d, String m, String y) {
        new Select(driver.findElement(day)).selectByValue(d);
        new Select(driver.findElement(month)).selectByValue(m);
        new Select(driver.findElement(year)).selectByValue(y);
    }

    public void selectGenderMale() {
        driver.findElement(genderMale).click();
    }

    public void selectCountry(String countryName) {
        try {
            WebElement countryElement = driver.findElement(countryDropdown);

            // Synchronization: wait until dropdown is visible
            Util.waitForElementVisible(driver, countryElement, 10);

            Select country = new Select(countryElement);

            // Fetch all available countries
            List<WebElement> options = country.getOptions();
            System.out.println("Total countries: " + options.size());
            for (WebElement op : options) {
                System.out.println(op.getText());
            }

            // Select country by visible text
            Util.selectByVisibleText(countryElement, countryName);

            // Print selected country
            String selected = Util.getSelectedOption(countryElement);
            System.out.println("Selected country: " + selected);
        } catch (Exception e) {
            System.out.println("Error while selecting country: " + e.getMessage());
        }
    }

    public void selectNoAltIdCheckbox() {
        driver.findElement(noAltIdCheckbox).click();
    }
}