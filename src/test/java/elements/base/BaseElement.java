package elements.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BaseElement {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    /*public void isElementPresent(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
        } catch (NoSuchElementException exception) {
            System.out.println(webElement);
            Assert.fail("Element" + webElement + " cannot be clicked or not found");
        }
    }*/
}
