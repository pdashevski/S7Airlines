package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends BaseElement {

    String buttonName;
    String locator = "//button[contains(text(),'%s')]";
    String submitLocator = "submitButton";

    public Button(WebDriver driver, String buttonName) {
        super(driver);
        this.buttonName = buttonName;
    }

    public Button(WebDriver driver) {
        super(driver);
    }

    public void clickCalendarButton() {
        isElementPresent(By.xpath(String.format(locator, buttonName)));
        driver.findElement(By.xpath(String.format(locator, buttonName))).click();
    }

    public void clickSubmitButton() {
        isElementPresent(By.id(submitLocator));
        driver.findElement(By.id(submitLocator)).click();
    }
}
