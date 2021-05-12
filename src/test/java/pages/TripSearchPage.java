package pages;

import elements.Button;
import elements.Calendar;
import elements.Input;
import elements.RadioButton;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;
import utils.PropertyReader;

public class TripSearchPage extends BasePage {

    public static final String originRoute = "search-item departure";
    public static final String destinationRoute = "search-item return";
    public static final String feedbackLocator = "//div[@id='_hj_feedback_container']//button";
    protected WebDriverWait wait;
    public static final String AIRPOR_FIELD = "//div[contains(@class,'%s')]//div/input";
    public static final String CALENDAR_DATE = "//div[@id='calendar-root']/button[contains(@class,'filled_ptf')]";

    public TripSearchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 25);
    }

    @Step("Открытие начальной страницы поиска путешествия")
    public void open() {
        driver.get(System.getenv().getOrDefault(propertyPath, PropertyReader.getProperty("URL")));
    }

    @Step("Выбор типа путешествия radioButton (туда)")
    public void tripTypeRadioButtonSelect(String tripType) {
        new RadioButton(driver, tripType).select();
    }

    //TODO удалить метод
    public void isFeedbackDisplayed() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(feedbackLocator))));
        } catch (NoSuchElementException |TimeoutException exception) {
            Assert.fail("FeedBack Element cannot be found");
        }
    }

    public void airportFrom(String origin) {
        new Input(driver, originRoute).selectFromDropDownAirport(origin);
    }

    public void airportTo(String destination) {
        new Input(driver, destinationRoute).selectFromDropDownAirport(destination);
    }

    public void calendarClickButton(String calendarButtonName) {
        new Button(driver, calendarButtonName).clickCalendarButton();
    }

    public void calendarSelectMonthAndDay(String month, String day) {
        new Calendar(driver, month, day).selectMonthAndDayInCalendar();
    }

    public void searchSubmit() {
        new Button(driver).clickSubmitButton();
    }

    @Step("Получаем введенное значение в поле ввода (откуда)")
    public String getAirportFromValue() {
        String value = driver.findElement(By.xpath(String.format(AIRPOR_FIELD, originRoute))).getAttribute("value");
        return value;
    }

    @Step("Получаем введенное значение в поле ввода (куда)")
    public String getAirportToValue() {
        String value = driver.findElement(By.xpath(String.format(AIRPOR_FIELD, destinationRoute))).getAttribute("value");
        return value;
    }

    @Step("Получаем введенное значение в поле ввода (значение календаря)")
    public String getCalendarDate() {
        String value = driver.findElement(By.xpath(CALENDAR_DATE)).getText();
        return value;
    }
}
