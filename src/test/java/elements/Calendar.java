package elements;

import elements.base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
