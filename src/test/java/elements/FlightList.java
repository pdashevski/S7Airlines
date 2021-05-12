package elements;

import elements.base.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightList extends BaseElement {

    String segmentLocator = "//div[@data-qa='tripItem'][1]";
    String fareLocator = segmentLocator + "//div[@data-qa='tariffItem'][1]//button";
    String departureTimeBeforeSelect = "//div[@data-qa='tripItem'][1]//div[contains(@class,'segment_route__time_2BR')][1]";
    String arrivalTimeBeforeSelect = "//div[@data-qa='tripItem'][1]//div[contains(@class,'segment_route__time_2BR')][2]";
    String departureTimeAfterSelect = "//div[@class='selected_option_3PV'][1]//div[contains(@class,'segment_route__time_2BR')][1]";
    String arrivalTimeAfterSelect = "//div[@class='selected_option_3PV'][1]//div[contains(@class,'segment_route__time_2BR')][2]";

    public FlightList(WebDriver driver) {
        super(driver);
    }

    @Step("Выбор сегмента (рейса)")
    public void segment() {
        isElementPresent(By.xpath(segmentLocator));
        driver.findElement(By.xpath(segmentLocator)).click();
    }

    @Step("Выбор тарифа")
    public void fare() {
        isElementPresent(By.xpath(fareLocator));
        driver.findElement(By.xpath(fareLocator)).click();
    }

    @Step("Выборка времени \"вылета\" рейса для сравнения с итоговым результатом")
    public String flightDepartTimeBefore() {
        String value = driver.findElement(By.xpath(departureTimeBeforeSelect)).getText();
        return value;
    }

    @Step("Сравнение времени \"вылета\" рейса с ранее выбранным")
    public String flightDepartTimeAfter() {
        String value = driver.findElement(By.xpath(departureTimeAfterSelect)).getText();
        return value;
    }

    @Step("Выборка времени \"прибытия\" рейса для сравнения с итоговым результатом")
    public String flightArrivalTimeBefore() {
        String value = driver.findElement(By.xpath(arrivalTimeBeforeSelect)).getText();
        return value;
    }

    @Step("Сравнение времени \"прибытия\" рейса с ранее выбранным")
    public String flightArrivalTimeAfter() {
        String value = driver.findElement(By.xpath(arrivalTimeAfterSelect)).getText();
        return value;
    }
}
