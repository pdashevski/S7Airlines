package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AutoAndHotelsPage extends BasePage {

    public static final String submitButton = "//span[contains(text(),'Перейти к оплате')]/ancestor::button";

    public AutoAndHotelsPage(WebDriver driver) {
        super(driver);
    }

    public void baggageAndSeatsSubmit() {
        isElementPresent(By.xpath(submitButton));
        driver.findElement(By.xpath(submitButton)).click();
    }
}
