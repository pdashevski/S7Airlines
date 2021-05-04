package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BaseElement {

    String label;
        String locator = "//label[contains(text(),'%s')]//parent::div";

    public RadioButton(WebDriver driver, String label) {
        super(driver);
        this.label = label;
    }

    public void select() {
        isElementPresent(By.xpath(String.format(locator, label)));
        driver.findElement(By.xpath(String.format(locator, label))).click();
    }
}
