package pages;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class TripSearchPage extends BasePage {

    public TripSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https:");
    }
}
