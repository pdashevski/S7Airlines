package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Input extends BaseElement {

    String name;
    String locator = "//div[contains(@class,'%s')]//div/input";

    public Input(WebDriver driver, String name) {
        super(driver);
        this.name = name;
    }

    public void write(String text) {
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(locator, name))));
        element.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        element.sendKeys(text);
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectFromDropDownAirport(String text) throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath(String.format(locator, name)));

        write(text);
        //Thread.sleep(5000);

        webElement.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(5000);
        webElement.sendKeys(Keys.ENTER);
    }
}
