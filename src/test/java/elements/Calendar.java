package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Calendar extends BaseElement {

    String calendaDayLocator = "//time[contains(text(),'%s')]";
    String calendarMonthLocator = "//li[@data-month-name='%s']";
    String month;
    String day;

    public Calendar(WebDriver driver, String month, String day) {
        super(driver);
        this.month = month;
        this.day = day;
    }

    public void selectMonthAndDayInCalendar() {
        isMonthOrDayPresentInCalendar(By.xpath(String.format(calendarMonthLocator, month)));
        isMonthOrDayPresentInCalendar(By.xpath(String.format(calendaDayLocator, day)));
        driver.findElement(By.xpath(String.format(calendarMonthLocator + calendaDayLocator, month, day))).click();
    }

    public void isMonthOrDayPresentInCalendar(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException exception) {
            Assert.fail("Month in calendar" + locator + " cannot be found");
        }
    }
}
