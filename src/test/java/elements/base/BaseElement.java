package elements.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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

    public void isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException exception) {
            Assert.fail("Element" + locator + " cannot be found");
        }
    }

    public void isMonthOrDayPresentInCalendar(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException exception) {
            Assert.fail("Month in calendar" + locator + " cannot be found");
        }
    }
}
