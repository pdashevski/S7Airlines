package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Deprecated
public class Input extends BaseElement {

    String name;
    String locator = "//div[contains(@class,'%s')]//div/input";

    public Input(WebDriver driver, String name) {
        super(driver);
        this.name = name;
    }

    public void write(String text) {
        try {
            Thread.sleep(5000);
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
        /*try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        isElementPresent(By.xpath("//body/div[2]/div[1]/div[3]/main[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"));
    }

    public void selectFromDropDownAirport(String text) {
        WebElement webElement = driver.findElement(By.xpath(String.format(locator, name)));
        write(text);
        webElement.sendKeys(Keys.ARROW_DOWN);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        webElement.sendKeys(Keys.ENTER);
    }
}
