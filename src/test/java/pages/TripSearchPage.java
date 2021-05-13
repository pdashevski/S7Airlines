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
    public static final String AIRPOR_FIELD = "//div[contains(@class,'%s')]//div/input";
    public static final String CALENDAR_DATE = "//div[@id='calendar-root']/button[contains(@class,'filled_ptf')]";
    protected WebDriverWait wait;

    public TripSearchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 15);
    }

    @Step("Открытие начальной страницы поиска путешествия")
    public void open() {
        driver.get(System.getenv().getOrDefault(propertyPath, PropertyReader.getProperty("URL")));
    }

    @Step("Выбор типа путешествия radioButton (туда)")
    public void tripTypeRadioButtonSelect(String tripType) {
        new RadioButton(driver, tripType).select();
    }

    public void writeToFromInput(String text) {
        String locator = "//div[contains(@class,'search-item departure')]//div/input";
        String locatorInDropDown = "//li[@id='react-autowhatever-1--item-0']";
        driver.findElement(By.xpath(locator)).click();
        //isElementPresent(By.xpath("//body/div[2]/div[1]/div[3]/main[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"));
        driver.findElement(By.xpath(locator)).sendKeys(text);
        isElementPresent(By.xpath(locatorInDropDown));
        driver.findElement(By.xpath(locatorInDropDown)).click();
    }

    public void writeToToInput(String text) {
        String locator = "//div[contains(@class,'search-item return')]//div/input";
        String locatorInDropDown = "//li[@id='react-autowhatever-1--item-0']";
        driver.findElement(By.xpath(locator)).click();
        //isElementPresent(By.xpath("//body/div[2]/div[1]/div[3]/main[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]"));
        driver.findElement(By.xpath(locator)).sendKeys(text);
        isElementPresent(By.xpath(locatorInDropDown));
        driver.findElement(By.xpath(locatorInDropDown)).click();
    }
        //TODO
    /*@Step("Заполняем поле 'откуда'")
    public void airportFrom(String origin) {
        //new Input(driver, originRoute).selectFromDropDownAirport(origin);
        String locator = "//div[contains(@class,'search-item departure')]//div/input";
    }

    @Step("Заполняем поле 'куда'")
    public void airportTo(String destination) {
        new Input(driver, destinationRoute).selectFromDropDownAirport(destination);
    }*/

    @Step("Кликаем по календарю")
    public void calendarClickButton(String calendarButtonName) {
        new Button(driver, calendarButtonName).clickCalendarButton();
    }

    @Step("Заполняем поле календаря данными и выбраем искомое значение")
    public void calendarSelectMonthAndDay(String month, String day) {
        new Calendar(driver, month, day).selectMonthAndDayInCalendar();
    }

    @Step("Отправка формы. Переход на страницу выбора конкретного рейса")
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
