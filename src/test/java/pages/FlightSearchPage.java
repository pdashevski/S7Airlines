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

    @Step("Выбираем сегмент, а затем тариф")
    public void selectFare() {
        list.segment();
        list.fare();
    }

    @Step("Кликаем кнопку продолжить и идем дальше по флоу")
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

    @Step("Получаем время вылета предполагаемого перелета")
    public String getTimeDepartureBeforeSelect() {
        return list.flightDepartTimeBefore();
    }

    @Step("Получаем время прибытия предполагаемого перелета")
    public String getTimeArrivalBeforeSelect() {
        return list.flightArrivalTimeBefore();
    }

    @Step("Получаем время вылета выбранного перелета")
    public String getTimeDepartureAfterSelect() {
        return list.flightDepartTimeAfter();
    }

    @Step("Получаем время прибытия выбранного перелета")
    public String getTimeArrivalAfterSelect() {
        return list.flightArrivalTimeAfter();
    }
}
