package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class BaggageAndSeatsPage extends BasePage {

    public static final String submitButton = "//span[contains(text(),'Далее')]/ancestor::button";

    public BaggageAndSeatsPage(WebDriver driver) {
        super(driver);
    }

    public void baggageAndSeatsSubmit() {
        driver.findElement(By.xpath(submitButton)).click();
    }
}
