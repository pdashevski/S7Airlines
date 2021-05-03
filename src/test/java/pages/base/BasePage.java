package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final static String propertyPath = "src/test/resources/config.properties";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void isPageOpened() {

    }

    public void isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException exception) {
            Assert.fail("Element" + locator + " cannot be found");
        }
    }

}
