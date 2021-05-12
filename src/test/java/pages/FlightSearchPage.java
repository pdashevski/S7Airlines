package pages;

import elements.FlightList;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class FlightSearchPage extends BasePage {

    public static final String submitButton = "//div[@data-qa='shopCart_block']//span[contains(text(),'Продолжить')]/ancestor::button";
    public static final String pageMainLocator = "//div[@data-qa='tripToBlock']//h3";
    FlightList list = new FlightList(driver);

    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void selectFare() {
        list.segment();
        list.fare();
    }

    public void flightSubmit() {
        isElementPresent(By.xpath(submitButton));
        isElementClickable(By.xpath(submitButton));
        try {
            driver.findElement(By.xpath(submitButton)).click();
        } catch (ElementClickInterceptedException exception) {
            System.out.println("Element" + submitButton + " cannot be clickable");
        }
    }

    @Step("Проверка страницы FlighSearchPage на переход с предыдущей страницы")
    public boolean isPageOpened() {
        return driver.findElement(By.xpath(pageMainLocator)).isDisplayed();
    }


    public String getTimeDepartureBeforeSelect() {
        return list.flightDepartTimeBefore();
    }

    public String getTimeArrivalBeforeSelect() {
        return list.flightArrivalTimeBefore();
    }

    public String getTimeDepartureAfterSelect() {
        return list.flightDepartTimeAfter();
    }

    public String getTimeArrivalAfterSelect() {
        return list.flightArrivalTimeAfter();
    }
}
