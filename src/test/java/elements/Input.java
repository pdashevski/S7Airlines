package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement {

    String name;
    String locator = "//div[contains(@class,'%s')]//div/input"; //search-item departure + search-item return

    public Input(WebDriver driver, String name) {
        super(driver);
        this.name = name;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(locator, name))).sendKeys(text);
    }

    public void selectFromDropDownAirport(String text) {
        write(text);
        WebElement webElement = driver.findElement(By.xpath(String.format(locator, name)));
        webElement.sendKeys(Keys.ARROW_DOWN);
        webElement.sendKeys(Keys.ENTER);
        /*driver.findElement(By.xpath(String.format(locator, name))).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath(String.format(locator, name))).sendKeys(Keys.ENTER);*/
    }
}
