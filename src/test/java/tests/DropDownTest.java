package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CreateAccountPage;
import utils.Util;
import org.openqa.selenium.By;

public class DropDownTest extends BaseTest {

	@Test
	public void testCreateAccountDropdown() {

	    CreateAccountPage page = new CreateAccountPage(driver);

	    try {
	        page.openCreateAccountPage();

	        page.enterName("Kamal");
	        page.enterRediffId("kamal1234");

	        // First availability check
	        page.checkAvailability();

	        // Select suggested ID
	        page.selectSuggestedOption();

	        //  Second availability check (NEW FUNCTIONALITY)
	        page.reCheckAvailabilityAfterSuggestion();

	        page.enterPassword("Kamal@1234");
	        page.selectDOB("20", "06", "2000");
	        page.selectGenderMale();

	        // Select country
	        page.selectCountry("India");

	        // Validate selected country (NEW FUNCTIONALITY)
	        String actualCountry = Util.getSelectedOption(
	                driver.findElement(By.id("country"))
	        );

	        Assert.assertEquals(
	                actualCountry,
	                "India",
	                "Country selected is not India!"
	        );

	        page.selectNoAltIdCheckbox();

	    } catch (Exception e) {
	        Assert.fail("Test failed due to exception: " + e.getMessage());
	    }
	}
}