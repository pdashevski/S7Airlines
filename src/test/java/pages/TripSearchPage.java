package pages;

import elements.Button;
import elements.Calendar;
import elements.Input;
import elements.RadioButton;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.PropertyReader;

public class TripSearchPage extends BasePage {

    public static final String originRoute = "search-item departure";
    public static final String destinationRoute = "search-item return";

    public TripSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(System.getenv().getOrDefault(propertyPath, PropertyReader.getProperty("URL")));
    }

    public void tripTypeRadioButtonSelect(String tripType) {
        new RadioButton(driver, tripType).select();
    }

    public void airportFrom(String origin) throws InterruptedException {
        new Input(driver, originRoute).selectFromDropDownAirport(origin);
    }

    public void airportTo(String destination) throws InterruptedException {
        new Input(driver, destinationRoute).selectFromDropDownAirport(destination);
    }

    public void calendarClickButton(String calendarButtonName) {
        new Button(driver, calendarButtonName).clickCalendarButton();
    }

    public void calendarSelectMonthAndDay(String month, String day) {
        new Calendar(driver, month, day).selectMonthAndDayInCalendar();
    }

    public void searchSubmit() {
        new Button(driver).clickSearchSubmitButton();
    }
}
